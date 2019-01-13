package com.snd.test.http;

import com.google.gson.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Convenience class that deserializes anonymous JSON arrays/lists into a typed array list
 */
public class AnonymousArrayDeserializer implements JsonDeserializer<Collection<?>> {

    private Gson gson;
    public AnonymousArrayDeserializer() {
        gson = new Gson();
    }

    @Override
    public Collection<?> deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context) throws JsonParseException {
        Type realType = ((ParameterizedType)typeOfT).getActualTypeArguments()[0];
        return parseAsArrayList(json, realType);
    }

    @SuppressWarnings("unchecked")
    private <T> ArrayList<T> parseAsArrayList(JsonElement json, T type) {
        ArrayList<T> newArray = new ArrayList<>();
        JsonArray array= json.getAsJsonArray();

        for (JsonElement element : array) {
            T object = (T) gson.fromJson(element, (Class<?>) type);
            newArray.add(object);
        }

        return newArray;
    }

}
