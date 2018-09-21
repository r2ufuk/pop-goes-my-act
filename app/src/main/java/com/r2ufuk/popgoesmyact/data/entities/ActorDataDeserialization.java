package com.r2ufuk.popgoesmyact.data.entities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class ActorDataDeserialization {
    private final Gson gson;


    public ActorDataDeserialization(Gson gson) {
        this.gson = gson;
    }

//    public List<ActorData> createActorDataList(JSONObject jsonObject){
//        Type listType = new TypeToken<ActorData>(){}.getType();
//        List<ActorData> actorDataList = new Gson().fromJson(jsonObject, listType);
//    }
}
