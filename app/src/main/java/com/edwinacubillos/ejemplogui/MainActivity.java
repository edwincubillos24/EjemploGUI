package com.edwinacubillos.ejemplogui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText eNumero1, eNumero2;
    private TextView tTotal;
    private Button bSumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        eNumero1 = findViewById(R.id.eNumero1);
        eNumero2 = findViewById(R.id.eNumero2);
        tTotal = findViewById(R.id.tTotal);
        bSumar = findViewById(R.id.bSumar);

        bSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double numero1, numero2, total;

                numero1 = Double.parseDouble(eNumero1.getText().toString());
                numero2 = Double.parseDouble(eNumero2.getText().toString());

                total = numero1 + numero2;

                tTotal.setText(String.valueOf(total));

            }
        });
    }
}
