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
    private Button btnGoHome;

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

        nameProfile.setText(nombre1);//datos que llegan para mostrarse
        emailProfile.setText(correo1);
        dateProfile.setText(fecha1);
        countryProfile.setText(ciudad1);

        btnGoHome=(Button) findViewById(R.id.btn_go_home);

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

    }
}