package com.r2ufuk.popgoesmyact.presentation.view;

import android.content.Context;

public interface BaseView {

    void showRetry();

    void hideRetry();

    void showError(String errorMessage);
}
