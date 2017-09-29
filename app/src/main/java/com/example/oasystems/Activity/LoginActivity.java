package com.example.oasystems.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oasystems.utils.CustomDialog;
import com.example.oasystems.R;
import com.example.oasystems.utils.LoginIdData;
import com.example.oasystems.utils.UserData;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_user;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_user = (EditText) findViewById(R.id.et_user);
        et_password = (EditText) findViewById(R.id.et_password);
        findViewById(R.id.tv_Reg_Now).setOnClickListener(this);
        findViewById(R.id.bt_login).setOnClickListener(this);
        findViewById(R.id.tv_forget_password).setOnClickListener(this);
        if (DataSupport.findFirst(com.example.oasystems.utils.Users.class) == null
                || DataSupport.findFirst(com.example.oasystems.utils.Inform.class) == null
                || DataSupport.findFirst(com.example.oasystems.utils.LoginId.class) == null){
            LitePal.getDatabase();
            Log.i("TAG", " LitePal.getDatabase()");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                loginSuccess();
                break;
            case R.id.tv_Reg_Now:
                Intent intentReg = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentReg);
                finish();
                break;
            case R.id.tv_forget_password:
                Intent intentFP = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intentFP);
                finish();
                break;
        }

    }

    public void loginSuccess() {
        if (login()){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            LoginIdData loginIdData = new LoginIdData();
            loginIdData.addLoginId( et_user.getText().toString().trim());
            finish();



        }


    }

    public boolean login() {
        UserData mUserData = new UserData();
        String user = et_user.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        int count = mUserData.findUserByName(user);
        boolean result = mUserData.findUserByPwd(user, password);
        if (!isEmpty(user, password)) {
            return false;
        }
        if (count < 1) {
            Toast.makeText(LoginActivity.this, "对不起，帐号不存在", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (result) {
            return true;
        } else {
            Toast.makeText(LoginActivity.this, "对不起，密码错误", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public boolean isEmpty(String user, String password) {
        if ("".equals(user)) {
            Toast.makeText(LoginActivity.this, "对不起，帐号不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(password)) {
            Toast.makeText(LoginActivity.this, "对不起，密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        new CustomDialog().createDialog(LoginActivity.this,"确认","取消","确认","是否退出？");
    }


}

