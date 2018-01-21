package org.bstick12.config;

import org.bstick12.api.SurveillanceService;
import org.bstick12.impl.SurveillanceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public SurveillanceService surveillanceService() {
        return new SurveillanceServiceImpl();
    }

}
