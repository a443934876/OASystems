package com.example.oasystems.utils;

import android.util.Log;

import org.litepal.crud.DataSupport;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/29 15:23
 * 注释说明：
 */

public class LoginIdData {

    public boolean addLoginId(String name) {
        LoginId loginId = new LoginId();
        loginId.setName(name);
        boolean result=loginId.save();
        Log.i("TAG", "result: "+result);
        return result;
    }

    public void deleteLoginId() {
        DataSupport.deleteAll(LoginId.class);
    }
}