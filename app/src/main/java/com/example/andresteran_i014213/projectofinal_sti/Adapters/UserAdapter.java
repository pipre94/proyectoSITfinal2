package com.example.andresteran_i014213.projectofinal_sti.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andresteran_i014213.projectofinal_sti.Models.User;
import com.example.andresteran_i014213.projectofinal_sti.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter{

    LayoutInflater layoutInflater;
    Context context;

    public UserAdapter (Context context){

        this.context = context;
        layoutInflater = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
