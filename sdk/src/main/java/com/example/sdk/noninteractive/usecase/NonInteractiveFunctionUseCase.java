package com.example.sdk.noninteractive.usecase;

import androidx.arch.core.util.Function;


public interface NonInteractiveFunctionUseCase {

    void execute(String parameter, Function<Boolean, Void> handler);

}
