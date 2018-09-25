package com.r2ufuk.popgoesmyact.data.web;

import com.r2ufuk.popgoesmyact.data.entities.ActorData;
import com.r2ufuk.popgoesmyact.data.entities.ActorDataDeserialization;

import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class Api {

    private static final ApiUtil apiUtil = new ApiUtil();

    private static int hour = -1;

    private final String emptyJsonResponseDummy = "{\"results\":[]}";

    private final int PAGE_COUNT = 2;

    public Api() {
    }

    public Observable<List<ActorData>> actorDataList(int pageCount) {

        return Observable.create((ObservableEmitter<List<ActorData>> emitter) -> {
            int tmpHour = LocalTime.now().getHour();
            String responseStr;
            boolean cleanFlag = true;
            cleanFlag = tmpHour != hour;
            hour = tmpHour;

            for (int i = 1; i < pageCount + 1; i++) {
                responseStr = apiUtil.getResponse(i, cleanFlag);
                if (responseStr != null) {
                    if (cleanFlag) {
                        cleanFlag = false;
                        emitter.onNext(ActorDataDeserialization.createActorDataList(emptyJsonResponseDummy));
                        emitter.onNext(ActorDataDeserialization.createActorDataList(responseStr));

                    } else {
                        emitter.onNext(ActorDataDeserialization.createActorDataList(responseStr));

                    }
                }
            }
//            emitter.onComplete();


            //            List<String> requestList = apiUtil.getMultiResponse(PAGE_COUNT, cleanFlag);
//            List<ActorData> actorDataList = new ArrayList<>();
//            if(cleanFlag){
//                cleanFlag = false;
//                emitter.onNext(ActorDataDeserialization.createActorDataList(emptyJsonResponseDummy));
//            }
//            for(String str : requestList){
//                actorDataList.addAll(ActorDataDeserialization.createActorDataList(str));
//            }


        });
    }

    public Observable<List<ActorData>> namedActors(String name) {
        return Observable.create((ObservableEmitter<List<ActorData>> emitter) -> {
            String responseStr = apiUtil.getResponse(1, false);
            List<ActorData> actorList = new ArrayList<>();
            actorList.add(ActorDataDeserialization.createActorDataList(responseStr).get(1));
            emitter.onNext(actorList);
        });
    }


    private boolean checkConnection() throws IOException, InterruptedException {
//        String command = "ping -c 1 themoviedb.org";
//        return (Runtime.getRuntime().exec(command).waitFor() == 0);
        return InetAddress.getByName("themoviedb.org").isReachable(2000);
    }

}
