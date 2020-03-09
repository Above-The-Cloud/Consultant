package com.example.consultant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v4.view.ViewPager;

import com.example.consultant.fragments.PersonalFragment;
import com.example.consultant.former.PostMessage;
import com.example.consultant.fragments.QuestionFragment;
import com.example.consultant.R;
import com.example.consultant.fragments.DiscoverFragment;
import com.example.consultant.fragments.MessageFragment;
import com.example.consultant.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    ViewPager viewPager;
    BottomNavigationView navView;
    List<Fragment> listFragment;
    private List<PostMessage> msgList = new ArrayList<>();
    private RadioGroup mTabRadioGroup;
    private SparseArray<Fragment> mFragmentSparseArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.init(this.getPackageName(), false);
        setContentView(R.layout.main_navbar_layout);
        initView();//初始化
    }

    public void initView() {
        mTabRadioGroup = findViewById(R.id.tabs_rg);
        mFragmentSparseArray = new SparseArray<>();
        mFragmentSparseArray.append(R.id.discover_tab, new DiscoverFragment());
        mFragmentSparseArray.append(R.id.question_tab, new QuestionFragment());
        mFragmentSparseArray.append(R.id.message_tab, new MessageFragment());
        mFragmentSparseArray.append(R.id.personal_tab, new PersonalFragment());
        mTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mFragmentSparseArray.get(checkedId)).commit();
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mFragmentSparseArray.get(R.id.discover_tab)).commit();
        findViewById(R.id.release_iv).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ReleaseActivity.class));
            }
        });

    }
}
