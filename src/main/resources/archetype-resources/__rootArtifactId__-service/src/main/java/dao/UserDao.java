#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import ${package}.common.model.User;
import ${package}.common.model.query.UserQuery;
import ${package}.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/1.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper masterUserMapper;
    @Autowired
    private UserMapper slaveUserMapper;

    public List<User> selectUsers(UserQuery userQuery) {
        return slaveUserMapper.selectUsers(userQuery);
    }

    public int insertSelective(User user) {
        return masterUserMapper.insertSelective(user);
    }
}
