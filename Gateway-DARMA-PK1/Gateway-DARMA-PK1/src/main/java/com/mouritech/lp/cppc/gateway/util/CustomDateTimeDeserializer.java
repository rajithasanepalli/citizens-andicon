package com.mouritech.lp.cppc.gateway.util;

import java.io.IOException;

import org.joda.time.LocalDateTime;
import org.joda.time.format.ISODateTimeFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Custom Jackson deserializer for transforming a JSON object to a Joda DateTime
 * object.
 */
public class CustomDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		JsonToken t = jp.getCurrentToken();
		if (t == JsonToken.VALUE_STRING) {
			String str = jp.getText().trim();
			return ISODateTimeFormat.dateTimeParser().parseLocalDateTime(str);
		}
		if (t == JsonToken.VALUE_NUMBER_INT) {
			return new LocalDateTime(jp.getLongValue());
		}
		throw ctxt.mappingException(handledType());
	}
}
