package com.examplesrp.authlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WatchProfile extends AppCompatActivity {

    TextView nameProfile2, emailProfile2, dateProfile2, countryProfile2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_profile);

        nameProfile2 = (TextView) findViewById(R.id.name_profile2);
        emailProfile2 = (TextView) findViewById(R.id.email_profile2);
        dateProfile2 = (TextView) findViewById(R.id.date_profile2);
        countryProfile2 = (TextView) findViewById(R.id.country_profile2);

        String nombre5 = getIntent().getStringExtra("keyNombreToShow4");//valores de variables traidos enterPersonalData(delete)
        String correo5 = getIntent().getStringExtra("keyCorreoToShow4");
        String fecha5 = getIntent().getStringExtra("keyFechaToShow4");
        String ciudad5 = getIntent().getStringExtra("keyCiudadToShow4");

        nameProfile2.setText(nombre5);
        emailProfile2.setText(correo5);
        dateProfile2.setText(fecha5);
        countryProfile2.setText(ciudad5);
        System.out.println("a ver que pex"+nombre5);

    }
}//crear variable que me envie los datos a este id