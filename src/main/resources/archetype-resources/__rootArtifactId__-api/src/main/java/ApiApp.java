#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.wengyingjian.kylin", "${package}"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ApiApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class, args);
    }
}