package com.edwinacubillos.notas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eQuices, eLabs, eExpo, eP1, ePf;
    private TextView tNotaFinal;
    private Button bCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eQuices = findViewById(R.id.eQuices);
        eLabs = findViewById(R.id.eLabs);
        eExpo = findViewById(R.id.eExpo);
        eP1 = findViewById(R.id.eP1);
        ePf = findViewById(R.id.ePf);
        tNotaFinal = findViewById(R.id.tNotaFinal);
        bCalcular = findViewById(R.id.bCalcular);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double quices, labs, expo, p1, pf, notaFinal;
                String msg;

                quices = Double.parseDouble(eQuices.getText().toString());
                labs = Double.parseDouble(eLabs.getText().toString());
                expo = Double.parseDouble(eExpo.getText().toString());
                p1 = Double.parseDouble(eP1.getText().toString());
                pf = Double.parseDouble(ePf.getText().toString());

                notaFinal = quices * 0.2 + labs * 0.3 + expo * 0.1 + p1 * 0.15 + pf * 0.25;

                tNotaFinal.setText(String.valueOf(notaFinal));

                if (notaFinal >= 0 && notaFinal <= 1) {
                    msg = "Estas en el lugar equivocado";
                } else if (notaFinal > 1 && notaFinal <= 2) {
                    msg = "Remal";
                } else if (notaFinal > 2 && notaFinal <= 3) {
                    msg = "Puedes mejorar";
                } else if (notaFinal > 3 && notaFinal <= 4) {
                    msg = "Normalito";
                } else if (notaFinal > 4 && notaFinal <= 4.5) {
                    msg = "Muy bien";
                } else
                    msg = "Excelente estudiante";

                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
                Log.d("resultado",msg);
                System.out.println(msg);
            }
        });

    }
}
