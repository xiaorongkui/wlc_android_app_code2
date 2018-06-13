package com.qmkj.wlc.model;

/**
 * author：rongkui.xiao --2018/5/24
 * email：dovexiaoen@163.com
 * description:
 */

public class AppUpdateModel  {


    /**
     * forceStatus : 1
     * updateExplain : 交易中心bug修改
     * appUrl : http://192.168.1.100:8080/fileservice/upload/appApk/jydp-vV2.0.0_2018-05-23.apk
     * newestVersion : V2.0.0
     */

    private String forceStatus;//是否强制更新
    private String updateExplain;//app更新的内容
    private String appUrl;//app下载的url
    private String newestVersion;//新版本号

    public String getForceStatus() {
        return forceStatus;
    }

    public void setForceStatus(String forceStatus) {
        this.forceStatus = forceStatus;
    }

    public String getUpdateExplain() {
        return updateExplain;
    }

    public void setUpdateExplain(String updateExplain) {
        this.updateExplain = updateExplain;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getNewestVersion() {
        return newestVersion;
    }

    public void setNewestVersion(String newestVersion) {
        this.newestVersion = newestVersion;
    }
}
