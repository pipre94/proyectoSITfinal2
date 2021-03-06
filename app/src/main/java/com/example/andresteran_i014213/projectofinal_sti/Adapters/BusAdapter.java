package com.example.andresteran_i014213.projectofinal_sti.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.andresteran_i014213.projectofinal_sti.Models.Bus;
import com.example.andresteran_i014213.projectofinal_sti.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenet on 27/05/2017.
 */

public class BusAdapter  extends BaseAdapter {

    List<Bus> userList = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;

    public BusAdapter(Context context, List<Bus> userList) {
        this.context = context;
        this.userList = userList;
        layoutInflater = LayoutInflater.from(this.context);
    }

    public int getCount() {
        return userList.size();
    }

    @Override
    public Bus getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.cardview_picture, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Bus bus = getItem(position);
        viewHolder.route.setText(bus.getRoute());
        viewHolder.neighborhood.setText(bus.getNeighborhood());

        return convertView;
    }

    public class ViewHolder{
        TextView route;
        TextView neighborhood;

        public ViewHolder(View item) {
            route = (TextView) item.findViewById(R.id.id_txt_username_cad);
            neighborhood = (TextView) item.findViewById(R.id.id_card_time);
        }
    }
}