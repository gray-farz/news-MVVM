package com.example.mvvmshownews.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvvmshownews.R;
import com.example.mvvmshownews.databinding.FragmentNav2Binding;
import com.example.mvvmshownews.model.Data_show_more;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_nav2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_nav2 extends Fragment {

    TextView Tv_bundel;
    FragmentNav2Binding binding;
    ImageView ImBack;
    public Fragment_nav2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,
                R.layout.fragment_nav2, container, false);
        binding.setDataShow(new Data_show_more(getArguments().getString("title"),getArguments().getString("date"),getArguments().getString("view"),getArguments().getString("des")));
        binding.setImageurl(getArguments().getString("imageurl"));
        ImBack=binding.ImBack;
        ImBack.setOnClickListener(view -> {
            Navigation.findNavController(ImBack).popBackStack();
        });
        return binding.getRoot();
    }
}