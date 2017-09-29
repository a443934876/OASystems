package com.example.oasystems.utils;

import org.litepal.crud.DataSupport;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/22 10:04
 * 注释说明：
 */

public class Users extends DataSupport {

    private String name;
    private String password;
    private String e_mall;
    private String confirm_Pass;
    private String phone_Number;
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getE_mall() {
        return e_mall;
    }

    public void setE_mall(String e_mall) {
        this.e_mall = e_mall;
    }

    public String getConfirm_Pass() {
        return confirm_Pass;
    }

    public void setConfirm_Pass(String confirm_Pass) {
        this.confirm_Pass = confirm_Pass;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", e_mall='" + e_mall + '\'' +
                ", confirm_Pass='" + confirm_Pass + '\'' +
                ", phone_Number='" + phone_Number + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
