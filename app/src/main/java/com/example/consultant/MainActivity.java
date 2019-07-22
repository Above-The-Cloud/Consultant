package com.example.consultant;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    ViewPager viewPager;
    BottomNavigationView navView;
    List<Fragment> listFragment;
    private List<PostMessage> msgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化



    }
    public void initView(){
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("123", item.getItemId() + " onNavigationItemSelected is click: ");
                switch (item.getItemId()) {
                    case R.id.navigation_tools:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_comment:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_personal:
                        viewPager.setCurrentItem(2);
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });
        //向ViewPager添加各页面
        listFragment = new ArrayList<>();
        listFragment.add(new tool_fragment());
        listFragment.add(new comment_fragment());
        listFragment.add(new personal_fragment());

        MyFragAdapter myFragAdapter = new MyFragAdapter(getSupportFragmentManager(), this, listFragment);
        viewPager.setAdapter(myFragAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                navView.getMenu().getItem(i).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
