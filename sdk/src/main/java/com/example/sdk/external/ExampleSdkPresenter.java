package com.example.sdk.external;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.example.sdk.external.ExampleSdkCommon.REQUEST_CODE_INTERACTIVE_FUNCTION;

import com.example.sdk.common.repository.InteractiveFunctionResultRepository;
import com.example.sdk.noninteractive.usecase.NonInteractiveFunctionUseCase;

public class ExampleSdkPresenter {

    private final NonInteractiveFunctionUseCase nonInteractiveFunctionUseCase;
    private final InteractiveFunctionResultRepository interactiveFunctionResultRepository;

    public ExampleSdkPresenter(
            NonInteractiveFunctionUseCase nonInteractiveFunctionUseCase,
            InteractiveFunctionResultRepository interactiveFunctionResultRepository
    ) {
        this.nonInteractiveFunctionUseCase = nonInteractiveFunctionUseCase;
        this.interactiveFunctionResultRepository = interactiveFunctionResultRepository;
    }

    public void onNonInteractiveFunction(String parameter, final ExampleNonInteractiveFunctionCallback callback) {
        nonInteractiveFunctionUseCase.execute(parameter, result -> {
            callback.onComplete(result);
            return null;
        });
    }

    public void onInteractiveFunction(String parameter, ExampleSdkRouter router) {
        interactiveFunctionResultRepository.clear();
        router.goToInteractiveFunction(parameter);
    }

    public void onHandleInteractiveFunctionResult(int requestCode, int resultCode, ExampleInteractiveFunctionCallback callback) {
        if (requestCode != REQUEST_CODE_INTERACTIVE_FUNCTION) {
            return;
        }
        if (resultCode == RESULT_OK || resultCode == RESULT_CANCELED) {
            callback.onComplete(interactiveFunctionResultRepository.getResult());
        }
    }

}
