package com.snd.test.http;

import com.google.gson.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class JsonArrayDeserializer implements JsonDeserializer<Collection<?>> {

    @Override
    public Collection<?> deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context) throws JsonParseException {
        Type realType = ((ParameterizedType)typeOfT).getActualTypeArguments()[0];

        return parseAsArrayList(json, realType);
    }

    /**
     * @param json
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> parseAsArrayList(JsonElement json, T type) {
        ArrayList<T> newArray = new ArrayList<>();
        Gson gson = new Gson();

        JsonArray array= json.getAsJsonArray();

        for (JsonElement element : array) {
            T object = (T) gson.fromJson(element, (Class<?>) type);
            newArray.add(object);
        }

        return newArray;
    }

}
