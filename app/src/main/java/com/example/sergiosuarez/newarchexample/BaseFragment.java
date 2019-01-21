package com.example.sergiosuarez.newarchexample;

import android.support.v4.app.Fragment;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseFragment extends Fragment {

    private CompositeDisposable mCompositeDisposable;

    public BaseFragment() {
        super();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mCompositeDisposable != null) {
            clearCompositeDisposable();
        }
    }

    public boolean addDisposable(final Disposable d) {
        return mCompositeDisposable.add(d);
    }

    public void clearCompositeDisposable() {
        mCompositeDisposable.clear();
    }

}
