package com.ibsplc.configuration.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * Created by SOORAJ on 11-12-2016.
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.ibsplc"})
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    private static final String[] RESOURCE_LOCATIONS = {
            "classpath:/static/"};

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**/Aer_lingus/**",
        		"/**/assets/**",
        		"/**/css/**",
        		"/**/fonts/**",
        		"/**/icons/**",
        		"/**/images/**",
        		"/**/img/**",
        		"/**/javascript/**",
        		"/**/js/**",
        		"/**/less/**",
        		"/**/scss/**").addResourceLocations(RESOURCE_LOCATIONS);
    }
}