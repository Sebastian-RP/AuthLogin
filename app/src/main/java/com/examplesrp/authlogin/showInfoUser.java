package com.examplesrp.authlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class showInfoUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info_user);

        TextView nameProfile, emailProfile, dateProfile, countryProfile;

        nameProfile = findViewById(R.id.name_profile);
        emailProfile = findViewById(R.id.email_profile);
        dateProfile = findViewById(R.id.date_profile);
        countryProfile = findViewById(R.id.country_profile);

        String nombre = getIntent().getStringExtra("keyNombreToShow");//vaalores de variables traidos enterPersonalData(delete)
        String correo = getIntent().getStringExtra("keyCorreoToShow");
        String fecha = getIntent().getStringExtra("keyFechaToShow");
        String ciudad = getIntent().getStringExtra("keyCiudadToShow");

        System.out.println("nombre ="+nombre+" Correo= "+correo+" Fecha = "+fecha+"ciudad = "+ciudad);

        nameProfile.setText(nombre);
        emailProfile.setText(correo);
        dateProfile.setText(fecha);
        countryProfile.setText(ciudad);

    }
}