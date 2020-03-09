package com.example.consultant.utils;

import com.example.consultant.fragments.AnswerFragment;
import com.example.consultant.fragments.AskFragment;
import com.example.consultant.fragments.BaseFragment;

import java.util.HashMap;
import java.util.Map;

public class FragmentCreator {
    private static Map<Integer, BaseFragment> sCache = new HashMap<>();
    public final static int INDEX_ANSWER = 0;
    public final static int INDEX_ASK = 1;
    public final static int PAGE_COUNT = 2;
    public static BaseFragment getFragment(int index) {
        BaseFragment baseFragment = sCache.get(index);
        if (baseFragment != null) {
            return baseFragment;
        }
        switch (index) {
            case INDEX_ASK:
                baseFragment = new AskFragment();
                break;
            case INDEX_ANSWER:
                baseFragment = new AnswerFragment();
                break;
        }
        sCache.put(index, baseFragment);
        return baseFragment;
    }
}
