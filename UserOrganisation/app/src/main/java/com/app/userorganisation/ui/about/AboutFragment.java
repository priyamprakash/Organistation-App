package com.app.userorganisation.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.userorganisation.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_about, container, false);
        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_label , "Computer Science" , "Description of CS"));
        list.add(new BranchModel(R.drawable.ic_label , "Mechanical Engineering" , "Description of Mechanical"));

        adapter = new BranchAdapter(getContext() , list);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        ImageView imageView = view.findViewById(R.id.college_img);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/organisation-app-3d8a5.appspot.com/o/mitmuzz.jpg?alt=media&token=cb93b50a-397a-4845-90e4-5a3361823ee7")
                .into(imageView);

        return view;
    }
}