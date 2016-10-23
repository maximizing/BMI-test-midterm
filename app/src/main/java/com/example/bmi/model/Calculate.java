package com.example.bmi.model;

import java.text.DecimalFormat;

/**
 * Created by maximize on 10/23/2016 AD.
 */

public class Calculate {
    private float Height, Weight;

    public void add(float h, float w) {
        this.Height = h;
        this.Weight = w;
    }

    public float getBMI() {
        float bmi = Weight/((Height*Height)/10000);
        return bmi;
    }

    public String showText(String b){
        String text="";
        double bmi = Double.parseDouble(b);
        if (bmi < 18.5){
            
            text = "น้ำหนักน้อยกว่าปกติ (ผอม)";
            return text;

        }else if ( bmi >= 18.5 && bmi < 25){

            text = "น้ำหนักปกติ";
            return text;
        }else if (bmi >= 25 && bmi < 30){

            text = "น้ำหนักมากกว่าปกติ (ท้วม)";
            return text;
        }else if (bmi >= 30){

            text = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
            return text;
        }

        return text;
    }

    public String showBMI(String B){
        String BMI = "";
        if (!B.equals("")){
            BMI =  new DecimalFormat("##.##").format(Double.parseDouble(B));
            return BMI;
        }
        return  BMI;
    }

}
