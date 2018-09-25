package com.r2ufuk.popgoesmyact.data.entities;

import com.r2ufuk.popgoesmyact.data.web.ApiUtil;
import com.r2ufuk.popgoesmyact.domain.entities.Actor;

import java.util.ArrayList;
import java.util.List;

public class ActorDataMapper {



    private static Actor map(ActorData a) {
        return new Actor(a.getId(),
                a.getPopularity(),
                a.getName(),
                a.getProfile_path());
    }

    public static List<Actor> mapList(List<ActorData> actorDataList) {
        List<Actor> actorList = new ArrayList<>(1);
        for (ActorData actorData : actorDataList) {
            actorList.add(map(actorData));
        }
        return actorList;
    }

}


