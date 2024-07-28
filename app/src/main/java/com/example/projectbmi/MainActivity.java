package com.example.projectbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight,editHeightFt,editHeightIn ;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;


        editWeight = findViewById(R.id.editweight);
        editHeightFt = findViewById(R.id.editheightFt);
        editHeightIn = findViewById(R.id.editheightIn);
        txtResult = findViewById(R.id.txtResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               int wt = Integer.parseInt(editWeight.getText().toString());
               int Ft = Integer.parseInt(editHeightFt.getText().toString());
               int In = Integer.parseUnsignedInt(editHeightIn.getText().toString());

               int totalIn = Ft*12 +In;

               double totalCm = totalIn*2.53;

               double totalM = totalCm/100;

               double bmi = wt/(totalM*totalM);

               if (bmi>25){
                   txtResult.setText("you are OverWeight!");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
               }else if(bmi<18){
                   txtResult.setText("you are UnderWeight!");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
               }else{
                   txtResult.setText("you are Healthy");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
               }


            }
        });







    }
}