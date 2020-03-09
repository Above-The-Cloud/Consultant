package com.example.consultant.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.consultant.R;
import com.example.consultant.adapters.IndicatorAdapter;
import com.example.consultant.adapters.MainContentAdapter;
import com.example.consultant.utils.LogUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager mcontentPager;
    private MainContentAdapter mainContentAdapter;
    private IndicatorAdapter mIndicatorAdapter;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscoverFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(String param1, String param2) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void initEvent() {
        mIndicatorAdapter.setOnIndicatorTabClickListener(new IndicatorAdapter.OnIndicatorTabClickListener() {
            @Override
            public void onTabClick(int index) {
                //
                LogUtil.d(TAG, "click index is -- >" + index);
                if(mcontentPager != null)
                    mcontentPager.setCurrentItem(index);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_question, container, false);
        initView();
        initEvent();
        return view;
    }

    private void initView() {
        MagicIndicator magicIndicator = view.findViewById(R.id.magic_indicator_question_frag);
        CommonNavigator commonNavigator = new CommonNavigator(this.getActivity());
        commonNavigator.setAdjustMode(true);
        //创建indicator的适配器
        mIndicatorAdapter = new IndicatorAdapter(this.getActivity());
        commonNavigator.setAdapter(mIndicatorAdapter);

        //设置要显示的内容


        //ViewPager
        mcontentPager = view.findViewById(R.id.question_pager);
        //创建内容适配器
        mainContentAdapter = new MainContentAdapter(this.getChildFragmentManager());

        mcontentPager.setAdapter(mainContentAdapter);

        //把ViewPager和indicator绑定到一起
        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setGravity(Gravity.CENTER);
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerPadding(UIUtil.dip2px(this.getActivity() , 15));
        titleContainer.setDividerDrawable(getResources().getDrawable(R.drawable.simple_splitter));
        ViewPagerHelper.bind(magicIndicator, mcontentPager);

    }
}
