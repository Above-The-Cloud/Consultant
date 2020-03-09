package com.example.consultant.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultant.R;
import com.example.consultant.business.AskItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AskListAdapter extends RecyclerView.Adapter<AskListAdapter.InnerHolder> {
    private List<AskItem> mData = new ArrayList<>();
    @NonNull
    @Override
    public AskListAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //载view
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ask, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AskListAdapter.InnerHolder innerHolder, int i) {
        //设置数据
        innerHolder.itemView.setTag(i);
        innerHolder.setData(mData.get(i));
    }

    @Override
    public int getItemCount() {
        if(mData != null)
            return mData.size();
        return 0;
    }

    public void setData(List<AskItem> itemList) {
        if(mData != null){
            mData.clear();
            mData.addAll(itemList);

        }
        //更新ui
        notifyDataSetChanged();

    }


    public class InnerHolder extends RecyclerView.ViewHolder{

        private TextView ask_item_title;
        private TextView ask_item_desc;
        private TextView ask_item_answerer;

        public InnerHolder(View itemView) {
            super(itemView);
        }

        public void setData(AskItem askItem) {
            //找到各个控件 设置数据
            //提问标题
            ask_item_title = itemView.findViewById(R.id.ask_item_title_tv);
            //问题描述
            ask_item_desc = itemView.findViewById(R.id.ask_item_description_tv);
            //回答者
            ask_item_answerer = itemView.findViewById(R.id.ask_item_answerer_tv);




        }
    }
}
