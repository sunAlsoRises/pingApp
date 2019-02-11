package com.model;

import java.util.Date;

public class t_traceroute {
    private String tracerouteid;

    private Date traceroutetime;

    private String tracerouteurl;

    private Long traceroutetimeout;

    private Long traceroutepostpacketloss;

    private String appid;

    private String userid;

    private String userphone;

    private String areaid;

    private String channelnote;

    private String routepass;

    private String ext2;

    private String ext3;

    private String ext4;

    private String ext5;

    private String ext6;

    public String getTracerouteid() {
        return tracerouteid;
    }

    public void setTracerouteid(String tracerouteid) {
        this.tracerouteid = tracerouteid == null ? null : tracerouteid.trim();
    }

    public Date getTraceroutetime() {
        return traceroutetime;
    }

    public void setTraceroutetime(Date traceroutetime) {
        this.traceroutetime = traceroutetime;
    }

    public String getTracerouteurl() {
        return tracerouteurl;
    }

    public void setTracerouteurl(String tracerouteurl) {
        this.tracerouteurl = tracerouteurl == null ? null : tracerouteurl.trim();
    }

    public Long getTraceroutetimeout() {
        return traceroutetimeout;
    }

    public void setTraceroutetimeout(Long traceroutetimeout) {
        this.traceroutetimeout = traceroutetimeout;
    }

    public Long getTraceroutepostpacketloss() {
        return traceroutepostpacketloss;
    }

    public void setTraceroutepostpacketloss(Long traceroutepostpacketloss) {
        this.traceroutepostpacketloss = traceroutepostpacketloss;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getChannelnote() {
        return channelnote;
    }

    public void setChannelnote(String channelnote) {
        this.channelnote = channelnote == null ? null : channelnote.trim();
    }

    public String getRoutepass() {
        return routepass;
    }

    public void setRoutepass(String routepass) {
        this.routepass = routepass == null ? null : routepass.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4 == null ? null : ext4.trim();
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5 == null ? null : ext5.trim();
    }

    public String getExt6() {
        return ext6;
    }

    public void setExt6(String ext6) {
        this.ext6 = ext6 == null ? null : ext6.trim();
    }
}