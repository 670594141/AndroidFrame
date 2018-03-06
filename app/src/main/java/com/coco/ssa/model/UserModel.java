package com.coco.ssa.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 2018/1/26.
 */

public class UserModel {
    List<UserBean> userModel = new ArrayList<>();

    public List<UserBean> getUserModel() {
        return userModel;
    }

    public void setUserModel(List<UserBean> userModel) {
        this.userModel = userModel;
    }

}
