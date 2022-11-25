package com.example.sdk.interactive.usecase;

import com.example.sdk.common.repository.InteractiveFunctionResultRepository;

public class PrepareCancelUseCaseImpl implements PrepareCancelUseCase {

    private final InteractiveFunctionResultRepository interactiveFunctionResultRepository;

    PrepareCancelUseCaseImpl(
            InteractiveFunctionResultRepository interactiveFunctionResultRepository) {

        this.interactiveFunctionResultRepository = interactiveFunctionResultRepository;
    }

    @Override
    public void execute() {
        interactiveFunctionResultRepository.clear();
    }
}
