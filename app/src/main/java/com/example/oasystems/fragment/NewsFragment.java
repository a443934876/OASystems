package com.example.oasystems.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oasystems.R;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/23 21:23
 * 注释说明：
 */

public class NewsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_news,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) getActivity().findViewById(R.id.tab_host);
        fragmentTabHost.setup(getActivity(), getFragmentManager(), R.id.fragment);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("common").setIndicator("普通通知"), CommonFragment.class, null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("important").setIndicator("重要通知"), ImportantFragment.class, null);
//        ListView listView = (ListView) getActivity().findViewById(R.id.listView_inform);
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        List<Inform> informList = DataSupport.findAll(Inform.class);
//        InformAdapter adapter = new InformAdapter(informList, inflater);
//        listView.setAdapter(adapter);
    }


}
