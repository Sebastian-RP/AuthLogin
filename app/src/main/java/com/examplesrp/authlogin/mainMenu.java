package com.examplesrp.authlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class mainMenu extends AppCompatActivity {

    private ImageView profileIconMenu;
    private TextView textProfileMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        profileIconMenu = (ImageView) findViewById(R.id.image_icon_menu);

        String nombre4 = getIntent().getStringExtra("keyNombreToShow3");//valores de variables traidos enterPersonalData(delete)
        String correo4 = getIntent().getStringExtra("keyCorreoToShow3");
        String fecha4 = getIntent().getStringExtra("keyFechaToShow3");
        String ciudad4 = getIntent().getStringExtra("keyCiudadToShow3");

        textProfileMenu = (TextView) findViewById(R.id.text_profile_menu);
        textProfileMenu.setText(nombre4);

        profileIconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainMenu.this, WatchProfile.class);//enviamos los valores de las variables a menu
                intent.putExtra("keyNombreToShow4", nombre4);
                intent.putExtra("keyCorreoToShow4", correo4);
                intent.putExtra("keyFechaToShow4", fecha4);
                intent.putExtra("keyCiudadToShow4", ciudad4);
                startActivity(intent);

                System.out.println("estamos en el main menu con = "+nombre4+correo4+fecha4+ciudad4);
            }
        });


        System.out.println("Nombre de usuario = " +nombre4+correo4+fecha4+ciudad4+" y no pierdas de vista el fuego y la luz");
    }
}