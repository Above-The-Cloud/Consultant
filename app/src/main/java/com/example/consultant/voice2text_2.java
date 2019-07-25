package com.example.consultant;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;
import android.widget.ListView;

public class voice2text_2 extends Fragment {
    private ListView v2_list=null;
    private List<v2t2item> v2t2list =new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voice2text_2, container, false);
        initv2t2();
        v2t2_adapter adapter =new v2t2_adapter(getActivity(),R.layout.v2t2_item,v2t2list);
        v2_list =(ListView)view.findViewById(R.id.list_v2t2);
        v2_list.setAdapter(adapter);
        return view;
    }
    private void initv2t2()
    {
        for (int i=0;i<=15;i++){
            v2t2item gzuser = new v2t2item("文件名.wav","时长","日期时间",R.drawable.volume);
            v2t2list.add(gzuser);}
    }
}
