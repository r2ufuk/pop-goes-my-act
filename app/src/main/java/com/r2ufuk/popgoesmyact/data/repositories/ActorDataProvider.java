package com.r2ufuk.popgoesmyact.data.repositories;

import com.r2ufuk.popgoesmyact.data.entities.ActorData;

import java.util.List;

import io.reactivex.Observable;


public interface ActorDataProvider {

    Observable<List<ActorData>> actorList();

}
