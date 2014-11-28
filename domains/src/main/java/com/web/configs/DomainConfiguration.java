package com.web.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by seokangchun on 14. 11. 28..
 */
@Configuration
@PropertySource("classpath:connect.properties")
@ComponentScan(basePackages = {"com.web.services", "com.web.utils"})
public class DomainConfiguration {
//    @Bean
//    public static HelloString helloString() {
//        return new HelloString();
//    }
}
