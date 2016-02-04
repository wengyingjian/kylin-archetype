package ${package};

import com.wengyingjian.kylin.hessian.client.utils.HessianProxyUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ${package}.common.service.UserService;

@Configuration
public class ApiConfig {

    @Value("${test.base.url}")
    private String testBaseUrl;

    @Bean
    public UserService userServiceRpc() {
        String serviceExportName = "userService";
        return UserService.class.cast(HessianProxyUtil.buildRemotingService(testBaseUrl, serviceExportName, UserService.class));
    }
}