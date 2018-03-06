package com.coco.ssa.base;

import java.lang.ref.WeakReference;

/**
 * Created by Hoyn on 17/4/6.
 */

public class BasePresenter<T> {
    WeakReference<T> weakReference;

    public BasePresenter(T root) {
        weakReference = new WeakReference(root);
    }

    public T getActivity() {
        return weakReference.get();
    }

    public T getFragment() {
        return weakReference.get();
    }

}
