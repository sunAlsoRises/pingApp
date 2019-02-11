package com.model;

import java.util.Date;

public class t_networkconnectivity {
    private String networkconnectivityid;

    private Date networkconnectivitytime;

    private String networkconnectivityurl;

    private Long networkconnectiontimeout;

    private String networkconnectionpacketloss;

    private String networkconnectionshake;

    private String appid;

    private String userid;

    private String userphone;

    private String areaid;

    private String channelnote;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private String ext5;

    private String ext6;

    public String getNetworkconnectivityid() {
        return networkconnectivityid;
    }

    public void setNetworkconnectivityid(String networkconnectivityid) {
        this.networkconnectivityid = networkconnectivityid == null ? null : networkconnectivityid.trim();
    }

    public Date getNetworkconnectivitytime() {
        return networkconnectivitytime;
    }

    public void setNetworkconnectivitytime(Date networkconnectivitytime) {
        this.networkconnectivitytime = networkconnectivitytime;
    }

    public String getNetworkconnectivityurl() {
        return networkconnectivityurl;
    }

    public void setNetworkconnectivityurl(String networkconnectivityurl) {
        this.networkconnectivityurl = networkconnectivityurl == null ? null : networkconnectivityurl.trim();
    }


    public Long getNetworkconnectiontimeout() {
		return networkconnectiontimeout;
	}

	public void setNetworkconnectiontimeout(Long networkconnectiontimeout) {
		this.networkconnectiontimeout = networkconnectiontimeout;
	}

	public String getNetworkconnectionpacketloss() {
        return networkconnectionpacketloss;
    }

    public void setNetworkconnectionpacketloss(String networkconnectionpacketloss) {
        this.networkconnectionpacketloss = networkconnectionpacketloss == null ? null : networkconnectionpacketloss.trim();
    }

    public String getNetworkconnectionshake() {
        return networkconnectionshake;
    }

    public void setNetworkconnectionshake(String networkconnectionshake) {
        this.networkconnectionshake = networkconnectionshake == null ? null : networkconnectionshake.trim();
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

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
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