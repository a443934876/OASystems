package com.example.oasystems.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/23 20:29
 * 注释说明：
 */

public class CustomDialog{

    public void createDialog(final Context context, String positiveButton, String negativeButton, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                System.exit(0);
            }
        });
        builder.setNegativeButton(negativeButton,null);
        builder.show();
    }

}
