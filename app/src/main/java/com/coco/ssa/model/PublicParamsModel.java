package com.coco.ssa.model;

import com.coco.ssa.util.Utils;

/**
 * Created by Hoyn on 17/4/5.
 */

public class PublicParamsModel {
    public static final String MSUSERID = "msUserId";
    public static final String MSUSERTYPE = "msUserType";
    public static final String MSORGANIZEID = "msOrganizeId";
    public static final String MSVERSION = "msVersion";
    public static final String MSDEVICETYPE = "msDeviceType";
    public static final String MSAPPKEY = "msAppKey";
    public static final String MSTOKEN = "msToken";
    String msUserId = "";
    int  msUserType ;
    String msOrganizeId = "";
    String msVersion = Utils.getVersionName();
    int msDeviceType = 1;
    String msAppKey = Utils.getIMEI();
    String msToken= "";

    public String getMsUserId() {
        return msUserId;
    }

    public void setMsUserId(String msUserId) {
        this.msUserId = msUserId;
    }

    public int getMsUserType() {
        return msUserType;
    }

    public void setMsUserType(int msUserType) {
        this.msUserType = msUserType;
    }

    public String getMsOrganizeId() {
        return msOrganizeId;
    }

    public void setMsOrganizeId(String msOrganizeId) {
        this.msOrganizeId = msOrganizeId;
    }

    public String getMsVersion() {
        return msVersion;
    }

    public void setMsVersion(String msVersion) {
        this.msVersion = msVersion;
    }

    public int getMsDeviceType() {
        return msDeviceType;
    }

    public void setMsDeviceType(int msDeviceType) {
        this.msDeviceType = msDeviceType;
    }

    public String getMsAppKey() {
        return msAppKey;
    }

    public void setMsAppKey(String msAppKey) {
        this.msAppKey = msAppKey;
    }

    public String getMsToken() {
        return msToken;
    }

    public void setMsToken(String msToken) {
        this.msToken = msToken;
    }
}
