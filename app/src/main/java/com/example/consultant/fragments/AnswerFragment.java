package com.example.consultant.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.consultant.R;
import com.example.consultant.adapters.AnswerPagerAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator;

import java.util.Arrays;


public class AnswerFragment extends BaseFragment {

//    private static final int CHANNELS_COUNT = 8;
    private static String[] Questions = new String[]{"Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8"};
    private View rootView;
    private AnswerPagerAdapter mAnswerPagerAdapter = new AnswerPagerAdapter(Arrays.asList(Questions));
    private ViewPager mViewPager;
    @Override
    protected View onSubViewLoaded(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_answer, container, false);
        mViewPager = rootView.findViewById(R.id.answer_view_pager);
        mViewPager.setAdapter(mAnswerPagerAdapter);
        initMagicIndicator();
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private void initMagicIndicator() {
        MagicIndicator magicIndicator = rootView.findViewById(R.id.answer_magic_indicator);
        CircleNavigator circleNavigator = new CircleNavigator(getActivity());
        circleNavigator.setCircleCount(Questions.length);
        circleNavigator.setCircleColor(R.color.button_color);
        circleNavigator.setCircleClickListener(new CircleNavigator.OnCircleClickListener() {
            @Override
            public void onClick(int index) {
                mViewPager.setCurrentItem(index);
            }
        });
        magicIndicator.setNavigator(circleNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }
}
