package com.example.ikinciactiviteeklemek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;  // nesnemi tanımladım

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.edittext);  // kullanıcıdan veri alacağım alanı belirttim

    }


    public  void goto2(View view){
        //ikinci aktiviteye geçmek için intent nesnemi oluşturdum constructoruna bulunduğum aktivitenin contextini
        //ikinci parametreye ise gidilecek activiteyi ekledim. en sona da startActivite diyip ıntent objemi parametre verdim.
        Intent intent= new Intent(MainActivity.this,MainActivity2.class);

        //ikinci activiteye veri gönderebilmek için  edittexten veri alıyorum
        String username=editText.getText().toString();  //aldığım veriyi bir değişkene attım
        intent.putExtra("AnahtarKelime",username);  // ikinci activiteye putExtra metodu ile veri gönderebiliyorum
        // bir anahtar kelime sonrada değerimi sakladığım değişkeni giriyorum anahtar kelime 2 activite hangi veriyi alacağını bilsin diye var



        startActivity(intent);
    }


}