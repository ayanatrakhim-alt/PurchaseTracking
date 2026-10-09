package com.example.config;

import com.example.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public RequestPolicy requestPolicy() {
        return new RequestPolicy();
    }

    @Bean
    public Rule requestRule(RequestPolicy policy) {
        return new CompositeRule(List.of(
                new TransitionRule(policy),
                new UnapprovedCannotOrder()
        ));
    }
}