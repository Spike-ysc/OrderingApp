package com.example.yan.orderingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by yan on 2017/5/18.
 */

public class MealAdapter extends ArrayAdapter<MealMessage> {
    private int resourceId;

    public MealAdapter(Context context, int textViewResourceId, List<MealMessage> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MealMessage message= getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView imageId = (ImageView) view.findViewById(R.id.food_image);
        TextView mName = (TextView) view.findViewById(R.id.food_name_text);
        TextView mMessage = (TextView) view.findViewById(R.id.food_message_text);
        TextView mMoney = (TextView) view.findViewById(R.id.money_text);
        imageId.setImageResource(message.getImageId());
        mName.setText(message.getFoodName());
        mMessage.setText(message.getFootMessage());
        mMoney.setText(message.getMoney());
        return view;

    }
}
