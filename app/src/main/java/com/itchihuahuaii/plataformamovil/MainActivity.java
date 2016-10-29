package com.itchihuahuaii.plataformamovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_act3,btn_act2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_act3= (Button)findViewById(R.id.btn_act3);
        btn_act3.setOnClickListener(this);
        btn_act2= (Button)findViewById(R.id.btn_act2);
        btn_act2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_act3){
            Intent intent = new Intent(this,Main3Activity.class);


            startActivity(intent);
        }if(v.getId()==R.id.btn_act2){

        }
    }
}
