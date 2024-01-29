package com.example.predictdisease;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.charset.StandardCharsets;

public class RegisterActivity extends AppCompatActivity {
    EditText name,gender,age;
    Button disease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.etname);
        gender=findViewById(R.id.etgender);
        age=findViewById(R.id.etage);
        disease=findViewById(R.id.btndisease);
        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pname= name.getText().toString();
                String pgender =gender.getText().toString();
                int page= Integer.parseInt(age.getText().toString());

                Intent i= new Intent(RegisterActivity.this,PredictDisease.class);
                i.putExtra("key",pname);
                startActivity(i);

            }
        });


    }
}