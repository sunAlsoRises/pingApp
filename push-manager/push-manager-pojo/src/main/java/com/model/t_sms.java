package com.model;

import java.util.Date;

public class t_sms {
    private String smsid;

    private String smsphone;

    private String smscode;

    private Date smscreatetime;

    private Date smsendtime;

    private Integer smsuesd;

    public String getSmsid() {
        return smsid;
    }

    public void setSmsid(String smsid) {
        this.smsid = smsid == null ? null : smsid.trim();
    }

    public String getSmsphone() {
        return smsphone;
    }

    public void setSmsphone(String smsphone) {
        this.smsphone = smsphone == null ? null : smsphone.trim();
    }

    public String getSmscode() {
        return smscode;
    }

    public void setSmscode(String smscode) {
        this.smscode = smscode == null ? null : smscode.trim();
    }

    public Date getSmscreatetime() {
        return smscreatetime;
    }

    public void setSmscreatetime(Date smscreatetime) {
        this.smscreatetime = smscreatetime;
    }

    public Date getSmsendtime() {
        return smsendtime;
    }

    public void setSmsendtime(Date smsendtime) {
        this.smsendtime = smsendtime;
    }

    public Integer getSmsuesd() {
        return smsuesd;
    }

    public void setSmsuesd(Integer smsuesd) {
        this.smsuesd = smsuesd;
    }
}