package com.example.yan.orderingapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item1Fragment extends Fragment {

    private MealAdapter adapter;
    private List<MealMessage> mMealMessageList = new ArrayList<>();
    public Item1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item1, container, false);
        ListView listView = (ListView) view.findViewById(R.id.food_ltem);
        initMessage();
        adapter = new MealAdapter(getActivity(), R.layout.meal_list,mMealMessageList);
        listView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }
    private void initMessage(){
        for (int i=0; i<20; i++){
            MealMessage meals = new MealMessage(R.drawable.food1,"FoodName","哈灵牛蛙面，建议单人使用","￥41.8");
            mMealMessageList.add(meals);
        }
    }
}
