package com.coco.ssa.ui;

import com.coco.ssa.R;
import com.coco.ssa.base.BaseActivity;

/**
 * Created by Hoyn on 17/3/29.
 */

public class TestActivity extends BaseActivity{

    @Override
    protected int setStatusBarColor() {
        return 0;
    }

    @Override
    protected int layoutInit() {
        return R.layout.activity_main2;
    }

    @Override
    protected void bindEvent() {
    }
}
