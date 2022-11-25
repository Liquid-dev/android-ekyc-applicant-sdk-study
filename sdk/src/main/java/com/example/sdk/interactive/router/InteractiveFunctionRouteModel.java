package com.example.sdk.interactive.router;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public enum InteractiveFunctionRouteModel {
    OK(RESULT_OK),
    CANCEL(RESULT_CANCELED);

    private int resultCode;

    InteractiveFunctionRouteModel(int resultCode) {
        this.resultCode = resultCode;
    }

    public int getResultCode() {
        return resultCode;
    }
}
