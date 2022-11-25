package com.example.sdk.external;

import android.app.Activity;

import com.example.sdk.interactive.InteractiveFunctionActivity;

class ExampleSdkRouterImpl implements ExampleSdkRouter {

    private Activity activity;

    ExampleSdkRouterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToInteractiveFunction(String parameter) {
        InteractiveFunctionActivity.startActivity(activity, parameter);
    }
}
