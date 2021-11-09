package com.examplesrp.authlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.examplesrp.authlogin.modelo.RegisterDataUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class showInfoUser extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    FirebaseAuth auth;
    private ImageView btnGoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info_user);

        TextView nameProfile, emailProfile, dateProfile, countryProfile;

        nameProfile = findViewById(R.id.name_profile);
        emailProfile = findViewById(R.id.email_profile);
        dateProfile = findViewById(R.id.date_profile);
        countryProfile = findViewById(R.id.country_profile);

        String nombre1 = getIntent().getStringExtra("keyNombreToShow");//valores de variables traidos enterPersonalData(delete)
        String correo1 = getIntent().getStringExtra("keyCorreoToShow");
        String fecha1 = getIntent().getStringExtra("keyFechaToShow");
        String ciudad1 = getIntent().getStringExtra("keyCiudadToShow");

        System.out.println("nombre ="+nombre1+" Correo= "+correo1+" Fecha = "+fecha1+"ciudad = "+ciudad1);

        nameProfile.setText(nombre1);
        emailProfile.setText(correo1);
        dateProfile.setText(fecha1);
        countryProfile.setText(ciudad1);

        btnGoHome=(ImageView) findViewById(R.id.btn_go_home);

        btnGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(showInfoUser.this, MainActivity.class);//enviamos los valores de las variables a Main
                intent.putExtra("keyNombreToShow1", nombre1);
                intent.putExtra("keyCorreoToShow1", correo1);
                intent.putExtra("keyFechaToShow1", fecha1);
                intent.putExtra("keyCiudadToShow1", ciudad1);
                startActivity(intent);

                //Intent i = new Intent(showInfoUser.this, MainActivity.class);
                //startActivity(i);
            }
        });

        /*myRef.child(auth.getCurrentUser().getUid()).child("correoPersonal").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                RegisterDataUser registerDataUsertemporal = dataSnapshot.getValue(RegisterDataUser.class);
                if(registerDataUsertemporal!=null){
                    System.out.println("nombre ="+nombre+" Correo= "+correo+" Fecha = "+fecha+"ciudad = "+ciudad);

                }else{
                    String emailFromDb = dataSnapshot.child("correoPersonal").getValue().toString();
                    String nameFromDb = dataSnapshot.child("nombreCompleto").getValue().toString();
                    String dateFromDb = dataSnapshot.child("fechaNacimiento").getValue().toString();
                    String countryFromDb = dataSnapshot.child("ciudadActual").getValue().toString();

                    nameProfile.setText(nameFromDb);
                    emailProfile.setText(emailFromDb);
                    dateProfile.setText(dateFromDb);
                    countryProfile.setText(countryFromDb);
                    System.out.println("nombre2 ="+nombre+" Correo2= "+correo+" Fecha = "+fecha+"ciudad = "+ciudad);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Fallo leer los datos", Toast.LENGTH_SHORT).show();
            }
        });*/


    }
}