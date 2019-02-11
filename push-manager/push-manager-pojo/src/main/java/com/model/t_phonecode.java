package com.model;

import java.util.Date;

public class t_phonecode {
    private String code;

    private String phonr;

    private Date starttime;

    private Date endtime;

    private Integer isused;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPhonr() {
        return phonr;
    }

    public void setPhonr(String phonr) {
        this.phonr = phonr == null ? null : phonr.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getIsused() {
        return isused;
    }

    public void setIsused(Integer isused) {
        this.isused = isused;
    }
}