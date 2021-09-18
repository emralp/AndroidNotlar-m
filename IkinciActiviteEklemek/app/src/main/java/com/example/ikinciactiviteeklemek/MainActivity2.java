package com.example.ikinciactiviteeklemek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    String gelenBilgi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView2);  // nesnemi tanımladım
        //gelecek veriyi karşılıyorum
        Intent intent=getIntent(); // bir intent oluşturdum bu sefer getintent dedim
         gelenBilgi= intent.getStringExtra("AnahtarKelime");  // ilk activiteden gelen bilgiyi bulabilmek için anahtar kelimeyi girdim
        textView.setText(gelenBilgi);  // 1. aktiviteden gelen bilgiyi 2.activitenin textview ine atadım
    }


    public void goto1(View view){
        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
}