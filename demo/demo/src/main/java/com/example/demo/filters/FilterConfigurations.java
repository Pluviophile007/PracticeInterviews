package com.example.demo.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;

@Configuration
public class FilterConfigurations {
    @Bean
    FilterRegistrationBean<SpecificURLFilter> specificURLFilterRegistrationBean()
    {
        FilterRegistrationBean<SpecificURLFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new SpecificURLFilter());
        filterFilterRegistrationBean.setUrlPatterns(List.of("/get/napore"));
        return filterFilterRegistrationBean;
    }
}
