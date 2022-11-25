package com.example.sdk.common.repository;

public class InteractiveFunctionResultRepositoryImpl implements InteractiveFunctionResultRepository {

    private static final int DEFAULT_RESULT = 0;

    private int result = DEFAULT_RESULT;

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void clear() {
        result = DEFAULT_RESULT;
    }
}
