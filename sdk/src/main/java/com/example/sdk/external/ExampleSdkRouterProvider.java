package com.example.sdk.external;

import android.app.Activity;

public class ExampleSdkRouterProvider {

    public static ExampleSdkRouter provide(Activity activity) {
        return new ExampleSdkRouterImpl(activity);
    }

}
