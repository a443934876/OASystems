package com.example.oasystems.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.oasystems.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
