package com.examplesrp.authlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button testGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irIniciar(View view){
        String nombre2 = getIntent().getStringExtra("keyNombreToShow1");//valores de variables traidos enterPersonalData(delete)
        String correo2 = getIntent().getStringExtra("keyCorreoToShow1");
        String fecha2 = getIntent().getStringExtra("keyFechaToShow1");
        String ciudad2 = getIntent().getStringExtra("keyCiudadToShow1");

        System.out.println("aca va una variable nombre2= "+nombre2+" C "+correo2+" F "+fecha2+" C "+ciudad2);

        Intent intent = new Intent(MainActivity.this, IniciarSesionActivity.class);//enviamos los valores de las variables a Main
        intent.putExtra("keyNombreToShow2", nombre2);
        intent.putExtra("keyCorreoToShow2", correo2);
        intent.putExtra("keyFechaToShow2", fecha2);
        intent.putExtra("keyCiudadToShow2", ciudad2);
        startActivity(intent);

    }

    public void irRegistrarse(View view){
        Intent i = new Intent(this, RegistrarseActivity.class);
        startActivity(i);
    }
}

