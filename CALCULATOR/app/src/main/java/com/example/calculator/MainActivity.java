package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Object Button;
    TextView result,input;
    MaterialButton buttonC,buttonAc,button1,buttonE,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonDot,buttonD,buttonA,buttonB,buttonM,buttonS,buttonB1,buttonB2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=findViewById(R.id.result);
        input=findViewById(R.id.input);

        assignId(buttonC,R.id.buttonC);
        assignId(button0,R.id.button0);
        assignId(button1,R.id.button1);
        assignId(button2,R.id.button2);
        assignId(button3,R.id.button3);
        assignId(button4,R.id.button4);
        assignId(button5,R.id.button5);
        assignId(button6,R.id.button6);
        assignId(button7,R.id.button7);
        assignId(button8,R.id.button8);
        assignId(button9,R.id.button9);
        assignId(buttonDot,R.id.buttonDot);
        assignId(buttonAc,R.id.buttonAc);
        assignId(buttonA,R.id.buttonA);
        assignId(buttonS,R.id.buttonS);
        assignId(buttonM,R.id.buttonM);
        assignId(buttonD,R.id.buttonD);
        assignId(buttonB1,R.id.buttonB1);
        assignId(buttonB2,R.id.buttonB2);
        assignId(buttonE,R.id.buttonE);





    }
    void assignId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        MaterialButton button=(MaterialButton) view;
        String buttonTxt=button.getText().toString();
        String dataToCalculate=input.getText().toString();


        if(buttonTxt.equals("AC")){
            input.setText("");
            result.setText("0");
            return;
        }
        if(buttonTxt.equals("=")){
            input.setText(result.getText());
            return;
        }
        if(buttonTxt.equals("C")){
            dataToCalculate=dataToCalculate.substring(0,dataToCalculate.length()-1);
        }
        else{
            dataToCalculate=dataToCalculate+buttonTxt;
        }



        input.setText(dataToCalculate);
        String finalResult=getResult(dataToCalculate);
        if(!finalResult.equals("Err")){
            result.setText(finalResult);
        }


    }
    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if(finalResult.endsWith(".0")){
                finalResult=finalResult.replace(".0","");
            }
            return finalResult;
        } catch (Exception e) {
            return "Err";
        }


    }

}