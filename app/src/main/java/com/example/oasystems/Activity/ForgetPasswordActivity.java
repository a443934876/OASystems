package com.example.oasystems.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oasystems.R;
import com.example.oasystems.utils.UserData;

public class ForgetPasswordActivity extends AppCompatActivity {
    private EditText et_fg_mail;
    private EditText et_fg_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        et_fg_user = (EditText) findViewById(R.id.et_fg_user);
        et_fg_mail = (EditText) findViewById(R.id.et_fg_mail);

        findViewById(R.id.bt_affirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final UserData userData = new UserData();
                int result = userData.findUserByID(et_fg_user.getText().toString());
                if (result < 1) {
                    Toast.makeText(ForgetPasswordActivity.this, "对不起，帐号不存在！", Toast.LENGTH_SHORT).show();
                } else {
                    String e_mail = userData.fingIDByEmail(et_fg_user.getText().toString());
                    if ((et_fg_mail.getText().toString()).equals(e_mail)) {
                        final EditText input = new EditText(ForgetPasswordActivity.this);
                        AlertDialog.Builder builder = new AlertDialog.Builder(ForgetPasswordActivity.this);
                        builder.setTitle("新密码：");
                        builder.setMessage("请输入新密码！");
                        builder.setView(input);
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int result = userData.updatePassword(et_fg_user.getText().toString(), input.getText().toString());
                                if (result == 1) {
                                    Toast.makeText(ForgetPasswordActivity.this, "修改成功！", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ForgetPasswordActivity.this, "修改失败！", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("取消", null);
                        builder.show();
                    } else {
                        Toast.makeText(ForgetPasswordActivity.this, "对不起，E_mail不匹配", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
