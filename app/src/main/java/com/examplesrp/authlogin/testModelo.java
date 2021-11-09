package com.examplesrp.authlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.examplesrp.authlogin.modelo.RegisterDataUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class testModelo extends AppCompatActivity {

    Button toProfile;
    TextView test;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_modelo);

        test = (TextView)findViewById(R.id.testData);
        toProfile = (Button)findViewById(R.id.to_profile);

        myRef.child("correoPersonal").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                RegisterDataUser registerDataUsertemporal = dataSnapshot.getValue(RegisterDataUser.class);
                if(registerDataUsertemporal!=null){
                    System.out.println("Datos");

                }else{
                    String emailFromDb = dataSnapshot.child("correoPersonal").getValue().toString();
                    String nameFromDb = dataSnapshot.child("nombreCompleto").getValue().toString();
                    String dateFromDb = dataSnapshot.child("fechaNacimiento").getValue().toString();
                    String countryFromDb = dataSnapshot.child("ciudadActual").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Fallo leer los datos", Toast.LENGTH_SHORT).show();
            }
        });

    }
}