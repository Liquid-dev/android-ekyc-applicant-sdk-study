package com.example.sdk.noninteractive.usecase;

import androidx.arch.core.util.Function;

import com.example.sdk.noninteractive.repository.NonInteractiveFunctionRepository;

public class NonInteractiveFunctionUseCaseImpl implements NonInteractiveFunctionUseCase {

    private final NonInteractiveFunctionRepository nonInteractiveFunctionRepository;

    public NonInteractiveFunctionUseCaseImpl(NonInteractiveFunctionRepository nonInteractiveFunctionRepository) {
        this.nonInteractiveFunctionRepository = nonInteractiveFunctionRepository;
    }

    @Override
    public void execute(String parameter, Function<Boolean, Void> handler) {
        nonInteractiveFunctionRepository.call(parameter, handler);
    }

}
