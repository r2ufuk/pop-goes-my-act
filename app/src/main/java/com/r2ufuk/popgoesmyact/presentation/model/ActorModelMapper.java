package com.r2ufuk.popgoesmyact.presentation.model;

import com.r2ufuk.popgoesmyact.data.entities.ActorData;
import com.r2ufuk.popgoesmyact.domain.entities.Actor;

import java.util.ArrayList;
import java.util.List;

public class ActorModelMapper {

    private static ActorModel map(Actor a) {
        return new ActorModel(a.getId(),
                a.getPopularity(),
                a.getName(),
                a.getProfile_path());
    }

    public static List<ActorModel> mapList(List<Actor> actorList) {
        List<ActorModel> actorModelList = new ArrayList<>(20);
        if (actorList.size() == 0) {
            return null;
        }
        for (Actor actor : actorList) {
            actorModelList.add(map(actor));
        }
        return actorModelList;
    }

}
