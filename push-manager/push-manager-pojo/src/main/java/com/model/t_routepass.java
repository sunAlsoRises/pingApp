package com.model;

public class t_routepass {
    private String routepassid;

    private String routepassip;

    private Long routepassjump;

    private Integer routepassistimeout;

    private String tracerouteid;

    public String getRoutepassid() {
        return routepassid;
    }

    public void setRoutepassid(String routepassid) {
        this.routepassid = routepassid == null ? null : routepassid.trim();
    }

    public String getRoutepassip() {
        return routepassip;
    }

    public void setRoutepassip(String routepassip) {
        this.routepassip = routepassip == null ? null : routepassip.trim();
    }

    public Long getRoutepassjump() {
        return routepassjump;
    }

    public void setRoutepassjump(Long routepassjump) {
        this.routepassjump = routepassjump;
    }

    public Integer getRoutepassistimeout() {
        return routepassistimeout;
    }

    public void setRoutepassistimeout(Integer routepassistimeout) {
        this.routepassistimeout = routepassistimeout;
    }

    public String getTracerouteid() {
        return tracerouteid;
    }

    public void setTracerouteid(String tracerouteid) {
        this.tracerouteid = tracerouteid == null ? null : tracerouteid.trim();
    }
}