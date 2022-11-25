package com.example.sdk.noninteractive.repository;

public class NonInteractiveFunctionRepositoryProvider {

    public static NonInteractiveFunctionRepository provide() {
        return new NonInteractiveFunctionRepositoryImpl();
    }

}
