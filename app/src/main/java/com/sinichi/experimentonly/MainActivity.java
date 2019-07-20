package com.sinichi.experimentonly;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtInputNumber;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInputNumber = findViewById(R.id.edtInputNumber);
        btnCalculate = findViewById(R.id.btnCalculate);

        // On Button clicked
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edtInputNumber.getText().toString())) {
                    edtInputNumber.setError("Please fill the number you desire!");
                } else if (Integer.parseInt(edtInputNumber.getText().toString()) > 33) {
                    Toast.makeText(MainActivity.this, "The number is limited to 33", Toast.LENGTH_SHORT).show();
                } else {
                    int angka = Integer.parseInt(edtInputNumber.getText().toString());
                    calculateFactorial(angka);
                }
            }
        });

    }

    private void calculateFactorial(int angka) {
        int index, fact = 1; // index will increase until equal to variable angka, and keep looping
        for (index = 1; index <= angka; index++) {
            fact *= index;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("The factorial of " + edtInputNumber.getText().toString() + " is " + fact).setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();
    }

}
