package com.r2ufuk.popgoesmyact.domain.interactors;

import com.r2ufuk.popgoesmyact.domain.entities.Actor;
import com.r2ufuk.popgoesmyact.domain.repository.ActorRepository;

import java.util.List;

import io.reactivex.Observable;

public class GetPopularActors {

    private final ActorRepository actorRepository;

    GetPopularActors(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    public Observable<List<Actor>> execute(){
        return this.actorRepository.popularActors();
    }
}
