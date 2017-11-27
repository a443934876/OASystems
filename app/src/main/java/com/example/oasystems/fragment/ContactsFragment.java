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
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.oasystems.R;
import com.example.oasystems.utils.ContactInfo;
import com.example.oasystems.utils.ContactInfoUtils;
import java.util.List;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/23 21:23
 * 注释说明：
 */

public class ContactsFragment extends Fragment {
    private List<ContactInfo> infos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_contacts,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar mToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
        infos = ContactInfoUtils.getAllContactInfos(getActivity());
        ListView contacts_list= (ListView) getActivity().findViewById(R.id.contacts_list);
        ContactsAdapter Adapter = new ContactsAdapter();
        contacts_list.setAdapter(Adapter) ;
    }

    private class ContactsAdapter extends BaseAdapter {
         @Override
         public int getCount() {
             return infos.size();
         }

         @Override
         public Object getItem(int position) {
             return null;
         }

         @Override
         public long getItemId(int position) {
             return 0;
         }

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
             View view;
             if (convertView == null) {
                 view = View.inflate(getActivity(), R.layout.contact_item, null);

             } else {
                 view = convertView;
             }
             TextView contact_name = (TextView) view.findViewById(R.id.contact_name);
             TextView contact_phone = (TextView) view.findViewById(R.id.contact_phone);
             TextView contact_email = (TextView) view.findViewById(R.id.contact_email);
             ContactInfo info = infos.get(position);
             contact_name.setText(info.getName());
             Log.i("TAG", "Name: " + info);
             contact_phone.setText(info.getPhone());
             contact_email.setText(info.getEmail());
             return view;
         }
     }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbar,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:

                break;
        }
        return true;
    }
}
