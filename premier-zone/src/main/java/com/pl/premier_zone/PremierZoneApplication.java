package com.pl.premier_zone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PremierZoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(PremierZoneApplication.class, args);
    }

    // Ten Bean jest niezbędny, aby Spring mógł wstrzyknąć RestTemplate
    // do Twojego ExternalApiController (integracja z zewnętrznym API)
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
