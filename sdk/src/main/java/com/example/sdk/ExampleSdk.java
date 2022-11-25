package com.example.sdk;

import android.app.Activity;
import android.content.Context;

import com.example.sdk.external.ExampleInteractiveFunctionCallback;
import com.example.sdk.external.ExampleNonInteractiveFunctionCallback;
import com.example.sdk.external.ExampleSdkPresenter;
import com.example.sdk.external.ExampleSdkPresenterProvider;
import com.example.sdk.external.ExampleSdkRouterProvider;

public class ExampleSdk {

    private static ExampleSdk INSTANCE;

    private ExampleSdkPresenter presenter;

    public static ExampleSdk getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ExampleSdk(
                    ExampleSdkPresenterProvider.provide(context)
            );
        }
        return INSTANCE;
    }

    private ExampleSdk(ExampleSdkPresenter presenter) {
        this.presenter = presenter;
    }

    public void nonInteractiveFunction(String parameter, ExampleNonInteractiveFunctionCallback callback) {
        presenter.onNonInteractiveFunction(parameter, callback);
    }

    public void interactiveFunction(String parameter, Activity activity) {
        presenter.onInteractiveFunction(parameter, ExampleSdkRouterProvider.provide(activity));
    }

    public void handleInteractiveFunctionResult(int requestCode, int resultCode, ExampleInteractiveFunctionCallback callback) {
        presenter.onHandleInteractiveFunctionResult(requestCode, resultCode, callback);
    }

}
