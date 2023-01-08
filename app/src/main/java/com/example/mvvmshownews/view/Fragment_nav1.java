package com.example.mvvmshownews.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.mvvmshownews.R;
import com.example.mvvmshownews.Util.Click_items;
import com.example.mvvmshownews.Viewmodel.Viewmodel_Listpost;
import com.example.mvvmshownews.databinding.FragmentNav1Binding;
import com.example.mvvmshownews.model.Datamodel;

import java.util.List;

public class Fragment_nav1 extends Fragment implements Click_items {

    FragmentNav1Binding binding;
    RecyclerView recyclerview;
    ProgressBar progressBar;

    public Fragment_nav1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,
                R.layout.fragment_nav1, container, false);
        recyclerview=binding.recyclerview;
        progressBar=binding.progressWheel;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Viewmodel_Listpost viewmodel_listpost= ViewModelProviders.of(this).get(Viewmodel_Listpost.class);
        MutableLiveData<List<Datamodel>> listMutableLiveData=viewmodel_listpost.mutableLiveData();
        listMutableLiveData.observe(getActivity(), new Observer<List<Datamodel>>() {
            @Override
            public void onChanged(List<Datamodel> datamodels) {
                recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                Adapter_Recyclerview adapter=new Adapter_Recyclerview(datamodels,Fragment_nav1.this::Clickitems);
                recyclerview.setAdapter(adapter);
            }
        });
        viewmodel_listpost.liveData_looging.observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void Clickitems(Datamodel datamodel) {
        Bundle bundle=new Bundle();
        bundle.putString("id",datamodel.getId());
        bundle.putString("title",datamodel.getTitle());
        bundle.putString("imageurl",datamodel.getImageurl());
        bundle.putString("view",datamodel.getView());
        bundle.putString("date",datamodel.getDate());
        bundle.putString("des",datamodel.getDes());
        Navigation.findNavController(recyclerview).navigate(R.id.action_fragment_nav1_to_fragment_nav2,bundle);
    }
}