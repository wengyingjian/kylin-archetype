#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import com.wengyingjian.kylin.common.model.Result;
import com.wengyingjian.kylin.common.utils.ResultUtil;
import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import ${package}.common.enums.UserType;
import ${package}.common.model.User;
import ${package}.common.model.query.UserQuery;
import ${package}.common.service.UserService;
import ${package}.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/1.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result<List<User>> findUsers(Integer type) {
        if (!validateUserType(type)) {
            return ResultUtil.genCommonError("target type:%s not supported!", type);
        }
        UserQuery userQuery = new UserQuery();
        userQuery.setType(type);
        return ResultUtil.genSuccessResult(userDao.selectUsers(userQuery));
    }

    @Override
    public Result<Boolean> addUser(User user) {
        if (user == null) {
            return ResultUtil.genCommonError("target user can not be null");
        }
        int affectedRows = userDao.insertSelective(user);
        boolean result = affectedRows == 0 ? false : true;
        return ResultUtil.genSuccessResult(result);
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

}
