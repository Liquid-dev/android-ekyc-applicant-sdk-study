package com.example.sdk.interactive.usecase;

public class InteractiveFunctionUseCaseHelperImpl implements InteractiveFunctionUseCaseHelper {

    private final PrepareResultUseCase prepareResultUseCase;
    private final PrepareCancelUseCase prepareCancelUseCase;

    public InteractiveFunctionUseCaseHelperImpl(
            PrepareResultUseCase prepareResultUseCase,
            PrepareCancelUseCase prepareCancelUseCase
    ) {
        this.prepareResultUseCase = prepareResultUseCase;
        this.prepareCancelUseCase = prepareCancelUseCase;
    }

    @Override
    public PrepareResultUseCase getPrepareResultUseCase() {
        return prepareResultUseCase;
    }

    @Override
    public PrepareCancelUseCase getPrepareCancelUseCase() {
        return prepareCancelUseCase;
    }
}
