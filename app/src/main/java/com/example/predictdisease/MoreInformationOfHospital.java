package com.example.predictdisease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MoreInformationOfHospital extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_information_of_hospital);

        Intent i=getIntent();
        String hname=i.getStringExtra("hname");
        Toast.makeText(this,hname,Toast.LENGTH_LONG).show();
    }
}