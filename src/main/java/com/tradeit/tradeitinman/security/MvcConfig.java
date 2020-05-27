package com.tradeit.tradeitinman.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("markets");
        registry.addViewController("/markets").setViewName("markets");
        registry.addViewController("/stocks").setViewName("stocks");
        registry.addViewController("/etf").setViewName("etf");
        registry.addViewController("/currency").setViewName("currency");
        registry.addViewController("/portfolio").setViewName("portfolio");
        registry.addViewController("/meisterView").setViewName("meisterView");

        //registry for JS / CSS and images (needed because of spring security)
        registry.addViewController("/css/main.css").setViewName("/css/main.css");
        registry.addViewController("/js/chart_movement.js").setViewName("/js/chart_movement.js");
        registry.addViewController("/js/app.js").setViewName("/js/app.js");
        registry.addViewController("/js/share_chart.js").setViewName("/js/share_chart.js");
        registry.addViewController("/js/stock_table.js").setViewName("/js/stock_table.js");
        registry.addViewController("/js/portfolio.js").setViewName("/js/portfolio.js");
    }

}