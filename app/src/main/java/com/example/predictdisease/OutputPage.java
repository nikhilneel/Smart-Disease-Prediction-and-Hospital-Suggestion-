package com.example.predictdisease;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OutputPage extends AppCompatActivity {

    TextView disease,h1,h2,h3;
    RecyclerView recyclerView;
    HAdapter hAdapter;
    ArrayList<HospitalUser> list;
    ProgressBar p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_page);

        recyclerView=findViewById(R.id.hospital_list);
        p=findViewById(R.id.progess);

        Intent x=getIntent();

        String op=x.getStringExtra("op");



        DatabaseReference reference= FirebaseDatabase.getInstance().getReference(op);
        disease=findViewById(R.id.optxt);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        hAdapter=new HAdapter(this,list);

        recyclerView.setAdapter(hAdapter);
        //String phonenoFromDB=snapshot.child(userEnteredUsername).child("phoneno").getValue(String.class);*/



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                    disease.setText(op);
                    HospitalUser hospitalUser=dataSnapshot.getValue(HospitalUser.class);
                    list.add(hospitalUser);

                }
                hAdapter.notifyDataSetChanged();
                p.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}