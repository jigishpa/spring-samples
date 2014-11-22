package com.senyume.taskmaster.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Calendar;

/**
 * @author jigish
 */

public class CalendarDeserializer extends JsonDeserializer<Calendar> {

    private static Logger logger = Logger.getLogger(CalendarDeserializer.class);

    @Override
    public Calendar deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        String dateStr = jsonParser.getText();
        logger.info("deserializing date:" + dateStr);

        return Calendar.getInstance();

    }
}
