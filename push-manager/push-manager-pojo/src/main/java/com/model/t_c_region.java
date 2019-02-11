package com.model;

import java.util.List;

public class t_c_region {
    private Long rCode;

    private String rName;

    private String rEnName;

    private Byte rLevel;

    private Long rParentCode;

    private String rNameRelation;

    private Byte deleteFlag;
    
    private List<t_c_region> childreddemo;
    
    private int nextLevelCount;

    public Long getrCode() {
        return rCode;
    }

    public void setrCode(Long rCode) {
        this.rCode = rCode;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrEnName() {
        return rEnName;
    }

    public void setrEnName(String rEnName) {
        this.rEnName = rEnName == null ? null : rEnName.trim();
    }

    public Byte getrLevel() {
        return rLevel;
    }

    public void setrLevel(Byte rLevel) {
        this.rLevel = rLevel;
    }

    public Long getrParentCode() {
        return rParentCode;
    }

    public void setrParentCode(Long rParentCode) {
        this.rParentCode = rParentCode;
    }

    public String getrNameRelation() {
        return rNameRelation;
    }

    public void setrNameRelation(String rNameRelation) {
        this.rNameRelation = rNameRelation == null ? null : rNameRelation.trim();
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

	public List<t_c_region> getChildreddemo() {
		return childreddemo;
	}

	public void setChildreddemo(List<t_c_region> childreddemo) {
		this.childreddemo = childreddemo;
	}

	public int getNextLevelCount() {
		return nextLevelCount;
	}

	public void setNextLevelCount(int nextLevelCount) {
		this.nextLevelCount = nextLevelCount;
	}

	
    
}