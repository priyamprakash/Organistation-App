package com.app.userorganisation.ui.faculty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.userorganisation.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


public class FacultyFragment extends Fragment {
    RecyclerView mechanicalDepartment, civilDepartment, electricalDepartment, ecDepartment, itDepartment, leatherDepartment;
    LinearLayout mechanicalNoData, civilNoData, electricalNoData, ecNoData, itNoData, leatherNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6;
    private TeacherAdapter adapter;
    private DatabaseReference reference, dbRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);

        mechanicalDepartment = view.findViewById(R.id.mechanicalDepartment);
        civilDepartment = view.findViewById(R.id.civilDepartment);
        electricalDepartment = view.findViewById(R.id.electricalDepartment);
        ecDepartment = view.findViewById(R.id.ecDepartment);
        itDepartment = view.findViewById(R.id.itDepartment);
        leatherDepartment = view.findViewById(R.id.leatherDepartment);

        mechanicalNoData = view.findViewById(R.id.mechanicalNoData);
        civilNoData = view.findViewById(R.id.civilNoData);
        electricalNoData = view.findViewById(R.id.electricalNoData);
        ecNoData = view.findViewById(R.id.ecNoData);
        itNoData = view.findViewById(R.id.itNoData);
        leatherNoData = view.findViewById(R.id.leatherNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        mechanicalDepartment();
        civilDepartment();
        electricalDepartment();
        ecDepartment();
        itDepartment();
        leatherDepartment();
        return  view;
    }
}