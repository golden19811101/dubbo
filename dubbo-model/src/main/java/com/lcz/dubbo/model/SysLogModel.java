package com.lcz.dubbo.model;


import com.lcz.dubbo.base.BaseModel;

import java.util.Date;

/**
 * 日志表
 * @author luchunzhou
 */
public class SysLogModel extends BaseModel {

    private String operation;

    private String method;

    private String params;

    private String ip;

    private Date createDate;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}