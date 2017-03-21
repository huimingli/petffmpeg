package com.jared.helloffmpeg.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by 00013811 on 2017/3/21.
 */

public class MyUser extends BmobObject {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
