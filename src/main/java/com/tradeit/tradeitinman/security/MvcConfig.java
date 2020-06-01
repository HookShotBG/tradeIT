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
        registry.addViewController("/errorhandling/error").setViewName("error");

        //registry for JS / CSS and images (needed because of spring security)
        registry.addViewController("/css/main.css").setViewName("main.css");
        registry.addViewController("/js/app.js").setViewName("app.js");
        registry.addViewController("/js/share_chart.js").setViewName("share_chart.js");
        registry.addViewController("/js/stock_table.js").setViewName("stock_table.js");
        registry.addViewController("/js/portfolio.js").setViewName("portfolio.js");
    }
}