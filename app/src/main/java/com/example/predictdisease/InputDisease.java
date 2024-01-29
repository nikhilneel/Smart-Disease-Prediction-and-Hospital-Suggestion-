package com.example.predictdisease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class InputDisease extends AppCompatActivity {


    Button predict,viewHospitalList;
    TextView entersymp;
    LinearLayout layout;
    ProgressBar p;
    TextView op;
    ScrollView scrollView;

    String url="https://dapi-udfr.onrender.com/predict";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_disease);


        String[] symptoms =  {"Click and select from here","abdominal_pain", "abnormal_menstruation", "acidity", "acute_liver_failure", "altered_sensorium", "anxiety", "back_pain", "belly_pain", "blackheads", "blister", "bloody_stool", "blurred_and_distorted_vision", "body_side", "loss_of_smell", "breathlessness", "bruising", "burning_micturition", "chest_pain", "chills", "coma", "congestion", "continuous_feel_of_urine", "continuous_sneezing", "cough", "cramps", "dark_urine", "dehydration", "depression", "diarrhoea", "dischromic_patches", "dizziness", "drying_and_tingling_lips", "excessive_hunger", "extra_marital_contacts", "family_history", "fast_heart_rate", "fatigue", "fluid_overload", "foul_smell_of_urine", "gases, passage_of", "headache", "high_fever", "hip_joint_pain", "history_of_alcohol_consumption", "indigestion", "inflammatory_nails", "internal_itching", "irritability", "irritation_in_anus", "irritation, throat", "itching", "joint_pain", "knee_pain", "lack_of_concentration", "lethargy", "loss_of_appetite", "loss_of_balance", "loss_of_smell", "malaise", "mild_fever", "mood_swings", "movement_stiffness", "mucoid_sputum", "muscle_pain", "muscle_wasting", "muscle_weakness", "nausea", "neck_pain", "obesity", "patches_in_throat", "pain_behind_the_eyes", "pain_during_bowel_movements", "pain_in_anal_region", "palpitations", "passage_of_gases", "phlegm", "polyuria", "puffy_face_and_eyes", "prognosis", "prominent_veins_on_calf", "pus_filled_pimples", "red_sore_around_nose", "red_spots_over_body", "redness_of_eyes", "receiving_blood_transfusion", "receiving_unsterile_injections", "restlessness", "runny_nose", "rusty_sputum", "scurring", "shivering", "silver_like_dusting", "sinus_pressure", "slurred_speech", "small_dents_in_nails", "spinning_movements", "spotting_urination", "stiff_neck", "stomach_bleeding", "stomach_pain", "swelling_joints", "swelling_of_stomach", "swelled_lymph_nodes","sweating", "swollen_blood_vessels", "swollen_extremeties", "swollen_legs", "throat_irritation", "toxic_look_(typhos)", "unsteadiness", "visual_disturbances", "vomiting", "watering_from_eyes", "weakness_in_limbs", "weakness_of_one_body_side", "weight_gain", "weight_loss", "yellow_crust_ooze", "yellow_urine", "yellowing_of_eyes"};
        Spinner symptom1Spinner = findViewById(R.id.symptom1Spinner);
        Spinner symptom2Spinner = findViewById(R.id.symptom2Spinner);
        Spinner symptom3Spinner = findViewById(R.id.symptom3Spinner);
        Spinner symptom4Spinner = findViewById(R.id.symptom4Spinner);
        Spinner symptom5Spinner = findViewById(R.id.symptom5Spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, symptoms);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter to each Spinner
        symptom1Spinner.setAdapter(adapter);
        symptom2Spinner.setAdapter(adapter);
        symptom3Spinner.setAdapter(adapter);
        symptom4Spinner.setAdapter(adapter);
        symptom5Spinner.setAdapter(adapter);
        Intent i=getIntent();
        predict=findViewById(R.id.button);
        p=findViewById(R.id.progess_bar);
        scrollView=findViewById(R.id.scrollView);
        entersymp=findViewById(R.id.enter_symptom);
        layout=findViewById(R.id.layout_visibility);


        op=findViewById(R.id.op);
        viewHospitalList=findViewById(R.id.view_hospital_list);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.setVisibility(View.VISIBLE);
                String s1 = symptom1Spinner.getSelectedItem().toString();
                String s2 = symptom2Spinner.getSelectedItem().toString();
                String s3 = symptom3Spinner.getSelectedItem().toString();
                String s4 = symptom4Spinner.getSelectedItem().toString();
                String s5 = symptom5Spinner.getSelectedItem().toString();
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String data=jsonObject.getString("disease");


                            scrollView.setVisibility(View.GONE);
                            predict.setVisibility(View.GONE);
                            entersymp.setVisibility(View.GONE);
                            p.setVisibility(View.GONE);
                            op.setText(data);
                            layout.setVisibility(View.VISIBLE);
                            viewHospitalList.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent x=new Intent(InputDisease.this,OutputPage.class);
                                    x.putExtra("op",data);
                                    startActivity(x);

                                }
                            });


//                          Intent x=new Intent(InputDisease.this,OutputPage.class);
//                          op.setText(data);
//                          x.putExtra("op",data);
//                          p.setVisibility(View.GONE);
//                          startActivity(x);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(InputDisease.this,error.getMessage(),Toast.LENGTH_LONG);
                    }
                }){
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();


                        params.put("s1",s1);
                        params.put("s2",s2);
                        params.put("s3",s3);
                        params.put("s4",s4);
                        params.put("s5",s5);
                        return params;
                    }
                };
                RequestQueue queue= Volley.newRequestQueue(InputDisease.this);
                queue.add(stringRequest);
            }
        });
    }
}