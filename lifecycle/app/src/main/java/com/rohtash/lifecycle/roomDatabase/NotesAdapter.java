package com.rohtash.lifecycle.roomDatabase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohtash.lifecycle.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Note> dataList;
    RoomDataBaseActivity context;
    public NotesAdapter(RoomDataBaseActivity context, List<Note> dataList){
        this.dataList=dataList;
        inflater=LayoutInflater.from(context);
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.adapter_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.titelTV.setText(dataList.get(position).getNote());
        holder.titelTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.itemClick(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView titelTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titelTV=itemView.findViewById(R.id.titelTV);
        }
    }
}
