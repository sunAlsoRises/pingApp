package com.model;

import java.util.Date;

public class t_reportError {
    private String reporterrorid;

    private String reporterroraccount;

    private String reporterrorphone;

    private String reporterroraddress;

    private String reporterrornote;

    private String reporterrorimg1;

    private String reporterrorimg2;

    private String reporterrorimg3;

    private String reporterrorimg4;

    private String reporterrorimg5;
    
    private Date reporterrorcreatetime;

    private String reporterroruserid;
    
    private String reportlogsprogress;

    private String reportlogsuserid;

    private String reportlogstype;

    private String reportlogsclass;

    private String other;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getReporterrorid() {
        return reporterrorid;
    }

    public void setReporterrorid(String reporterrorid) {
        this.reporterrorid = reporterrorid == null ? null : reporterrorid.trim();
    }

    public String getReporterroraccount() {
        return reporterroraccount;
    }

    public void setReporterroraccount(String reporterroraccount) {
        this.reporterroraccount = reporterroraccount == null ? null : reporterroraccount.trim();
    }

    public String getReporterrorphone() {
        return reporterrorphone;
    }

    public void setReporterrorphone(String reporterrorphone) {
        this.reporterrorphone = reporterrorphone == null ? null : reporterrorphone.trim();
    }

    public String getReporterroraddress() {
        return reporterroraddress;
    }

    public void setReporterroraddress(String reporterroraddress) {
        this.reporterroraddress = reporterroraddress == null ? null : reporterroraddress.trim();
    }

    public String getReporterrornote() {
        return reporterrornote;
    }

    public void setReporterrornote(String reporterrornote) {
        this.reporterrornote = reporterrornote == null ? null : reporterrornote.trim();
    }

    public String getReporterrorimg1() {
        return reporterrorimg1;
    }

    public void setReporterrorimg1(String reporterrorimg1) {
        this.reporterrorimg1 = reporterrorimg1 == null ? null : reporterrorimg1.trim();
    }

    public String getReporterrorimg2() {
        return reporterrorimg2;
    }

    public void setReporterrorimg2(String reporterrorimg2) {
        this.reporterrorimg2 = reporterrorimg2 == null ? null : reporterrorimg2.trim();
    }

    public String getReporterrorimg3() {
        return reporterrorimg3;
    }

    public void setReporterrorimg3(String reporterrorimg3) {
        this.reporterrorimg3 = reporterrorimg3 == null ? null : reporterrorimg3.trim();
    }

    public String getReporterrorimg4() {
        return reporterrorimg4;
    }

    public void setReporterrorimg4(String reporterrorimg4) {
        this.reporterrorimg4 = reporterrorimg4 == null ? null : reporterrorimg4.trim();
    }

    public String getReporterrorimg5() {
        return reporterrorimg5;
    }

    public void setReporterrorimg5(String reporterrorimg5) {
        this.reporterrorimg5 = reporterrorimg5 == null ? null : reporterrorimg5.trim();
    }
    
    public Date getReporterrorcreatetime() {
        return reporterrorcreatetime;
    }

    public void setReporterrorcreatetime(Date reporterrorcreatetime) {
        this.reporterrorcreatetime = reporterrorcreatetime;
    }

    public String getReporterroruserid() {
        return reporterroruserid;
    }

    public void setReporterroruserid(String reporterroruserid) {
        this.reporterroruserid = reporterroruserid == null ? null : reporterroruserid.trim();
    }
    
    public String getReportlogsprogress() {
        return reportlogsprogress;
    }

    public void setReportlogsprogress(String reportlogsprogress) {
        this.reportlogsprogress = reportlogsprogress == null ? null : reportlogsprogress.trim();
    }

    public String getReportlogsuserid() {
        return reportlogsuserid;
    }

    public void setReportlogsuserid(String reportlogsuserid) {
        this.reportlogsuserid = reportlogsuserid == null ? null : reportlogsuserid.trim();
    }

    public String getReportlogstype() {
        return reportlogstype;
    }

    public void setReportlogstype(String reportlogstype) {
        this.reportlogstype = reportlogstype == null ? null : reportlogstype.trim();
    }

    public String getReportlogsclass() {
        return reportlogsclass;
    }

    public void setReportlogsclass(String reportlogsclass) {
        this.reportlogsclass = reportlogsclass == null ? null : reportlogsclass.trim();
    }

    @Override
    public String toString() {
        return "t_reportError{" +
                "reporterrorid='" + reporterrorid + '\'' +
                ", reporterroraccount='" + reporterroraccount + '\'' +
                ", reporterrorphone='" + reporterrorphone + '\'' +
                ", reporterroraddress='" + reporterroraddress + '\'' +
                ", reporterrornote='" + reporterrornote + '\'' +
                ", reporterrorimg1='" + reporterrorimg1 + '\'' +
                ", reporterrorimg2='" + reporterrorimg2 + '\'' +
                ", reporterrorimg3='" + reporterrorimg3 + '\'' +
                ", reporterrorimg4='" + reporterrorimg4 + '\'' +
                ", reporterrorimg5='" + reporterrorimg5 + '\'' +
                ", reporterrorcreatetime=" + reporterrorcreatetime +
                ", reporterroruserid='" + reporterroruserid + '\'' +
                ", reportlogsprogress='" + reportlogsprogress + '\'' +
                ", reportlogsuserid='" + reportlogsuserid + '\'' +
                ", reportlogstype='" + reportlogstype + '\'' +
                ", reportlogsclass='" + reportlogsclass + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}