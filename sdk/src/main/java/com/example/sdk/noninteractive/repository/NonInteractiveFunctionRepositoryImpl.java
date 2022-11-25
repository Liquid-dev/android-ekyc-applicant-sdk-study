package com.example.sdk.noninteractive.repository;

import androidx.arch.core.util.Function;

class NonInteractiveFunctionRepositoryImpl implements NonInteractiveFunctionRepository {
    @Override
    public void call(String parameter, Function<Boolean, Void> handler) {
        boolean result = parameter != null && parameter.length() != 0;
        handler.apply(result);
    }
}
