package com.embedded.mot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MotApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotApplication.class, args);
    }

    @Bean
    ObjectMapper myObjectMapper() {
        Hibernate5Module m = new Hibernate5Module();
        m.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(m);
        return mapper;
    }
}
