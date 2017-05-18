package com.example.yan.orderingapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item2Fragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabFragmentAdapter mAdapter;
    private List<Fragment> mList;

    public Item2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item2, container, false);
        mTabLayout = (TabLayout) view.findViewById(R.id.myTablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.myViewPager);
        mViewPager.setOffscreenPageLimit(2);
        mList = new ArrayList<>();
        mList.add(new Tab1Fragment());
        mList.add(new Tab2Fragment());
        mList.add(new Tab3Fragment());
        mAdapter = new TabFragmentAdapter(getChildFragmentManager(),mList);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
        // Inflate the layout for this fragment
        return view;
    }


}
