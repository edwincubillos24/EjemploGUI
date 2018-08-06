package com.edwinacubillos.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eNombre, ePassword, eRepPassword;
    private Button bGuardar;
    private TextView tDatos;
    private String sexo = "masculino";
    private CheckBox chCine, chPS4, chDormir, chFutbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre = findViewById(R.id.eNombre);
        ePassword = findViewById(R.id.ePassword);
        eRepPassword = findViewById(R.id.eRepPassword);
        bGuardar = findViewById(R.id.bGuardar);
        tDatos = findViewById(R.id.tDatos);
        chCine = findViewById(R.id.chCine);
        chPS4 = findViewById(R.id.chPS4);
        chDormir = findViewById(R.id.chDormir);
        chFutbol = findViewById(R.id.chFutbol);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, pass, repPass,hobbies="";

                nombre = eNombre.getText().toString();
                pass = ePassword.getText().toString();
                repPass = eRepPassword.getText().toString();

                if (nombre.equals("") || pass.equals("") || repPass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Digite todos los datos",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repPass)) {
                        if (chCine.isChecked()) hobbies = hobbies + " Cine";
                        if (chDormir.isChecked()) hobbies = hobbies + " Dormir";
                        if (chFutbol.isChecked()) hobbies = hobbies + " Futbol";
                        if (chPS4.isChecked()) hobbies = hobbies + " PS4";
                        tDatos.setText("Nombre: " + nombre + "\nSexo: " + sexo + "\nHobbies: "+ hobbies);
                    } else {
                        Toast.makeText(getApplicationContext(), "Contrasenas no son iguales",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    public void radioButtonClicked(View view) {
        int id = view.getId();

        if (id == R.id.rMasculino) {
            sexo = "masculino";
        } else {
            sexo = "femenino";
        }
    }
}
