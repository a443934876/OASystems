package com.example.oasystems.utils;

import org.litepal.crud.DataSupport;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/29 15:23
 * 注释说明：
 */

public class LoginIdData {

    public boolean addLoginId(String id) {
        UserData userData = new UserData();
        LoginId loginId = new LoginId();
        loginId.setName(userData.findIDByName(id));
        return loginId.save();
    }

    public void deleteLoginId() {
        DataSupport.deleteAll(LoginId.class);
    }
}