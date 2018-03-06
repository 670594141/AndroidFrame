package com.coco.ssa.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Hoyn
 * @version 1.0
 * @Title：SAFEYE@
 * @Description：
 * @date 2015-4-14 下午1:17:47
 */
@SuppressLint("ValidFragment")
public abstract class BaseFragment extends Fragment {

    protected final String RX_ASYN_TAG = getClass().getSimpleName();

    private Context context;
    protected Bundle bundle;
    private View rootView;
    //fragment控制(恢复状态)
    protected Fragment mLastFragment;
    private int layoutId;
    Unbinder unbinder;
    //当前fragment是否可见
    protected boolean isVisible = false;

    public BaseFragment() {
    }

    protected BaseFragment(Context context, Bundle bundle) {
        this.context = context;
        this.bundle = bundle;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        isCreate = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(layoutInit(), container, false);
            unbinder = ButterKnife.bind(this, rootView);
            viewInit();
            bindPresenter();
            bindEvent();
        }
        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        return rootView;
    }


    protected abstract int layoutInit();

    protected void bindPresenter() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    /**
     * 绑定事件
     *
     * @author liu_haifang
     * @date 2015-4-9 下午5:05:22
     */
    protected abstract void bindEvent();

    protected void viewInit() {
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            isVisible = false;
            this.onTransformPause();
        } else {
            isVisible = true;
            this.onTransformResume();
        }
    }

    /**
     * fragment隐藏时做的事情
     */
    protected void onTransformPause() {

    }

    /**
     * fragment显示时做的事情
     */
    protected void onTransformResume() {

    }

    /**
     * 是否创建
     */
    protected boolean isCreate = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isCreate) {
            //相当于Fragment的onResume
            //在这里处理加载数据等操作
            onResume();
        } else {
            //相当于Fragment的onPause
            onPause();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    //利用反射获取fragment实例，如果该实例已经创建，则用不再创建。
    protected Fragment getFragmentInstance(Class fragmentClass) {
        FragmentManager fm = getChildFragmentManager();

        //查找是否已存在,已存在则不需要重发创建,切换语言时系统会自动重新创建并attch,无需手动创建
        Fragment fragment = fm.findFragmentByTag(fragmentClass.getSimpleName());
        if (fragment != null) {
            return fragment;
        } else {
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return fragment;
        }
    }

    /**
     * fragment切换
     *
     * @param fragment
     * @param layoutId
     * @return 最后显示的fragment
     */
    protected void switchFragment(Fragment fragment, int layoutId) {
        FragmentManager fragmentManager = getChildFragmentManager();
        if (fragmentManager == null || layoutId <= 0) {
            return;
        }
        //全局的fragment对象，用于记录最后一次切换的fragment(当前展示的fragment)
        mLastFragment = fragment;
        this.layoutId = layoutId;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment != null) {
            List<Fragment> fragments = fragmentManager.getFragments();
            //先判断是否为空
            if (fragments != null) {
                for (Fragment mfragment : fragments) {
                    //再把现在显示的fragment 隐藏掉
                    if (!mfragment.isHidden()) {
                        transaction.hide(mfragment);
                    }
                }
            }
            //显示现在的fragment
            if (!fragment.isAdded()) {
                // transaction.addToBackStack(null);
                transaction.add(layoutId, fragment, fragment.getClass().getSimpleName());
            } else {
                transaction.show(fragment);
            }
        }
        transaction.commit();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        //存储最后一个fragment对象
        if (mLastFragment != null) {
            outState.putString("fragment", mLastFragment.getClass().getName());
            outState.putInt("layoutId", layoutId);
        }
        super.onSaveInstanceState(outState);
    }


    /**
     * 出来fragment的返回键监听
     *
     * @return
     */
    protected boolean onBackPressed() {
        return true;
    }

    protected void setTextViewSize(TextView tv, int dimenId) {
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(dimenId));
    }
}
