package com.app.adminorganisation.Faculty;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.app.adminorganisation.R;

import java.io.IOException;

public class AddTeacher extends AppCompatActivity {
    ImageView addTeacherImage;
    private Bitmap bitmap = null;
    private EditText addTeacherName, addTeacherEmail, addTeacherPost;
    private Spinner addTeacherCategroy;
    private String category;
    private Button addTeacherBtn;
    private  final int REQ =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
        addTeacherImage = findViewById(R.id.ad dTeacherImage);
        addTeacherName = findViewById(R.id.addTeacherName);
        addTeacherImage = findViewById(R.id.addTeacherImage);
        addTeacherPost = findViewById(R.id.addTeacherPost);
        addTeacherCategroy = findViewById(R.id.addTeacherCategory);
        addTeacherBtn = findViewById(R.id.addTeacherBtn);

        String[] items = new String[]{"Select Department" , "Mechanical" , "Civil" , "Electrical" , "ECE", "Information Technology" , "Leather Technology", "Humanities" ,"B.Pharma" , "Other"};
        addTeacherCategroy.setAdapter(new ArrayAdapter<String>(this , android.R.layout.simple_spinner_dropdown_item , items));
        addTeacherCategroy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category =addTeacherCategroy.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addTeacherImage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openGallery();
                    }
                }
        );

    }
    private void openGallery() {
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage, REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            addTeacherImage.setImageBitmap(bitmap);

        }
    }
}