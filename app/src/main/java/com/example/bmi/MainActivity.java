package com.example.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bmi.model.Calculate;

public class MainActivity extends AppCompatActivity {

    private EditText edtHeight, edtWeight;
    private Button btnCal;
    Calculate cal = new Calculate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHeight = (EditText) findViewById(R.id.edt1);
        edtWeight = (EditText) findViewById(R.id.edt2);
        btnCal = (Button) findViewById(R.id.btn1);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkHW();
            }
        });


    }

    private void checkHW() {
        if (edtHeight.getText().toString().equals("")) {
            showDialog();

        } else if (edtWeight.getText().toString().equals("")) {
            showDialog();

        }else {
            float h,w;
            h = Float.parseFloat(edtHeight.getText().toString());
            w = Float.parseFloat(edtWeight.getText().toString());
            cal.add(h,w);
            String BMI = String.valueOf(cal.getBMI());
            Intent i = new Intent(MainActivity.this, Show.class);
            i.putExtra("bmi",BMI);
            startActivity(i);
        }
    }


    private void showDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("ผิดพลาด");
        dialog.setMessage("ป้อนข้อมูลไม่ครบ");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }
}
