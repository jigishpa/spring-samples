package com.senyume.taskmaster.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author jigish
 */

public class CalendarSerializer extends JsonSerializer<Calendar>{

        @Override
        public void serialize(Calendar calendar, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss Z"); // Z - RFC 822 time zone

            jgen.writeString(simpleDateFormat.format(calendar.getTime()));

        }

}
