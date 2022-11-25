package com.example.sdk.noninteractive.usecase;

import android.content.Context;

import com.example.sdk.noninteractive.repository.NonInteractiveFunctionRepositoryProvider;

public class NonInteractiveFunctionUseCaseProvider {

    public static NonInteractiveFunctionUseCase provide(Context context) {
        return new NonInteractiveFunctionUseCaseImpl(NonInteractiveFunctionRepositoryProvider.provide());
    }

}
