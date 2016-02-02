#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.mapper;

import ${package}.common.model.User;
import ${package}.common.model.query.UserQuery;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/1.
 */
public interface UserMapper {

    int insertSelective(User user);

    List<User> selectUsers(UserQuery userQuery);

    int updateUser(User user);

}
