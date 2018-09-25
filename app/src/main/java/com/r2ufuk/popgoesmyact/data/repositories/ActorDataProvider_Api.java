package com.r2ufuk.popgoesmyact.data.repositories;

import com.r2ufuk.popgoesmyact.data.entities.ActorData;
import com.r2ufuk.popgoesmyact.data.web.Api;

import java.util.List;

import io.reactivex.Observable;

public class ActorDataProvider_Api implements ActorDataProvider {

    private Api api;

    private final int VISIBLE_PAGE_MAX = 10;


    ActorDataProvider_Api(Api api){
        this.api = api;
    }

    @Override
    public Observable<List<ActorData>> actorList() {
        return this.api.actorDataList(VISIBLE_PAGE_MAX);
    }
}
