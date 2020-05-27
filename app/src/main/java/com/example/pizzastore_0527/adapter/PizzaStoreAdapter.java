package com.example.pizzastore_0527.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pizzastore_0527.R;
import com.example.pizzastore_0527.datas.PizzaStore;

import java.util.List;

public class PizzaStoreAdapter extends ArrayAdapter<PizzaStore> {
    Context mContext;
    List<PizzaStore> mList;
    LayoutInflater inf;
    public PizzaStoreAdapter(@NonNull Context context, int resource, @NonNull List<PizzaStore> objects) {
        super(context, resource, objects);
        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.pizza_list_item,null);

        }
        return row;
    }
}
