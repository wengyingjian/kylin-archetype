#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import com.wengyingjian.kylin.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ${package}.common.model.User;
import ${package}.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wengyingjian on 16/2/2.
 */

@Controller
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public Result<List<User>> listUsers(HttpServletRequest request,//
                                        @RequestParam(value = "type", required = false) Integer type) {//

        return userService.listUsers(type);
    }

    @RequestMapping("update")
    public Result<Boolean> update(HttpServletRequest request,
                                  @RequestParam("user_id") Integer uid,//
                                  @RequestParam(value = "user_name", required = false) String userName,
                                  @RequestParam(value = "user_type", required = false) Integer type) {
        return userService.modifyUser(uid,userName,type);
    }
}
