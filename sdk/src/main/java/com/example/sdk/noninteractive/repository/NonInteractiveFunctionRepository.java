package com.example.sdk.noninteractive.repository;

import androidx.arch.core.util.Function;

public interface NonInteractiveFunctionRepository {

    void call(String parameter, Function<Boolean, Void> handler);

}
