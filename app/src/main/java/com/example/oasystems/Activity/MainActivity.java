package com.example.oasystems.Activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.oasystems.R;
import com.example.oasystems.fragment.ContactsFragment;
import com.example.oasystems.fragment.HomeFragment;
import com.example.oasystems.fragment.NewsFragment;
import com.example.oasystems.fragment.NomFragment;
import com.example.oasystems.utils.LoginIdData;


/**
 * 项目名称：OASystems
 * 创建时间：2017/9/26 19:06
 * 注释说明：
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 用于展示消息的Fragment
     */
    private HomeFragment homeFragment;

    /**
     * 用于展示联系人的Fragment
     */
    private ContactsFragment contactsFragment;

    /**
     * 用于展示动态的Fragment
     */
    private NewsFragment newsFragment;

    /**
     * 用于展示设置的Fragment
     */
    private NomFragment nomFragment;

    /*
     * 消息界面布局
     */
//    private View homeLayout;

    /*
     * 联系人界面布局
     */
//    private View contactsLayout;

    /*
     * 动态界面布局
     */
//    private View newsLayout;

    /*
     * 设置界面布局
     */
//    private View nomLayout;

    /**
     * 在Tab布局上显示消息图标的控件
     */
    private ImageView homeImage;

    /**
     * 在Tab布局上显示联系人图标的控件
     */
    private ImageView contactsImage;

    /**
     * 在Tab布局上显示动态图标的控件
     */
    private ImageView newsImage;

    /**
     * 在Tab布局上显示设置图标的控件
     */
    private ImageView nomImage;

    /**
     * 在Tab布局上显示消息标题的控件
     */
    private TextView homeText;

    /**
     * 在Tab布局上显示联系人标题的控件
     */
    private TextView contactsText;

    /**
     * 在Tab布局上显示动态标题的控件
     */
    private TextView newsText;

    /**
     * 在Tab布局上显示设置标题的控件
     */
    private TextView nomText;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        initViews();
        fragmentManager = getSupportFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }


    private void initViews() {
        View  homeLayout = findViewById(R.id.home_layout);
        View  contactsLayout = findViewById(R.id.contacts_layout);
        View  newsLayout = findViewById(R.id.news_layout);
        View  nomLayout = findViewById(R.id.nom_layout);
        homeImage = (ImageView) findViewById(R.id.home_image);
        contactsImage = (ImageView) findViewById(R.id.contacts_image);
        newsImage = (ImageView) findViewById(R.id.news_image);
        nomImage = (ImageView) findViewById(R.id.nom_image);
        homeText = (TextView) findViewById(R.id.home_text);
        contactsText = (TextView) findViewById(R.id.contacts_text);
        newsText = (TextView) findViewById(R.id.news_text);
        nomText = (TextView) findViewById(R.id.nom_text);
        homeLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        newsLayout.setOnClickListener(this);
        nomLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView textView= (TextView) findViewById(R.id.tv_main);

        switch (v.getId()) {
            case R.id.home_layout:
                // 当点击了主页tab时，选中第1个tab
                setTabSelection(0);
                textView.setText("主页");
                break;
            case R.id.contacts_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                textView.setText("联系人");
                break;
            case R.id.news_layout:
                // 当点击了通知tab时，选中第3个tab
                setTabSelection(2);
                textView.setText("通知");
                break;
            case R.id.nom_layout:
                // 当点击了我的tab时，选中第4个tab
                setTabSelection(3);
                textView.setText("我的");
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index 每个tab页对应的下标。0表示主页，1表示联系人，2表示动态，3表示个人。
     */
    public void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                homeImage.setImageResource(R.drawable.home_selected);
                homeText.setTextColor(Color.parseColor("#6071AB"));
                if (homeFragment == null) {
                    // 如果homeFragment为空，则创建一个并添加到界面上
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    // 如果homeFragment不为空，则直接将它显示出来
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                contactsImage.setImageResource(R.drawable.contacts_selected);
                contactsText.setTextColor(Color.parseColor("#6071AB"));
                if (contactsFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    contactsFragment = new ContactsFragment();
                    transaction.add(R.id.content, contactsFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(contactsFragment);
                }
                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                newsImage.setImageResource(R.drawable.news_selected);
                newsText.setTextColor(Color.parseColor("#6071AB"));
                if (newsFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content, newsFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(newsFragment);
                }
                break;

            default:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                nomImage.setImageResource(R.drawable.nom_selected);
                nomText.setTextColor(Color.parseColor("#6071AB"));
                if (nomFragment == null) {
                    // 如果nomFragment为空，则创建一个并添加到界面上
                    nomFragment = new NomFragment();
                    transaction.add(R.id.content, nomFragment);
                } else {
                    // 如果nomFragment不为空，则直接将它显示出来
                    transaction.show(nomFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        homeImage.setImageResource(R.drawable.home_unselected);
        homeText.setTextColor(Color.parseColor("#82858b"));
        contactsImage.setImageResource(R.drawable.contacts_unselected);
        contactsText.setTextColor(Color.parseColor("#82858b"));
        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        nomImage.setImageResource(R.drawable.nom_unselected);
        nomText.setTextColor(Color.parseColor("#82858b"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (contactsFragment != null) {
            transaction.hide(contactsFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (nomFragment != null) {
            transaction.hide(nomFragment);
        }
    }


    @Override
    public void onBackPressed() {
//        new CustomDialog().createDialog(MainActivity.this, "确认", "取消", "确认", "是否退出？");
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("退出提示")//设置对话框的标题
                .setMessage("是否退出")//设置对话框的内容
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoginIdData loginIdData = new LoginIdData();
                        loginIdData.deleteLoginId();
                        finish();
                    }
                });
        builder.show();
    }

}
