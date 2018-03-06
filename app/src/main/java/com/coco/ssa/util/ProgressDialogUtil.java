package com.coco.ssa.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.coco.ssa.R;

public class ProgressDialogUtil {
	private static ProgressDialog progress;
	private static Context context;

    public static void init(Context context) {
        ProgressDialogUtil.context = context;
		if (progress==null) {
			progress = new ProgressDialog(context, R.style.AppTheme_Dialog);
			progress.setCanceledOnTouchOutside(false);
		}
    }
    public static void onDestroy(){
        progress.dismiss();
		context = null;
		progress = null;
	}

    public static void showProgress(String message) {
		showProgress();
		setMessage(message);
	}

	public static void showLoading(){
		showProgress();
		setMessage(context.getString(R.string.loading));
	}

	/**
	 * 通过setMessage和showProgress，可以实现进度条的显示 在按后退键的时候消失且不会再弹对话框。
	 *
	 * @param message
	 */
	public static void setMessage(String message) {
		progress.setMessage(message);
	}

	public static void showProgress() {
		if (progress!=null&&!progress.isShowing()) {
			progress.show();
		}
	}

	public static void dismiss() {
		if (progress != null && progress.isShowing()) {
			progress.dismiss();
		}
	}

	public static boolean isShowing() {
		if(progress==null){
			return false;
		}
		return progress.isShowing();
	}
	/**
	 * 得到dialog对象，分享时的dialog可以用这个
	 */
	public static ProgressDialog getDialog(Context context,String content){
		if (progress ==null) {
			progress = new ProgressDialog(context);
		}
		progress.setMessage(content);
		return progress;
	}
}
