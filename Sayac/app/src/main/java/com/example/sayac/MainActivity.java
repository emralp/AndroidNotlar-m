package com.example.sayac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
    }

    public void button(View view) {
        //sayaç oluşturalım
        new CountDownTimer(60000,1000){ // milisaniye cinsinden yazıyoruz

            @Override
            public void onTick(long l) {     //her geri sayımda ne olsun
                textView.setText("Kaldı : "+l/1000);
            }

            @Override
            public void onFinish() {        // bitince ne olsun
                // bitince ne olsun
                Toast.makeText( MainActivity.this, "bitti", Toast.LENGTH_SHORT).show();
                textView.setText("Geri sayım bitti.");
            }
        }.start();

    }


}