package com.model;

public class t_perssion {
    private String perssionid;

    private String perssionname;

    private String perssionnote;

    private String perssionsort;

    private Integer perssionstatus;

    public String getPerssionid() {
        return perssionid;
    }

    public void setPerssionid(String perssionid) {
        this.perssionid = perssionid == null ? null : perssionid.trim();
    }

    public String getPerssionname() {
        return perssionname;
    }

    public void setPerssionname(String perssionname) {
        this.perssionname = perssionname == null ? null : perssionname.trim();
    }

    public String getPerssionnote() {
        return perssionnote;
    }

    public void setPerssionnote(String perssionnote) {
        this.perssionnote = perssionnote == null ? null : perssionnote.trim();
    }

    public String getPerssionsort() {
        return perssionsort;
    }

    public void setPerssionsort(String perssionsort) {
        this.perssionsort = perssionsort == null ? null : perssionsort.trim();
    }

    public Integer getPerssionstatus() {
        return perssionstatus;
    }

    public void setPerssionstatus(Integer perssionstatus) {
        this.perssionstatus = perssionstatus;
    }
}