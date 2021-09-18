package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // global variables lerimi tanıtıyorum

    EditText yastext;
    TextView textView;    // burada görsellerimin türünü tanımladım
    SharedPreferences sharedPreferences; // shared preferences nesnemi tanımladım


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // uygulama açıldığında görsellerimi atıyorum yukarıdaki tanımlara
        yastext=findViewById(R.id.yastext);
        textView=findViewById(R.id.textView);

        sharedPreferences=this.getSharedPreferences("com.example.testapp", Context.MODE_PRIVATE);

        int okunanVeri = sharedPreferences.getInt("kayit",0);
        if(okunanVeri==0){
            textView.setText("Yaşınız : ");
        }else{
            textView.setText("Yaşınız : "+okunanVeri);
        }

    }




    public void save(View view){

        if(!yastext.getText().toString().matches("")){
            int age=Integer.parseInt(yastext.getText().toString());
            textView.setText("Yaşınız : "+age);


            sharedPreferences.edit().putInt("kayit",age).apply();

        }

    }

    public void delete(View view){

        int okunanVeri = sharedPreferences.getInt("kayit",0); // veriyi önce alıyorum okuyorum

        if(okunanVeri !=0){
            sharedPreferences.edit().remove("kayit").apply();  // anahtar kelimeyi girdiğim veriyi sil diyorum
            textView.setText("Yaşınız : ");
        }

    }





}