package com.example.bmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.bmi.model.Calculate;


/**
 * Created by maximize on 10/23/2016 AD.
 */

public class Show extends AppCompatActivity {
    Calculate cal = new Calculate();
    TextView tvBMI, treshold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        tvBMI = (TextView) findViewById(R.id.bmi);
        treshold = (TextView) findViewById(R.id.threshold);

        String getBMI = getIntent().getStringExtra("bmi");

        String BMI = cal.showBMI(getBMI).toString();
        String text = cal.showText(getBMI).toString();

        tvBMI.setText(BMI);
        treshold.setText(text);


    }
}
