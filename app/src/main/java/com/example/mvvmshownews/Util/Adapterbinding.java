package com.example.mvvmshownews.Util;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

public class Adapterbinding {

    @BindingAdapter("image")
    public static void Image(ImageView view, String url){

        Glide.with(view).load(url).into(view);
    }

}
