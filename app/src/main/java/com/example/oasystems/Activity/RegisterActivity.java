package com.example.oasystems.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.oasystems.R;
import com.example.oasystems.utils.UserData;


import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private LitePal Users;
    private EditText et_name;
    private EditText et_reg_password;
    private EditText et_Confirm_Pass;
    private EditText et_e_mail;
    private EditText et_Phone_number;
    private RadioGroup rg_sex;
    private RadioButton woman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_name = (EditText) findViewById(R.id.et_name);
        et_reg_password = (EditText) findViewById(R.id.et_reg_password);
        et_Confirm_Pass = (EditText) findViewById(R.id.et_Confirm_Pass);
        et_e_mail = (EditText) findViewById(R.id.et_e_mail);
        et_Phone_number = (EditText) findViewById(R.id.et_Phone_number);
        findViewById(R.id.bt_exit).setOnClickListener(this);
        findViewById(R.id.bt_Confirm).setOnClickListener(this);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
        woman = (RadioButton) findViewById(R.id.woman);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_Confirm:
                register_check();
                break;
            case R.id.bt_exit:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    public void register_check() {
        UserData mUserData = new UserData();
        String name = et_name.getText().toString().trim();
        String password = et_reg_password.getText().toString().trim();
        String Confirm_Pass = et_Confirm_Pass.getText().toString().trim();
        String e_mail = et_e_mail.getText().toString().trim();
        String Phone_number = et_Phone_number.getText().toString().trim();
        String sex = getString(R.string.man);
        if (woman.getId() == rg_sex.getCheckedRadioButtonId()) {
            sex = getString(R.string.woman);
        }
        if (isUserNameAndPwdValid()&& isEmail(e_mail)
                && isMobileNO(String.valueOf(Phone_number))
                && isDiffer(password, Confirm_Pass)
                && isRepeat(mUserData, name, e_mail, Phone_number)
                  ) {
            boolean result = mUserData.saveUserData(name, password, Confirm_Pass, e_mail, Phone_number, sex);
            if (result) {
                Toast.makeText(RegisterActivity.this, "恭喜，注册成功", Toast.LENGTH_SHORT).show();
                et_name.setText("");
                et_reg_password.setText("");
                et_Confirm_Pass.setText("");
                et_e_mail.setText("");
                et_Phone_number.setText("");
            } else {
                Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public boolean isUserNameAndPwdValid() {
        if (et_name.getText().toString().trim().equals("")) {
            Toast.makeText(RegisterActivity.this, "对不起，昵称不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (et_reg_password.getText().toString().trim().equals("")) {
            Toast.makeText(RegisterActivity.this, "对不起，密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (et_Confirm_Pass.getText().toString().trim().equals("")) {
            Toast.makeText(RegisterActivity.this, "对不起，确认密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (et_e_mail.getText().toString().trim().equals("")) {
            Toast.makeText(RegisterActivity.this, "对不起，E-mail不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (et_Phone_number.getText().toString().trim().equals("")) {
            Toast.makeText(RegisterActivity.this, "对不起，手机号不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }

    /**
     * 判断手机是否合法
     *
     * @param mobiles
     * @return
     */
    public boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        if (!m.matches()) {
            Toast.makeText(RegisterActivity.this, "请输入合法的手机号", Toast.LENGTH_SHORT).show();
        }
        return m.matches();
    }

    /**
     * 判断邮箱是否合法
     *
     * @param email
     * @return
     */
    public boolean isEmail(String email) {
        if (null == email || "".equals(email)) return false;
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            Toast.makeText(RegisterActivity.this, "请输入合法的Email", Toast.LENGTH_SHORT).show();
        }
        return m.matches();
    }

    public boolean isRepeat(UserData mUserData, String name, String e_mail, String Phone_number) {
        int nameCount = mUserData.findUserByName(name);
        int e_MailCount = mUserData.findUserByE_Mail(e_mail);
        int phoneNumberCount = mUserData.findUserByPhone_Numbe(Phone_number);
        if (nameCount > 0) {
            Toast.makeText(RegisterActivity.this, "对不起，帐号重复,请重新输入", Toast.LENGTH_SHORT).show();
            return false;
        } else if (e_MailCount > 0) {
            Toast.makeText(RegisterActivity.this, "对不起，e_mail重复,请重新输入", Toast.LENGTH_SHORT).show();
            return false;
        } else if (phoneNumberCount > 0) {
            Toast.makeText(RegisterActivity.this, "对不起，手机号重复,请重新输入", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean isDiffer(String password, String Confirm_Pass) {
        boolean result = password.equals(Confirm_Pass);
        if (!result) {
            Toast.makeText(RegisterActivity.this, "对不起，两次密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

}




