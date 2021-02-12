package com.kiselev.time;

import com.kiselev.time.function.FunctionConfiguration;
import com.kiselev.time.security.SecurityConfiguration;
import com.kiselev.time.service.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ServiceConfiguration.class,
        SecurityConfiguration.class,
        FunctionConfiguration.class})
public class TimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeApplication.class, args);
    }
}