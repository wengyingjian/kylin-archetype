#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.service;

import com.wengyingjian.kylin.common.model.Result;
import ${package}.common.model.User;
import ${package}.common.model.query.UserQuery;
import java.util.List;


/**
 * Created by wengyingjian on 16/2/1.
 */
public interface UserService {

    /**
     * 根据userQuery查找
     *
     * @param userQuery
     * @return
     */
    public Result<List<User>> findUsers(UserQuery userQuery);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public Result<Boolean> addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    public Result<Boolean> modifyUser(User user);

}
