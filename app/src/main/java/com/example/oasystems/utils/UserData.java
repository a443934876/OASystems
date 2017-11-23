package com.example.oasystems.utils;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.litepal.crud.DataSupport;

import java.io.ByteArrayOutputStream;
import java.util.List;


/**
 * 项目名称：OASystems
 * 创建时间：2017/9/22 20:53
 * 注释说明：
 */

public class UserData {
    public boolean findUserByPwd(String user_id, String password) {
        List<Users> usersList = DataSupport.where("user_id=?", user_id).find(Users.class);
        if (usersList.size() < 1) {
            return false;
        }
        Users i = usersList.get(0);
        if (!i.getPassword().equals(password)) {
            return false;
        }
        return true;
    }

    public String findIDByName(String id) {
        List<Users> usersList = DataSupport.where("user_id=?", id).find(Users.class);
        Users users = usersList.get(0);
        return users.getName();
    }


    public int findUserByID(String userID) {
        int result;
        List<Users> usersList = DataSupport.where("user_id=?", userID).find(Users.class);
        result = usersList.size();
        return result;
    }

    public String fingIDByEmail(String id) {

        List<Users> usersList = DataSupport.where("user_id=?", id).find(Users.class);
        Users users = usersList.get(0);
        return users.gete_mail();
    }

    public int findUserByName(String userName) {
        int result;
        List<Users> usersList = DataSupport.where("name=?", userName).find(Users.class);
        result = usersList.size();
        return result;
    }

    public int findUserByE_Mail(String userE_Mail) {
        int result;
        List<Users> usersList = DataSupport.where("e_mail=?", userE_Mail).find(Users.class);
        result = usersList.size();
        return result;
    }

    public int updatePassword(String user_id, String password) {
        ContentValues values = new ContentValues();
        values.put("password", password);
        int result = DataSupport.updateAll(Users.class, values, "user_id=?", user_id);
        return result;
    }

    public int findUserByPhone_Numbe(String userPhone_Number) {
        int result;
        List<Users> usersList = DataSupport.where("phone_Number=?", userPhone_Number).find(Users.class);
        result = usersList.size();
        return result;
    }

    public boolean saveUserData(String name, String user_id, String password, String confirm_Pass,
                                String e_mail, String phone_Number, String sex) {
        Users users = new Users();
        users.setName(name);
        users.setUser_id(user_id);
        users.setPassword(password);
        users.setConfirm_Pass(confirm_Pass);
        users.sete_mail(e_mail);
        users.setPhone_Number(phone_Number);
        users.setSex(sex);
        users.save();
        return users.save();
    }

    //把图片转换为字节
    private byte[] img(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public boolean saveBitmap(Bitmap bitmap) {
        byte[] images = img(bitmap);
        LoginId loginId = DataSupport.findFirst(LoginId.class);
        String id = loginId.getName();
        List<Users> usersList = DataSupport.where("name=?", id).find(Users.class);
        Users users = usersList.get(0);
        users.setHead_shot(images);
        return users.save();
    }

    public Bitmap getBitmap() {
        LoginId loginId = DataSupport.findFirst(LoginId.class);
        String id = loginId.getName();
        List<Users> usersList = DataSupport.where("name=?", id).find(Users.class);
        Users users = usersList.get(0);
        byte[] images = users.getHead_shot();
        if (images == null) {
            return null;
        }
        return BitmapFactory.decodeByteArray(images, 0, images.length);
    }

}
