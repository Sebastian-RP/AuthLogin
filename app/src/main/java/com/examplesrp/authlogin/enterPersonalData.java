package com.examplesrp.authlogin;

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

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class enterPersonalData extends AppCompatActivity {

    Button selefecha;
    TextView tvfecha, addNamePersonalData, addPlacePersonalData;
    Calendar actual = Calendar.getInstance();//hace muestra la fecha actual en el calendario
    Calendar calendar = Calendar.getInstance();

    String strDate = "00/00/00";
    String nameUser, namePlace, sexSelected = "";

    RadioButton radioMale, radioFemale; //botonredondo de sexo


    private int dia, mes, anio;
    Button enterPersonalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_personal_data);

        addNamePersonalData = findViewById(R.id.addNamePersonalData);
        addPlacePersonalData = findViewById(R.id.addPlacePersonalData);
        selefecha = findViewById(R.id.btn_selefecha);
        tvfecha = findViewById(R.id.tv_fecha);

        radioFemale = (RadioButton) findViewById(R.id.radioFemale);
        radioMale = (RadioButton) findViewById(R.id.radioMale);

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
                        tvfecha.setText(strDate); //variable donde se almacenr la fecha seleccionada
                    }
                }, anio, mes, dia);//esta sera la fecha mostrada en el calendario al desplegarse, la cual es la actual
                datePickerDialog.show();
            }
        });

        enterPersonalData.setOnClickListener(new View.OnClickListener() {

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

                System.out.println("Nombre= " + nameUser + " Fecha= " + strDate + " Ciudad= " + namePlace + " Sexo= " + sexSelected);
                Toast.makeText(getApplicationContext(),"Datos ingresados correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}