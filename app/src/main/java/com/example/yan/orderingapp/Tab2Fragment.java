package com.example.yan.orderingapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment {

    private MealAdapter adapter;
    private List<MealMessage> mMealMessageList = new ArrayList<>();

    public Tab2Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tab2, container, false);
        ListView listView = (ListView) view.findViewById(R.id.tab2_food_ltem);
Toast.makeText(getActivity(),"ye",Toast.LENGTH_SHORT).show();
        for (int i = 0; i<AllMsg.getAllTime();i++){
            if (AllMsg.getNum() != i){

                SharedPreferences pref = getActivity().getSharedPreferences(""+i, Context.MODE_PRIVATE);
                MealMessage meals = new MealMessage(
                        pref.getInt("image",R.drawable.food1),
                        pref.getString("name",""),
                        pref.getString("message", ""),
                        pref.getString("money",""));
                mMealMessageList.add(meals);

            }
        }


        adapter = new MealAdapter(getActivity(), R.layout.meal_list,mMealMessageList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), RateActivity.class);
                intent.putExtra("num", position);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
