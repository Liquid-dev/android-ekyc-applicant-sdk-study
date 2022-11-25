package com.example.sdk.external;

import android.content.Context;

import com.example.sdk.common.repository.InteractiveFunctionResultRepositoryProvider;
import com.example.sdk.noninteractive.usecase.NonInteractiveFunctionUseCaseProvider;

public class ExampleSdkPresenterProvider {

    public static ExampleSdkPresenter provide(Context context) {
        return new ExampleSdkPresenter(
                NonInteractiveFunctionUseCaseProvider.provide(context),
                InteractiveFunctionResultRepositoryProvider.provide()
        );
    }

}
