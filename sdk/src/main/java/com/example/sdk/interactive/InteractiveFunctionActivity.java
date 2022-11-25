package com.example.sdk.interactive;

import static com.example.sdk.external.ExampleSdkCommon.REQUEST_CODE_INTERACTIVE_FUNCTION;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.sdk.R;
import com.example.sdk.interactive.router.InteractiveFunctionRouteModel;
import com.example.sdk.interactive.router.InteractiveFunctionRouter;
import com.example.sdk.interactive.ui.InteractiveFunctionFragment;

public class InteractiveFunctionActivity extends AppCompatActivity implements InteractiveFunctionRouter {

    private static final String PARAMETER_KEY = "parameter";

    public static void startActivity(Activity activity, String parameter) {
        Intent intent = new Intent(activity, InteractiveFunctionActivity.class);
        intent.putExtra(PARAMETER_KEY, parameter);
        activity.startActivityForResult(intent, REQUEST_CODE_INTERACTIVE_FUNCTION);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive_function);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.example_container);
        if (fragment == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.example_container, getUsingFragment())
                    .commit();
        }
    }

    @Override
    public void finish(InteractiveFunctionRouteModel routeModel) {
        Intent intent = new Intent();
        setResult(routeModel.getResultCode(), intent);
        finish();
    }

    private Fragment getUsingFragment() {
        String parameter = getIntent().getStringExtra(PARAMETER_KEY);
        return InteractiveFunctionFragment.newInstance(parameter);
    }
}