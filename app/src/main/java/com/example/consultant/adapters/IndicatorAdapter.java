package com.example.consultant.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.example.consultant.R;

import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class IndicatorAdapter extends CommonNavigatorAdapter {

    private final String[] mTitles;
    private OnIndicatorTabClickListener mOnTabClickListener;

    public IndicatorAdapter(Context context){

        mTitles = context.getResources().getStringArray(R.array.indicator_title);
    }

    @Override
    public int getCount() {
        if (mTitles != null)
            return mTitles.length;
        return 0;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
        simplePagerTitleView.setText(mTitles[index]);
        simplePagerTitleView.setNormalColor(Color.GRAY);
        simplePagerTitleView.setSelectedColor(Color.BLACK);
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mViewPager.setCurrentItem(index);
                if(mOnTabClickListener != null){
                    mOnTabClickListener.onTabClick(index);
                }
                //TODO:
            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setLineHeight(UIUtil.dip2px(context, 1));
        indicator.setColors(Color.parseColor("#80000000"));
        return indicator;
    }
    public void setOnIndicatorTabClickListener(OnIndicatorTabClickListener listener) {
        this.mOnTabClickListener = listener;
    }

    public interface OnIndicatorTabClickListener {
        void onTabClick(int index);
    }
}
