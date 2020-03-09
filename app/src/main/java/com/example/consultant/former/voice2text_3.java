package com.example.consultant.former;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.consultant.R;
import com.example.consultant.adapters.v2t2_adapter;

import java.util.ArrayList;
import java.util.List;

public class voice2text_3 extends Fragment {
    private ListView v2_list=null;
    private List<v2t2item> v2t2list =new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voice2text_2, container, false);
        initv2t3();
        v2t2_adapter adapter =new v2t2_adapter(getActivity(),R.layout.v2t2_item,v2t2list);
        v2_list =(ListView)view.findViewById(R.id.list_v2t2);
        v2_list.setAdapter(adapter);
        return view;
    }
    private void initv2t3()
    {
        for (int i=0;i<=15;i++){
            v2t2item gzuser = new v2t2item("文件名.txt","时长","日期时间",R.drawable.volume);
            v2t2list.add(gzuser);}
    }

}