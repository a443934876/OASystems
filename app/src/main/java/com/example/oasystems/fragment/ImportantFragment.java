package com.example.oasystems.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.oasystems.R;
import com.example.oasystems.utils.Inform;
import com.example.oasystems.utils.InformAdapter;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 项目名称：OASystems
 * 创建时间：2017/10/23 15:58
 * 注释说明：
 */

public class ImportantFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_important_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        ListView listView = (ListView) getActivity().findViewById(R.id.listView_important);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        List<Inform> informList=DataSupport.where("imageView=?","2131361818").find(Inform.class);
        InformAdapter adapter = new InformAdapter(informList, inflater);
        listView.setAdapter(adapter);
    }
}
