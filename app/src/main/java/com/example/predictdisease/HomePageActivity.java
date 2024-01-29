package com.example.predictdisease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {
    ImageView img;
    Button predict;

    CardView wantToUSeApp,tips,aboutApp,developers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //  img=findViewById(R.id.ImgAppLogo);

//        predict.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i= new Intent(HomePageActivity.this,InputDisease.class);
//                startActivity(i);
//            }
//        });
        wantToUSeApp=findViewById(R.id.want_to_use_app);
        tips=findViewById(R.id.tips_to_use_app);
        aboutApp=findViewById(R.id.about_app);
        developers=findViewById(R.id.developers);


        wantToUSeApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomePageActivity.this,InputDisease.class);
                startActivity(i);
            }
        });

        developers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomePageActivity.this,AppDevelopers.class);
                startActivity(i);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomePageActivity.this,AppUseTips.class);
                startActivity(i);
            }
        });

        aboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomePageActivity.this,AboutApp.class);
                startActivity(i);
            }
        });


    }
}