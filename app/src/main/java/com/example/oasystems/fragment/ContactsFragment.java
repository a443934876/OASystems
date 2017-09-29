package com.example.oasystems.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oasystems.R;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/23 21:23
 * 注释说明：
 */

public class ContactsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View activity_contact = inflater.inflate(R.layout.activity_contacts,container,false);
        return activity_contact;
    }
}
