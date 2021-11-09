package com.examplesrp.authlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.examplesrp.authlogin.modelo.RegisterDataUser;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class enterPersonalData extends AppCompatActivity {

    Button selefecha;
    TextView tvfecha, addNamePersonalData, addPlacePersonalData;
    Calendar actual = Calendar.getInstance();//hace muestra la fecha actual en el calendario
    Calendar calendar = Calendar.getInstance();

    String strDate = "00/00/00";
    String nameUser, namePlace, sexSelected = "";

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    FirebaseAuth auth;
    RadioButton radioMale, radioFemale, radioOther; //boton redondo de sexo

    private int dia, mes, anio;
    Button enterPersonalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_personal_data);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Register_users");
        auth = FirebaseAuth.getInstance();

        String correo = getIntent().getStringExtra("keyCorreo");//recibimos datos de RegistrarseActivity
        String contrasena = getIntent().getStringExtra("keyContrasena");

        addNamePersonalData = findViewById(R.id.addNamePersonalData);
        addPlacePersonalData = findViewById(R.id.addPlacePersonalData);
        selefecha = findViewById(R.id.btn_selefecha);
        tvfecha = findViewById(R.id.tv_fecha);

        radioFemale = (RadioButton) findViewById(R.id.radioFemale);
        radioMale = (RadioButton) findViewById(R.id.radioMale);
        radioOther = (RadioButton) findViewById(R.id.radioOther);

        enterPersonalData = (Button) findViewById(R.id.enterPersonalData);

        selefecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anio = actual.get(Calendar.YEAR);
                mes = actual.get(Calendar.MONTH);
                dia = actual.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int y, int m, int d) {
                        calendar.set(Calendar.DAY_OF_MONTH, d);
                        calendar.set(Calendar.MONTH, m);
                        calendar.set(Calendar.YEAR, y);

                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        strDate = format.format(calendar.getTime());
                        tvfecha.setText(strDate); //variable donde se almacena la fecha seleccionada
                    }
                }, anio, mes, dia);//esta sera la fecha mostrada en el calendario al desplegarse, la cual es la actual
                datePickerDialog.show();
            }
        });

        enterPersonalData.setOnClickListener(new View.OnClickListener() {//boton de enviar datos

            @Override
            public void onClick(View v) {
                nameUser = addNamePersonalData.getText().toString();//variable que toma eltexto del textEdit, nombre de la persona
                namePlace  = addPlacePersonalData.getText().toString();

                if (radioFemale.isChecked()) {
                    sexSelected = "femenino";
                }
                if (radioMale.isChecked()) {
                    sexSelected = "masculino";
                }
                if (radioOther.isChecked()) {
                    sexSelected = "Otro";
                }
                System.out.println("Nombre= " + nameUser + " Fecha= " + strDate + " Ciudad= " + namePlace + " Sexo= " + sexSelected + " correo= " + correo + " contraseña= " + contrasena);
                //Toast.makeText(getApplicationContext(),"Datos ingresados correctamente"+correo+" = "+contrasena, Toast.LENGTH_SHORT).show();

                SaveDataOfUser(correo, contrasena, nameUser, strDate, namePlace, sexSelected);
            }

            RegisterDataUser registerDataUser = new RegisterDataUser(correo, contrasena, nameUser, strDate, namePlace, sexSelected);

        });
    }

    public  void SaveDataOfUser(String correo, String contrasena, String nameUser, String strDate, String namePlace, String sexSelected){
        RegisterDataUser registerDataUser = new RegisterDataUser(correo, contrasena, nameUser, strDate, namePlace, sexSelected);



        if(auth.getCurrentUser()!=null){    //si el usuario no es null, guarde eso en base datos
            myRef.child(auth.getCurrentUser().getUid()).setValue(registerDataUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(getApplicationContext(),"se ha guardado correctamente", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(enterPersonalData.this, showInfoUser.class);//enviamos los valores de las variables a showInfoUser
                    intent.putExtra("keyNombreToShow", nameUser);
                    intent.putExtra("keyCorreoToShow", correo);
                    intent.putExtra("keyFechaToShow", strDate);
                    intent.putExtra("keyCiudadToShow", namePlace);
                    startActivity(intent);

                   //Intent i = new Intent(enterPersonalData.this, testModelo.class);
                   //startActivity(i);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),"No se ha guardado", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}//igual mostrar el perfil, volveos y en perfil invocamos de nuevo el perfil
