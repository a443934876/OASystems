package com.example.oasystems.utils;
import org.litepal.crud.DataSupport;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/22 10:04
 * 注释说明：
 */

public class Users extends DataSupport {

    private String name;
    private String user_id;
    private String password;
    private String e_mail;
    private String confirm_Pass;
    private String phone_Number;
    private String sex;
    private byte[] head_shot;

    public byte[] getHead_shot() {
        return head_shot;
    }

    public void setHead_shot(byte[] head_shot) {
        this.head_shot = head_shot;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


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

    public String gete_mail() {
        return e_mail;
    }

    public void sete_mail(String e_mail) {
        this.e_mail = e_mail;
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

}
