package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    ProgressBar p;
    Button b;
    TextView t;
    Handler h=new Handler();
    int i=0;
    Intent x;
    boolean isActivo=false;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        p=(ProgressBar) findViewById(R.id.progressBar2);
        b=(Button) findViewById(R.id.button2);
        t=(TextView) findViewById(R.id.porcentaje);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.button2){
            if (!isActivo){
                Thread hilo=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (i<=100){
                            h.post(new Runnable() {
                                @Override
                                public void run() {
                                    t.setText(i+"%");
                                    p.setProgress(i);
                                }
                            });
                            try{
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(i==100){
                                x=new Intent(MainActivity2.this,MainActivity3.class);
                                startActivity(x);
                            }
                            i++;
                            isActivo=true;
                        }
                    }
                });
                hilo.start();
            }
        }
    }
}