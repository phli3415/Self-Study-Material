package com.atguigu.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "spring.jdbc.datasource")//批量读取
//写通用前缀
//名字和application里后缀一样的自动赋值
public class DataSourceComponents {
//    yml读取方式和properties一致
//    缺点： 不能读取含有多个元素的数据类型（array）


//    @Value("${spring.jdbc.datasource.driverClassName}")
    private String driverClassName;

//    @Value("${spring.jdbc.datasource.url}")
    private String url;

//    @Value("${spring.jdbc.datasource.username}")
    private String username;

//    @Value("${spring.jdbc.datasource.password}")
    private String password;
}
