package com.itdage.configuration;/**
 * Created by huayu on 2018/12/12.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @ClassName CustomCORSConfiguration
 * @Description springboot+vue跨域和避免options请求的解决方法
 * @Author huayu
 * @Date 2018/12/12 13:51
 * @Version 1.0
 **/
@Component
public class CustomCORSConfiguration {

//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        // 允许任何的head头部
//        corsConfiguration.addAllowedHeader("*");
//        // 允许任何域名使用
//        corsConfiguration.addAllowedOrigin("*");
//        // 允许任何的请求方法
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }
//
//    // 添加CorsFilter拦截器，对任意的请求使用
//    @Bean(name = "corsFilter")
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig());
//        return new CorsFilter(source);
//    }

}
