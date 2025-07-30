package com.example.raspberriesSellerService;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
    public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RaspberriesCompanyServiceApplication.class);
    }
}
