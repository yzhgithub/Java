package main.java.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:param.properties")
public class ParamConfig {

    // 获取用户名
    @Value("${user.name}")
     public String getUserName;
}
