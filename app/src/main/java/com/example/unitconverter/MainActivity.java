package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // This is where the two files are being connected
    }

    public void convert(View view)
    {
        Spinner spinner = (Spinner) findViewById(R.id.choice_spinner); // referencing the dropdown menu
        EditText editText = (EditText) findViewById(R.id.NumInput); // referencing the input value
        TextView textView = (TextView) findViewById(R.id.Answer); // referencing the textView

        double value = 0;
        String a = editText.getText().toString();
        value = Double.parseDouble(a);

        if (String.valueOf(spinner.getSelectedItem()).equals("Miles to Kilometers") && value > 0) {
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);

            value = value * 1.609;
            String.format("0:F2", value);

            textView.setText(df.format(value)+" KM");
        }

        else if (String.valueOf(spinner.getSelectedItem()).equals("Kilometers to Miles") && value > 0){
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);

            value = value / 1.609;
            String.format("0:F2", value);

            textView.setText(df.format(value)+" Miles");
        }

        else{
            String I = "Invalid Entry";
            textView.setText(I);
        }
    }
}