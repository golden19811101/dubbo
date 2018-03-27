package com.lcz.dubbo.core.base;

import java.io.Serializable;

/**
 * @author:luchunzhou
 * @date:2018/3/27
 * @time:14:07
 */
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = 7258436689721815928L;

    /**
     * 主键
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
