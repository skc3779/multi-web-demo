package com.web.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by seokangchun on 14. 11. 28..
 */
@Configuration
@ComponentScan(basePackages = {"com.web.utils"})
public class CommonConfiguration {
}
