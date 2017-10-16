package com.example.oasystems.utils;

import org.litepal.crud.DataSupport;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/29 15:20
 * 注释说明：
 */

public class LoginId extends DataSupport {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
