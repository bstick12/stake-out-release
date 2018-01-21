package org.bstick12.controller;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.bstick12.api.SurveillanceService;
import org.bstick12.api.Suspect;
import org.bstick12.impl.SuspectVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class SurveillanceControllerTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private SurveillanceService mockSurveillanceService;

    private SurveillanceService feignSurveillanceService;

    @Before
    public void before() {
        feignSurveillanceService = feignSurveillanceService();
        Mockito.reset(mockSurveillanceService);
    }

    @Test
    public void testSurveil() {
        Suspect suspect = SuspectVO.create("name", "type", "host");
        feignSurveillanceService.surveil(suspect);
        Mockito.verify(mockSurveillanceService).surveil(suspect);
    }


    protected SurveillanceService feignSurveillanceService() {
        return Feign.builder()
                .requestInterceptor(template -> template.header("Content-Type", "application/json"))
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(SurveillanceService.class, "http://localhost:" + randomServerPort);
    }


    @TestConfiguration
    public static class ControllerTestConfig {

        @Bean
        public SurveillanceService surveillanceService() {
            return Mockito.mock(SurveillanceService.class);
        }

    }
    
}