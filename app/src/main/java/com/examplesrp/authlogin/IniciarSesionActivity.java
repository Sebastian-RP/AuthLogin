package com.examplesrp.authlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class IniciarSesionActivity extends AppCompatActivity {

    private EditText correo;
    private EditText contrasena;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        correo = findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasena);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void iniciarSesion(View view){

        mAuth.signInWithEmailAndPassword(correo.getText().toString(), contrasena.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                            String nombre3 = getIntent().getStringExtra("keyNombreToShow2");//valores de variables traidos enterPersonalData(delete)
                            String correo3 = getIntent().getStringExtra("keyCorreoToShow2");
                            String fecha3 = getIntent().getStringExtra("keyFechaToShow2");
                            String ciudad3 = getIntent().getStringExtra("keyCiudadToShow2");

                            Intent intent = new Intent(IniciarSesionActivity.this, mainMenu.class);//enviamos los valores de las variables a menu
                            intent.putExtra("keyNombreToShow3", nombre3);
                            intent.putExtra("keyCorreoToShow3", correo3);
                            intent.putExtra("keyFechaToShow3", fecha3);
                            intent.putExtra("keyCiudadToShow3", ciudad3);
                            startActivity(intent);

                            System.out.println("Nombre de usuario = " +nombre3+correo3+fecha3+ciudad3+" y no pierdas de vista el fuego y la luz");
                            //Intent i = new Intent(getApplicationContext(), mainMenu.class);
                            //startActivity(i);
                            Toast.makeText(getApplicationContext(), "Authentication work fine.", Toast.LENGTH_SHORT).show();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                        //...
                    }
                });

    }
}//hasta aca ya llegan los datos, lo siguient es neviarlos al siguiente activity. menu y luego profile