package com.example.sdk.common.repository;

public class InteractiveFunctionResultRepositoryProvider {

    private static InteractiveFunctionResultRepository INSTANCE;

    public static InteractiveFunctionResultRepository provide() {
        if (INSTANCE == null) {
            INSTANCE = new InteractiveFunctionResultRepositoryImpl();
        }
        return INSTANCE;
    }

}
