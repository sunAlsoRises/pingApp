package com.model;

import java.util.Date;

public class t_appversion {
    private String appversionid;

    private String appversionnum;

    private String appversionnote;

    private Date appversioncreatetime;

    public String getAppversionid() {
        return appversionid;
    }

    public void setAppversionid(String appversionid) {
        this.appversionid = appversionid == null ? null : appversionid.trim();
    }

    public String getAppversionnum() {
        return appversionnum;
    }

    public void setAppversionnum(String appversionnum) {
        this.appversionnum = appversionnum == null ? null : appversionnum.trim();
    }

    public String getAppversionnote() {
        return appversionnote;
    }

    public void setAppversionnote(String appversionnote) {
        this.appversionnote = appversionnote == null ? null : appversionnote.trim();
    }

    public Date getAppversioncreatetime() {
        return appversioncreatetime;
    }

    public void setAppversioncreatetime(Date appversioncreatetime) {
        this.appversioncreatetime = appversioncreatetime;
    }
}