package com.example.sdk.interactive.usecase;

import com.example.sdk.common.repository.InteractiveFunctionResultRepository;

public class PrepareResultUseCaseImpl implements PrepareResultUseCase {

    private final InteractiveFunctionResultRepository interactiveFunctionResultRepository;

    PrepareResultUseCaseImpl(
            InteractiveFunctionResultRepository interactiveFunctionResultRepository) {

        this.interactiveFunctionResultRepository = interactiveFunctionResultRepository;
    }

    @Override
    public void execute(int result) {
        interactiveFunctionResultRepository.setResult(result);
    }
}
