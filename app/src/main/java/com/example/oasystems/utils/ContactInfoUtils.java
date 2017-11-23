package com.example.oasystems.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：获取所有的联系人信息
 * 创建时间：2017/11/20 20:02
 * 注释说明：
 */

public class ContactInfoUtils {
    public static List<ContactInfo> getAllContactInfos(Context context) {
        List<ContactInfo> infos = new ArrayList<>();
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
        Uri data_uri = Uri.parse("content://com.android.contacts/data");
        Cursor cursor = resolver.query(uri, new String[]{"contact_id"}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(0);
                if (id != null) {
                    ContactInfo info = new ContactInfo();
                    Cursor data_cursor = resolver.query(data_uri, new String[]{"data1", "mimetype"}, "raw_contact_id=?", new String[]{id}, null);
                    if (data_cursor != null && data_cursor.moveToFirst()) {
                        while (data_cursor.moveToNext()) {
                            String data1 = data_cursor.getString(0);
                            String mimetype = data_cursor.getString(1);
                            if ("vnd.android.cursor.item/name".equals(mimetype)) {
                                info.setName(data1);
                            } else if ("vnd.android.cursor.item/phone_v2".equals(mimetype)) {
                                info.setPhone(data1);
                            } else if ("vnd.android.cursor.item/email_v2".equals(mimetype)) {
                                info.setEmail(data1);
                            }
                        }
                        data_cursor.close();
                        infos.add(info);
                    }
                }
            }
            cursor.close();
        }
        return infos;
    }
}
