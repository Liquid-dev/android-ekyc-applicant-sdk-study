package com.example.sdk.interactive.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.sdk.R;
import com.example.sdk.interactive.router.InteractiveFunctionRouter;

public class InteractiveFunctionFragment extends Fragment implements InteractiveFunctionView {

    private static final String PARAMETER_KEY = "parameter";

    private InteractiveFunctionPresenter presenter;

    private TextView parameterTextView;

    public static InteractiveFunctionFragment newInstance(String parameter) {
        InteractiveFunctionFragment fragment = new InteractiveFunctionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAMETER_KEY, parameter);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (presenter == null) {
            presenter = InteractiveFunctionPresenterProvider.provide(context);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            presenter.onAttach(this, (InteractiveFunctionRouter) activity);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_interactive_function, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String parameter = requireArguments().getString(PARAMETER_KEY);
        presenter.onViewCreated(parameter);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                presenter.onClickBack();
            }
        });
    }

    @Override
    public void setupView() {
        View rootView = getView();
        parameterTextView = rootView.findViewById(R.id.parameter_text_view);
        rootView.findViewById(R.id.result_1_button).setOnClickListener(v -> presenter.onClickResult(1));
        rootView.findViewById(R.id.result_2_button).setOnClickListener(v -> presenter.onClickResult(2));
    }

    @Override
    public void updateParameterText(String text) {
        parameterTextView.setText("Parameter: " + text);
    }
}