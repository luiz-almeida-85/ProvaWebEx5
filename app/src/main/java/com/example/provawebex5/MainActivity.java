package com.example.provawebex5;


import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnImc1, btntemp, btnConvert, btnVoltar, btnCalc;

    TextView txtGc, txtResultado, txtAltura, txtPeso, txtResultImc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        CarregaTelaPrincipal();
    }

    private void CarregaTelaPrincipal()
    {
        setContentView(R.layout.principal);
        btnImc1 = findViewById(R.id.btnImc1);
        btnImc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregaTelaImc();
            }
        });

        btntemp = findViewById(R.id.btntemp);
        btntemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregaTelaConversor();
            }
        });

    }

    private void CarregaTelaImc()
    {
        setContentView(R.layout.calcimc);

        txtAltura = (TextView) findViewById(R.id.txtAltura);
        txtPeso = (TextView) findViewById(R.id.txtPeso);
        txtResultImc = (TextView) findViewById(R.id.txtResultImc);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregaTelaPrincipal();
            }
        });

        btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                float calcular, a, p;

               a = Float.parseFloat(txtAltura.getText().toString());
               p = Float.parseFloat(txtPeso.getText().toString());
               calcular = p / (a * a);

                txtResultImc.setText(String.format("%.2f", calcular));


            }
        });



    }

    private void CarregaTelaConversor()
    {
        setContentView(R.layout.calcgraus);

        txtGc = (TextView) findViewById(R.id.txtGc);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregaTelaPrincipal();
            }
        });

        btnConvert = findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double calcular, gc;

                gc = Double.parseDouble(txtGc.getText().toString());

                calcular =  gc * 1.8 + 32;

                txtResultado.setText(String.valueOf(calcular));

            }
        });

    }

}