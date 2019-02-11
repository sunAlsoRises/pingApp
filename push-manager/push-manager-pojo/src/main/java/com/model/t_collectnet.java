package com.model;

public class t_collectnet {
	private String collectnetid;

	private String collectneturl;

	private Integer collectnetstatus;

	private String collectnetname;

	private Integer collectnetnum;

	private String collectnetuser;

	public String getCollectnetid() {
		return collectnetid;
	}

	public void setCollectnetid(String collectnetid) {
		this.collectnetid = collectnetid == null ? null : collectnetid.trim();
	}

	public String getCollectneturl() {
		return collectneturl;
	}

	public void setCollectneturl(String collectneturl) {
		this.collectneturl = collectneturl == null ? null : collectneturl.trim();
	}

	public Integer getCollectnetstatus() {
		return collectnetstatus;
	}

	public void setCollectnetstatus(Integer collectnetstatus) {
		this.collectnetstatus = collectnetstatus;
	}

	public String getCollectnetname() {
		return collectnetname;
	}

	public void setCollectnetname(String collectnetname) {
		this.collectnetname = collectnetname == null ? null : collectnetname.trim();
	}

	public Integer getCollectnetnum() {
		return collectnetnum;
	}

	public void setCollectnetnum(Integer collectnetnum) {
		this.collectnetnum = collectnetnum;
	}

	public String getCollectnetuser() {
		return collectnetuser;
	}

	public void setCollectnetuser(String collectnetuser) {
		this.collectnetuser = collectnetuser == null ? null : collectnetuser.trim();
	}

}