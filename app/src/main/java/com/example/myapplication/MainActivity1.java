package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
    //metodo para cambiar de pagina
    public void Siguiete (View view)
    {
        Intent siguiente = new Intent(this, MainActivity2.class);
        startActivity(siguiente);
    }
}