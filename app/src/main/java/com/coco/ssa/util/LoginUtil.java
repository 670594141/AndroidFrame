package com.coco.ssa.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.coco.ssa.base.BaseApplication;
import com.coco.ssa.model.UserBean;
import com.coco.ssa.model.UserModel;

/**
 * Created by Steve on 2018/1/26.
 */

public class LoginUtil {

    private static String USER_KEY = "user";

    private static SharedPreferences getLoginSP() {
        return BaseApplication.getContextObject().getSharedPreferences("login", Context.MODE_PRIVATE);
    }

    public static UserModel getUserModel() {
        String users = getLoginSP().getString("user", "");
        UserModel userModel = null;
        if (TextUtils.isEmpty(users)) {
            userModel = new UserModel();
        } else {
            userModel = GsonUtil.fromJson(users, UserModel.class);
        }
        return userModel;
    }

    public static void register(UserBean user) {
        UserModel userModel = getUserModel();
        userModel.getUserModel().add(user);
        getLoginSP().edit().putString(USER_KEY, GsonUtil.toJson(userModel)).commit();
    }

    public static void setLogin(UserBean userBean) {
        if (userBean == null) {
            getLoginSP().edit().putString("login", "").commit();
        } else {
            getLoginSP().edit().putString("login", GsonUtil.toJson(userBean)).commit();
        }
    }

    public static UserBean getLogin() {
        String login = getLoginSP().getString("login", "");
        if (TextUtils.isEmpty(login)) {
            return null;
        } else {
            UserBean userBean = GsonUtil.fromJson(login, UserBean.class);
            return userBean;
        }
    }
    public static boolean isLogin(){
        UserBean login = getLogin();
        if(login==null||TextUtils.isEmpty(login.getUsername())){
            return false;
        }
        return true;
    }

}
