package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtKg,txtUnit,txtPounds,txt1Pounds;
    EditText editKg;
    Button  button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKg =findViewById(R.id.txtKg);
        txtUnit =findViewById(R.id.txtUnit);
        txtPounds =findViewById(R.id.txtPounds);
        editKg =findViewById(R.id.editKg);
        txt1Pounds =findViewById(R.id.txt1Pounds);
        button=findViewById(R.id.button);

        button.setOnClickListener(view -> unitConverter());





    }
    private void unitConverter() {
        String valueInKg = editKg.getText().toString();
        double kilo = Double.parseDouble(valueInKg);
        double pounds = kilo * 2.205;

        String poundsString = getString(R.string.converted_pounds,pounds);
        txt1Pounds.setText(poundsString);
    }
}