package com.r2ufuk.popgoesmyact.domain.interactors;

import com.r2ufuk.popgoesmyact.domain.entities.Actor;
import com.r2ufuk.popgoesmyact.domain.repositories.ActorRepositoryInterface;

import java.util.List;

import io.reactivex.Observable;

public class GetPopularActors extends UseCase<List<Actor>> {

    private ActorRepositoryInterface actorRepositoryInterface;

    public GetPopularActors(ActorRepositoryInterface actorRepositoryInterface){
        this.actorRepositoryInterface = actorRepositoryInterface;
    }


    @Override
    Observable<List<Actor>> buildUseCaseObservable() {
        return this.actorRepositoryInterface.popularActors();
    }
}
