package com.example.yan.orderingapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.os.Build.VERSION_CODES.M;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {
    private MealAdapter adapter;
    private List<MealMessage> mMealMessageList = new ArrayList<>();

    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        ListView listView = (ListView) view.findViewById(R.id.tab_food_ltem);

        for (int i = 0; i<AllMsg.getAllTime();i++){
            SharedPreferences pref = getActivity().getSharedPreferences(""+i, Context.MODE_PRIVATE);
            MealMessage meals = new MealMessage(
                    pref.getInt("image",R.drawable.food1),
                    pref.getString("name",""),
                    pref.getString("message", ""),
                    pref.getString("money",""));
            mMealMessageList.add(meals);
        }
        adapter = new MealAdapter(getActivity(), R.layout.meal_list,mMealMessageList);
        listView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }
    private void initMessage(){


//        Toast.makeText(getActivity(),, Toast.LENGTH_SHORT).show();
//        for (int i = 0; i<AllMsg.getAllTime();i++){
//            SharedPreferences pref = getActivity().getSharedPreferences(""+i, Context.MODE_PRIVATE);
//            MealMessage meals = new MealMessage(
//                    pref.getInt("image",R.drawable.food1),
//                    pref.getString("name",""),
//                    pref.getString("message", ""),
//                    pref.getString("money",""));
//            mMealMessageList.add(meals);
//        }
    }

}
