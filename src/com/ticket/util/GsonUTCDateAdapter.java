package com.ticket.util;


import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonUTCDateAdapter implements JsonSerializer<Date>,JsonDeserializer<Date> {

    private final DateFormat dateFormat;

    public GsonUTCDateAdapter() {
      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);      //This is the format I need
      dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));                    //This is the key line which converts the date to UTC which cannot be accessed with the default serializer
    }

    @Override 
    public synchronized JsonElement serialize(Date date,Type type,JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(dateFormat.format(date));
    }

    @Override public synchronized Date deserialize(JsonElement jsonElement,Type type,JsonDeserializationContext jsonDeserializationContext) {
      try {
        return dateFormat.parse(jsonElement.getAsString());
      } catch (java.text.ParseException e) {
        throw new JsonParseException(e);
      }
    }
}
