package com.example.oasystems.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.oasystems.R;
import com.example.oasystems.utils.Inform;
import com.example.oasystems.utils.InformAdapter;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/23 21:23
 * 注释说明：
 */

public class NewsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View activity_news = inflater.inflate(R.layout.activity_news,container,false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_news);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        return activity_news;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       inflater.inflate(R.menu.toolbar,menu);
        Log.i("TAG", "onCreateOptionsMenu: ");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Toast.makeText(getActivity(),"选中Add",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        ListView listView = (ListView) getActivity().findViewById(R.id.listView_inform);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        List<Inform> informList = DataSupport.findAll(Inform.class);
        InformAdapter adapter = new InformAdapter(informList, inflater);
        listView.setAdapter(adapter);
    }
}
