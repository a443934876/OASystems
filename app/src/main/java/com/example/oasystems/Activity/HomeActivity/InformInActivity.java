package com.example.oasystems.Activity.HomeActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.oasystems.Activity.MainActivity;
import com.example.oasystems.R;
import com.example.oasystems.utils.Inform;
import com.example.oasystems.utils.InformData;
import com.example.oasystems.utils.LoginId;

import org.litepal.crud.DataSupport;
import java.util.Date;
import java.util.List;


public class InformInActivity extends AppCompatActivity implements View.OnClickListener {
    private int color = R.color.color_rb_inform;
    private RadioGroup rg_inform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform_in);
        rg_inform = (RadioGroup) findViewById(R.id.rg_inform);
        RadioButton rb_inform = (RadioButton) findViewById(R.id.rb_inform);
        RadioButton rb_notify = (RadioButton) findViewById(R.id.rb_notify);
        findViewById(R.id.bt_clear).setOnClickListener(this);
        findViewById(R.id.bt_save).setOnClickListener(this);
        Intent intent = getIntent();
        long id = intent.getLongExtra("id", 0);
        final Inform inform = new Inform();
        List<Inform> informList = DataSupport.findAll(Inform.class, id);
        rg_inform.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_inform:
                        color = R.color.color_rb_inform;
                        break;
                    case R.id.rb_notify:
                        color = R.color.color_rb_notify;
                        break;
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_clear:
                DataSupport.deleteAll(Inform.class);
                break;
            case R.id.bt_save:
                intdata();
                break;
        }

    }

    private void intdata() {

        InformData informData = new InformData();
        EditText et_content = (EditText) findViewById(R.id.et_content);
        String title = et_content.getText().toString().trim();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String data = simpleDateFormat.format(new Date(System.currentTimeMillis()));

        LoginId loginId=new LoginId();
        LoginId loginIdList=DataSupport.findFirst(LoginId.class);
        String name= loginIdList.getName();
        Log.i("TAG", "name: "+name);
        Log.i("TAG", "save: "+informData.saveInformsData(title,name,data,color));


    }

}
