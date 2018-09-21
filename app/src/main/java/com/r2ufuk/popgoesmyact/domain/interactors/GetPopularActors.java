package com.r2ufuk.popgoesmyact.domain.interactors;

import com.r2ufuk.popgoesmyact.domain.entities.Actor;
import com.r2ufuk.popgoesmyact.domain.repositories.ActorRepositoryInterface;

import java.util.List;

import io.reactivex.Observable;

public class GetPopularActors {

    private final ActorRepositoryInterface actorRepositoryInterface;

    GetPopularActors(ActorRepositoryInterface actorRepositoryInterface){
        this.actorRepositoryInterface = actorRepositoryInterface;
    }

    public Observable<List<Actor>> execute(){
        return this.actorRepositoryInterface.popularActors();
    }
}
