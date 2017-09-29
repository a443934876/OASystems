package com.example.oasystems.utils;

import org.litepal.crud.DataSupport;
import java.util.List;


/**
 * 项目名称：OASystems
 * 创建时间：2017/9/22 20:53
 * 注释说明：
 */

public class UserData {
    public boolean findUserByPwd(String name,String password){

        List<Users> usersList = DataSupport.where("name=?",name).find(Users.class);
        if (usersList.size()<1){
            return false;
        }
        Users i = usersList.get(0);
        if (i.getPassword().equals(password)){
            return true;
        }
        return false;
    }


   public int findUserByName(String userName){
        int result=0;
        List<Users> usersList= DataSupport.where("name=?",userName).find(Users.class);
        result=usersList.size();
        return result;
    }
    public int findUserByE_Mail(String userE_Mail){
        int result=0;
        List<Users> usersList= DataSupport.where("e_mall=?",userE_Mail).find(Users.class);
        result=usersList.size();
        return result;
    }
    public int findUserByPhone_Numbe(String userPhone_Number){
        int result=0;
        List<Users> usersList= DataSupport.where("phone_Number=?",userPhone_Number).find(Users.class);
        result=usersList.size();
        return result;
    }
    public boolean saveUserData(String name, String password,String confirm_Pass,
                         String e_mall,  String phone_Number, String sex){
        Users users= new Users();
        users.setName(name);
        users.setPassword(password);
        users.setConfirm_Pass(confirm_Pass);
        users.setE_mall(e_mall);
        users.setPhone_Number(phone_Number);
        users.setSex(sex);
        users.save();
        return users.save();
    }
}
