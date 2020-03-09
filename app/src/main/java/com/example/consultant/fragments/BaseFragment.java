package com.example.consultant.fragments;

        import android.content.Context;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.util.AttributeSet;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import java.util.jar.Attributes;

public abstract class BaseFragment extends Fragment {

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = onSubViewLoaded(inflater, container);

        return mRootView;
    }
    protected abstract View onSubViewLoaded(LayoutInflater inflater, ViewGroup container);
}
