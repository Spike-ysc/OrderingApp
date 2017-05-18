package com.example.yan.orderingapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item3Fragment extends Fragment {

    private List<MySetting> mMySettingList = new ArrayList<>();

    public Item3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item3, container, false);
        initSetting();
        SettingAdapter adapter = new SettingAdapter(getActivity(), R.layout.setting_list,mMySettingList);
        ListView listView = (ListView) view.findViewById(R.id.setting_list);
        listView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }
    private void initSetting(){
        for (int i=0; i<5; i++){
            MySetting ms = new MySetting("设置");
            mMySettingList.add(ms);
        }
    }

    public class MySetting {
        private String name;
        public MySetting(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }

    public class SettingAdapter extends ArrayAdapter<MySetting>{
        private  int resourceId;
        public SettingAdapter(Context context, int textViewResourceId, List<MySetting> objects){
            super(context, textViewResourceId, objects);
            resourceId =textViewResourceId;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            MySetting setting = getItem(position);
            View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            TextView nameText = (TextView) view.findViewById(R.id.setting_text);
            nameText.setText(setting.getName());
            return  view;
        }
    }

}
