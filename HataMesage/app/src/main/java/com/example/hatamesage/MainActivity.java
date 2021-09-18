package com.example.hatamesage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void save(View view){

        AlertDialog.Builder alert= new AlertDialog.Builder(this); // hata mesajını oluşturdum this ile context verdim
        // hata mesajımın özelliklerini belirtiyorum
        alert.setTitle("Kaydet");
        alert.setMessage("Kaydetsin mi?");
        //şimdi kullanıcıya iki seçenek sunacak evet- Hayır  ve butonlara basıldığında ne yapılacağını inner classlarla belirteceğiz
        alert.setPositiveButton("evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
             // evet butonuna basılınca ne yapılacağını belirtiğimizalan mesela ben Toast mesajı göstermek istiyorum
                Toast.makeText(MainActivity.this, "Bilgiler kaydedildi", Toast.LENGTH_SHORT).show(); // context mainactivity.this
            }
        });
        //şimdide hayır butonuna basıldığında ne yapılacak
        alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Bilgiler kaydedilmedi", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show(); // bunu KOymayı unutma sonra

    }




}