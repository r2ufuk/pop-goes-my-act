package com.r2ufuk.popgoesmyact.domain.interactors;

import io.reactivex.observers.DisposableObserver;

public class Observer<T> extends DisposableObserver<T> {

        @Override public void onNext(T t) {}

        @Override public void onComplete() {}

        @Override public void onError(Throwable exception) {}
}