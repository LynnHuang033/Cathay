package com.Lynn.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.Lynn.demo.repository.ForexDataRepository;

@Configuration
public class MyConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
//    @Bean
//    public ForexDataRepository forexDataRepository() {
//        return new ForexDataRepository(); 
//    }
// 
    
}
