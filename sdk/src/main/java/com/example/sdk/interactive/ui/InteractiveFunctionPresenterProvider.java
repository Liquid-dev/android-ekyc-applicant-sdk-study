package com.example.sdk.interactive.ui;

import android.content.Context;

import com.example.sdk.interactive.usecase.InteractiveFunctionUseCaseHelperProvider;

class InteractiveFunctionPresenterProvider {

    public static InteractiveFunctionPresenter provide(Context context) {
        return new InteractiveFunctionPresenter(
                InteractiveFunctionUseCaseHelperProvider.provide(context)
        );
    }

}
