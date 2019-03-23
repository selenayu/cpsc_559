package data;

import java.lang.reflect.Type;
import java.time.Instant;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class InstantSerializer implements JsonSerializer<Instant> {
  public JsonElement serialize(Instant src, Type typeOfSrc, JsonSerializationContext context) {
    return new JsonPrimitive(src.toString());
  }
}
