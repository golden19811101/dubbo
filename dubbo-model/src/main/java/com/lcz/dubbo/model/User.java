package com.lcz.dubbo.model;

import com.lcz.dubbo.base.BaseModel;

/**
 * Created by luchunzhou on 2018/3/5.
 */
public class User extends BaseModel {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
