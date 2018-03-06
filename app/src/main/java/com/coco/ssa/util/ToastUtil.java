package com.coco.ssa.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coco.ssa.R;
import com.coco.ssa.base.BaseApplication;
import com.coco.ssa.util.image.ImageUtil;


public class ToastUtil  extends  Toast{

	private static ToastUtil mToast;
	private static ImageView mImageView;
	private static TextView mTextView;


	/**
	 * Construct an empty Toast object.  You must call {@link #setView} before you
	 * can call {@link #show}.
	 *
	 * @param context The context to use.  Usually your {@link Application}
	 *                or {@link Activity} object.
	 */
	public ToastUtil(Context context) {
		super(context);
	}


	/**
	 * 自定义Toast样式
	 *
	 * @description
	 * @param context
	 * @param text
	 * @param duration
	 *            hrq 2014-7-10下午2:15:36
	 */

	public static ToastUtil makeText(Context context, CharSequence text,
                                     int duration) {
		mToast = new ToastUtil(context);

		// 获取LayoutInflater对象
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// 由layout文件创建一个View对象
		View layout = inflater.inflate(R.layout.toast, null);

		// 实例化ImageView和TextView对象
		mImageView = (ImageView) layout.findViewById(R.id.iv_imageview);
		mTextView = (TextView) layout.findViewById(R.id.tv_textview);

		mTextView.setText(text);

		mToast.setView(layout);
		mToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		mToast.setDuration(duration);

		return mToast;
	}

	/**
	 * 设置Toast图片
	 * @param imageId
     */
	public static void setImage(int imageId){
		if(mToast==null){
			mToast = ToastUtil.makeText(BaseApplication.getContextObject(),"",Toast.LENGTH_SHORT);
		}
		ImageUtil.load(BaseApplication.getContextObject(),imageId,mImageView);
	}

	/**
	 * 显示Toast
	 * @param text 文字
     */
	public static void show(String text){
		showWithImage(text,false);
	}
	/**
	 * 显示Toast
	 * @param text 文字
	 * @param isShowImage 是否显示图片
	 */
	public static void showWithImage(String text,boolean isShowImage){
		if(mToast==null){
			mToast = ToastUtil.makeText(BaseApplication.getContextObject(),"",Toast.LENGTH_SHORT);
		}
		if(isShowImage){
			mImageView.setVisibility(View.VISIBLE);
		}else{
			mImageView.setVisibility(View.GONE);
		}
		mTextView.setText(text);
		mToast.show();
	}
}
