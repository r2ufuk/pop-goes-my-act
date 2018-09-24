package com.r2ufuk.popgoesmyact.data.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ActorDataDeserialization {

    public static List<ActorData> createActorDataList(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(jsonString);
        JsonArray results = jsonObject.get("results").getAsJsonArray();
        Type listType = new TypeToken<List<ActorData>>(){}.getType();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.fromJson(results, listType);
    }
}
