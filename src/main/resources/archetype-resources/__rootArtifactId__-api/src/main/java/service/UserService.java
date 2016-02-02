#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import com.wengyingjian.kylin.common.model.Result;
import com.wengyingjian.kylin.common.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ${package}.common.enums.UserType;
import ${package}.common.model.User;
import ${package}.common.model.query.UserQuery;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/2.
 */
@Service
public class UserService {

    @Autowired
    private your.group.id.here.common.service.UserService userServiceRpc;

    /**
     * 列出指定类型的所有用户
     *
     * @param type
     * @return
     */
    public Result<List<User>> listUsers(Integer type) {
        if (!validateUserType(type)) {
            return ResultUtil.genCommonError("target type %s not supported", type);
        }
        UserQuery userQuery = new UserQuery();
        userQuery.setType(type);
        return userServiceRpc.findUsers(userQuery);
    }

    /**
     * 验证用户的类型是否有效
     *
     * @param type
     * @return
     */
    private boolean validateUserType(Integer type) {
        if (type == null) {
            return false;
        }
        for (UserType userType : UserType.values()) {
            if (type == userType.getCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 修改指定id用户信息
     *
     * @param uid
     * @param userName
     * @param type
     * @return
     */
    public Result<Boolean> modifyUser(Integer uid, String userName, Integer type) {
        if (uid == null) {
            return ResultUtil.genCommonError("parameter uid can not be  null ");
        }
        if (StringUtils.isEmpty(userName) && type == null) {
            return ResultUtil.genCommonError("nothing to update");
        }
        if (!validateUserType(type)) {
            return ResultUtil.genCommonError("target type %s not supported", type);
        }

        User user = new User();
        user.setId(uid);
        user.setUserName(userName);
        user.setType(type);

        return userServiceRpc.modifyUser(user);
    }
}
