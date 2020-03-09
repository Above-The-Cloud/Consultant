package com.example.consultant.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.consultant.R;
import com.example.consultant.adapters.AskListAdapter;
import com.example.consultant.business.AskItem;

import java.util.LinkedList;
import java.util.List;

public class AskFragment extends BaseFragment {

    private View rootView;
    private RecyclerView mAskRv;
    private AskListAdapter mAskListAdapter;

    @Override
    protected View onSubViewLoaded(LayoutInflater inflater, ViewGroup container) {
        //view 加载完成
        rootView = inflater.inflate(R.layout.fragment_ask, container, false);

        //RecycleView的使用
        //1. 找到控件
        mAskRv = rootView.findViewById(R.id.ask_list);
        //2. 设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAskRv.setLayoutManager(linearLayoutManager);
        //3. 设置适配器
        mAskListAdapter = new AskListAdapter();
        mAskRv.setAdapter(mAskListAdapter);
        //拿数据
        List<AskItem> askItems = new LinkedList<>();
        askItems.add(new AskItem());
        askItems.add(new AskItem());
        askItems.add(new AskItem());
        upAskUI(askItems);

        //返回view 给界面显示
        return rootView;
    }

    private void upAskUI(List<AskItem> ItemList) {
        //把数据设置给适配器，并且更新
        mAskListAdapter.setData(ItemList);
    }

}
