package com.example.oasystems.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.oasystems.Activity.HomeActivity.NomActivity;
import com.example.oasystems.R;
import com.example.oasystems.utils.LoginId;
import com.example.oasystems.utils.UserData;

import org.litepal.crud.DataSupport;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/23 21:23
 * 注释说明：
 */

public class NomFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View activity_nom = inflater.inflate(R.layout.activity_nom, container, false);

        return activity_nom;
    }

    private void nameView() {
        LoginId loginIdList = DataSupport.findFirst(LoginId.class);
        TextView tv_name = (TextView) getActivity().findViewById(R.id.tv_name);
        Log.i("TAG", "nameView: "+loginIdList.getName());
        tv_name.setText(loginIdList.getName());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nameView();
        getActivity().findViewById(R.id.nom_nom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NomActivity.class);
                startActivity(intent);

            }
        });
    }
}
