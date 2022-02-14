package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
     Button calc;
     EditText heighttext,weighttext;
     TextView categoryx,bmiout;
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc=findViewById(R.id.calculate);
        heighttext=findViewById(R.id.heightInput);
        weighttext=findViewById(R.id.weightInput);
        categoryx=findViewById(R.id.category);
        bmiout=findViewById(R.id.bmioutput);
        rl=findViewById(R.id.RelativeLayout);
        rl.setBackgroundColor(Color.YELLOW);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h=heighttext.getText().toString();

                String w=weighttext.getText().toString();

                if(h.equals("") || w.equals(""))
                {
                    alertDialog();
                }
                else{
                    double weight=Double.parseDouble(w);
                    double height=Double.parseDouble(h);
                    Double BMI=(weight/(height*height));
                    DecimalFormat df = new DecimalFormat("#.#");
                    double BMI_trimmed = Double.parseDouble(df.format(BMI));
                    bmiout.setText(Double.toString(BMI_trimmed));
                    String BMI_Cat;
                    if (BMI < 15)
                        BMI_Cat = "Very severely underweight";
                    else if (BMI < 16)
                        BMI_Cat = "Severely underweight";
                    else if (BMI < 18.5)
                        BMI_Cat = "Underweight";
                    else if (BMI < 25)
                        BMI_Cat = "Normal";
                    else if (BMI < 30)
                        BMI_Cat = "Overweight";
                    else if (BMI < 35)
                        BMI_Cat = "Obese Class 1 - Moderately Obese";
                    else if (BMI < 40)
                        BMI_Cat = "Obese Class 2 - Severely Obese";
                    else
                        BMI_Cat = "Obese Class 3 - Very Severely Obese";

                    categoryx.setText(BMI_Cat);
                }



            }

        });
    }
    public void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Please Select any option");
        dialog.setTitle("Dialog Box");
        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"cancel is clicked",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}