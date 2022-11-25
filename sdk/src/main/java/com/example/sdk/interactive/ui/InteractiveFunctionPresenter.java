package com.example.sdk.interactive.ui;

import com.example.sdk.interactive.router.InteractiveFunctionRouteModel;
import com.example.sdk.interactive.router.InteractiveFunctionRouter;
import com.example.sdk.interactive.usecase.InteractiveFunctionUseCaseHelper;

class InteractiveFunctionPresenter {

    private final InteractiveFunctionUseCaseHelper useCaseHelper;
    private InteractiveFunctionView view;
    private InteractiveFunctionRouter router;

    InteractiveFunctionPresenter(InteractiveFunctionUseCaseHelper useCaseHelper) {
        this.useCaseHelper = useCaseHelper;
    }

    void onAttach(InteractiveFunctionView view, InteractiveFunctionRouter router) {
        this.view = view;
        this.router = router;
    }

    void onViewCreated(String parameter) {
        view.setupView();
        view.updateParameterText(parameter);
    }

    void onClickResult(int result) {
        useCaseHelper.getPrepareResultUseCase().execute(result);
        router.finish(InteractiveFunctionRouteModel.OK);
    }

    void onClickBack() {
        useCaseHelper.getPrepareCancelUseCase().execute();
        router.finish(InteractiveFunctionRouteModel.CANCEL);
    }
}
