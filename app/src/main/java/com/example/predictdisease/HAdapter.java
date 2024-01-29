package com.example.predictdisease;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HAdapter extends RecyclerView.Adapter<HAdapter.MyViewHolder> {

     Context context;
     ArrayList<HospitalUser>  list;

    public HAdapter(Context context,ArrayList<HospitalUser> list){
        this.context =context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itemhospital,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HospitalUser hospitalUser=list.get(position);
        holder.hname.setText(hospitalUser.getHname());
        holder.location.setText(hospitalUser.getLocation());
        holder.contact.setText(hospitalUser.getContact());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView hname,location,contact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            hname=itemView.findViewById(R.id.hospital_name);
            location=itemView.findViewById(R.id.location);
            contact=itemView.findViewById(R.id.contact);

        }


    }
}
