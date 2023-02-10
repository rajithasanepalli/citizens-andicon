package com.mouritech.lp.cppc.gateway.util;

import java.io.IOException;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Custom Jackson serializer for transforming a Joda LocalDate object to JSON.
 */
public class CustomLocalDateSerializer extends JsonSerializer<LocalDate> {

    private static DateTimeFormatter formatter = DateTimeFormat
            .forPattern("MM-dd-yyyy");

    @Override
    public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(formatter.print(value));
    }
}
