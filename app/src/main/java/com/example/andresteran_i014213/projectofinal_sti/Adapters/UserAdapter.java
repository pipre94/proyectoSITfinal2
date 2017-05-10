package com.example.andresteran_i014213.projectofinal_sti.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andresteran_i014213.projectofinal_sti.Models.User;
import com.example.andresteran_i014213.projectofinal_sti.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> myUser = new ArrayList<>();
    Context context;

    public UserAdapter(Context context, List<User> myUser) {
        this.myUser = myUser;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_picture, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //
        holder.myNameUser.setText(myUser.get(position).getUsername());
        holder.myEmail.setText(myUser.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return myUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView myNameUser;
        TextView myEmail;
        // Constructor
        public ViewHolder(View item)  {
            super(item);
            //
            myNameUser = (TextView) item.findViewById(R.id.id_txt_username_cad);
            myEmail =  (TextView) item.findViewById(R.id.id_card_time);

        }
    }
}
