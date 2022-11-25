package com.example.sdk.interactive.usecase;

import android.content.Context;

import com.example.sdk.common.repository.InteractiveFunctionResultRepository;
import com.example.sdk.common.repository.InteractiveFunctionResultRepositoryProvider;

public class InteractiveFunctionUseCaseHelperProvider {

    public static InteractiveFunctionUseCaseHelper provide(Context context) {

        InteractiveFunctionResultRepository interactiveFunctionResultRepository = InteractiveFunctionResultRepositoryProvider.provide();

        return new InteractiveFunctionUseCaseHelperImpl(
                new PrepareResultUseCaseImpl(interactiveFunctionResultRepository),
                new PrepareCancelUseCaseImpl(interactiveFunctionResultRepository)
        );
    }
}
