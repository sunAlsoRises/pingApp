package com.model;

public class t_diagnosis {
    private String diagnosisid;

    private String diagnosisip;

    private String diagnosisgetway;

    private String diagnosisdns;

    private String diagnosiscpu;

    private String diagnosismemory;

    public String getDiagnosisid() {
        return diagnosisid;
    }

    public void setDiagnosisid(String diagnosisid) {
        this.diagnosisid = diagnosisid == null ? null : diagnosisid.trim();
    }

    public String getDiagnosisip() {
        return diagnosisip;
    }

    public void setDiagnosisip(String diagnosisip) {
        this.diagnosisip = diagnosisip == null ? null : diagnosisip.trim();
    }

    public String getDiagnosisgetway() {
        return diagnosisgetway;
    }

    public void setDiagnosisgetway(String diagnosisgetway) {
        this.diagnosisgetway = diagnosisgetway == null ? null : diagnosisgetway.trim();
    }

    public String getDiagnosisdns() {
        return diagnosisdns;
    }

    public void setDiagnosisdns(String diagnosisdns) {
        this.diagnosisdns = diagnosisdns == null ? null : diagnosisdns.trim();
    }

    public String getDiagnosiscpu() {
        return diagnosiscpu;
    }

    public void setDiagnosiscpu(String diagnosiscpu) {
        this.diagnosiscpu = diagnosiscpu == null ? null : diagnosiscpu.trim();
    }

    public String getDiagnosismemory() {
        return diagnosismemory;
    }

    public void setDiagnosismemory(String diagnosismemory) {
        this.diagnosismemory = diagnosismemory == null ? null : diagnosismemory.trim();
    }
}