package com.example.mvvmshownews.model;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

public class Data_show_more {
    String title;
    String date;
    String view;
    String des;
    public Data_show_more(String title,String date,String view,String des){
        this.title=title;
        this.date=date;
        this.view=view;
        this.des=des;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getView() {
        return view;
    }

    public String getDes() {
        return des;
    }

    @BindingAdapter("imageurl")
    public static void Getimageload(ImageView view,String imageurl){
        Glide.with(view).load(imageurl).into(view);
    }
}
