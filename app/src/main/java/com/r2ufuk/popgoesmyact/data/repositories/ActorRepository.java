package com.r2ufuk.popgoesmyact.data.repositories;

import com.r2ufuk.popgoesmyact.data.entities.ActorDataMapper;
import com.r2ufuk.popgoesmyact.domain.entities.Actor;
import com.r2ufuk.popgoesmyact.domain.repositories.ActorRepositoryInterface;

import java.util.List;

import io.reactivex.Observable;

public class ActorRepository extends ActorRepositoryInterface {

    @Override
    public Observable<List<Actor>> popularActors() {

        ActorDataProvider actorDataProvider = ActorDataProviderFactory.produce();
        return actorDataProvider.actorList().map(ActorDataMapper::mapList);

    }
}

