package com;

import com.demo.utils.DateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    public void addFormatters(FormatterRegistry registry) {
         registry.addConverter(new DateConverter());
    }
}
