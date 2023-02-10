package com.mouritech.lp.cppc.gateway.config;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.mouritech.lp.cppc.gateway.util.CustomDateTimeDeserializer;
import com.mouritech.lp.cppc.gateway.util.CustomDateTimeSerializer;
import com.mouritech.lp.cppc.gateway.util.CustomLocalDateSerializer;
import com.mouritech.lp.cppc.gateway.util.ISO8601LocalDateDeserializer;

@Configuration
public class JacksonConfiguration {

    @Bean
    public JodaModule jacksonJodaModule() {
        JodaModule module = new JodaModule();
        module.addSerializer(LocalDateTime.class, new CustomDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new CustomDateTimeDeserializer());
        module.addSerializer(LocalDate.class, new CustomLocalDateSerializer());
        module.addDeserializer(LocalDate.class, new ISO8601LocalDateDeserializer());
        return module;
    }
}
