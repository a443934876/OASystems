package com.example.oasystems.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.oasystems.Activity.HomeActivity.ClientVisitActivity;
import com.example.oasystems.Activity.HomeActivity.CustomerInfoActivity;
import com.example.oasystems.Activity.HomeActivity.LeaveActivity;
import com.example.oasystems.Activity.HomeActivity.Official_BusinessActivity;
import com.example.oasystems.Activity.HomeActivity.PowerNotesActivity;
import com.example.oasystems.Activity.HomeActivity.WorkReportActivity;
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

public class HomeFragment extends Fragment implements View.OnClickListener {
    private TextView tv_inform;

    @Override
    public void onResume() {
        super.onResume();
        ListView listView = (ListView) getActivity().findViewById(R.id.lv_inform);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        List<Inform> informList = DataSupport.findAll(Inform.class);
        InformAdapter adapter = new InformAdapter(informList, inflater);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent("com.example.oasystems.homeactivity.informinactivity.ACTION_START");
                intent.putExtra("id", id);
                startActivity(intent);

            }
        });
        tv_inform.setText("通知      共" + informList.size() + "条");

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, null);
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        View customerInfo_layout = getActivity().findViewById(R.id.customerInfo_layout);
        View workReport_layout = getActivity().findViewById(R.id.workReport_layout);
        View powerNotes_layout = getActivity().findViewById(R.id.powerNotes_layout);
        View clientVisit_layout = getActivity().findViewById(R.id.clientVisit_layout);
        View official_Business_layout = getActivity().findViewById(R.id.official_Business_layout);
        View leave_layout = getActivity().findViewById(R.id.leave_layout);
        View workAssigned_layout = getActivity().findViewById(R.id.workAssigned_layout);
        View more_layout = getActivity().findViewById(R.id.more_layout);
         tv_inform = (TextView) getActivity().findViewById(R.id.tv_inform);
        customerInfo_layout.setOnClickListener(this);
        workReport_layout.setOnClickListener(this);
        powerNotes_layout.setOnClickListener(this);
        clientVisit_layout.setOnClickListener(this);
        official_Business_layout.setOnClickListener(this);
        leave_layout.setOnClickListener(this);
        workAssigned_layout.setOnClickListener(this);
        more_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customerInfo_layout:
                Toast.makeText(getActivity(), "customerInfo_layout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), CustomerInfoActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
            case R.id.workReport_layout:
                Toast.makeText(getActivity(), "workReport_layout", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getActivity(), WorkReportActivity.class);
                startActivity(intent1);
                getActivity().finish();
                break;
            case R.id.powerNotes_layout:
                Toast.makeText(getActivity(), "powerNotes_layout", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getActivity(), PowerNotesActivity.class);
                startActivity(intent2);
                getActivity().finish();
                break;
            case R.id.clientVisit_layout:
                Toast.makeText(getActivity(), "clientVisit_layout", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getActivity(), ClientVisitActivity.class);
                startActivity(intent3);
                getActivity().finish();
                break;
            case R.id.official_Business_layout:
                Toast.makeText(getActivity(), "official_Business_layout", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(getActivity(), Official_BusinessActivity.class);
                startActivity(intent4);
                getActivity().finish();
                break;
            case R.id.leave_layout:
                Toast.makeText(getActivity(), "leave_layout", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(getActivity(), LeaveActivity.class);
                startActivity(intent5);
                getActivity().finish();
                break;
            case R.id.workAssigned_layout:
                Toast.makeText(getActivity(), "workAssigned_layout", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(getActivity(), WorkReportActivity.class);
                startActivity(intent6);
                getActivity().finish();
                break;
            case R.id.more_layout:
//                Toast.makeText(getActivity(), "more_layout", Toast.LENGTH_SHORT).show();
//                Intent intent7 = new Intent(getActivity(), MoreActivity.class);
//                startActivity(intent7);
                Intent intent7 = new Intent("com.example.oasystems.homeactivity.informinactivity.ACTION_START");

                startActivity(intent7);
                getActivity().finish();
                break;
        }
    }



}
