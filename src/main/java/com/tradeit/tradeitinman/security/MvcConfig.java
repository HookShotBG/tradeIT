package com.tradeit.tradeitinman.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("markets");
        registry.addViewController("/markets").setViewName("markets");
        registry.addViewController("/stocks").setViewName("stocks");
        registry.addViewController("/etf").setViewName("etf");
        registry.addViewController("/currency").setViewName("currency");
        registry.addViewController("/portfolio").setViewName("portfolio");
        registry.addViewController("/navigation").setViewName("/components/navigation");

    }
}