package com.r2ufuk.popgoesmyact.data.repositories;

import com.r2ufuk.popgoesmyact.data.web.Api;

public class ActorDataProviderFactory {
    // For new potential sources of data
    public static ActorDataProvider produce(){
        return new ActorDataProvider_Api(new Api());
    }
}
