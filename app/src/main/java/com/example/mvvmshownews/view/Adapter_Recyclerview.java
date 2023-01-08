package com.example.mvvmshownews.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.mvvmshownews.R;
import com.example.mvvmshownews.Util.Click_items;
import com.example.mvvmshownews.databinding.ItemsBinding;
import com.example.mvvmshownews.model.Datamodel;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_Recyclerview extends RecyclerView.Adapter<Adapter_Recyclerview.viewhodler> {
     List<Datamodel> list;
    Click_items click_items;
     public Adapter_Recyclerview(List<Datamodel> list, Click_items click_items){
         this.list=list;
         this.click_items=click_items;
     }
    @NonNull
    @Override
    public viewhodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewhodler(
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewhodler holder, int position) {
     Datamodel datamodel=list.get(position);
     holder.binding.setData(datamodel);
     holder.itemView.setOnClickListener(view -> {
         click_items.Clickitems(datamodel);
     });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewhodler extends RecyclerView.ViewHolder {
        ItemsBinding binding;
        public viewhodler(@NonNull ItemsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
