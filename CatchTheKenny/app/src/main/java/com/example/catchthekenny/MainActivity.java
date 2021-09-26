package com.example.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.IpSecManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.ListPreference;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timeText;
    TextView scoreText;
    int score = 0;     // scoru tutacak değişken
    Button basla;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;

    // ImageArray tanımladım
    ImageView[] imageArray;

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.timeText); // textviewlarımı tanıttım initialize ettim
        scoreText = findViewById(R.id.scoreText);
        basla = findViewById(R.id.basla);
        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);


        imageArray = new ImageView[]{imageView, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14};

        hideImage();  // tüm şmajları sakladık
    }


    //imageview basıldığında scoreArttırma metodu
    public void scorArt(View view) {

        score++;  // her imageview a tıklandığında scoreArt metodu çalışacak ve scorum +1 artacak
        scoreText.setText("Score: " + score);

    }


    //gerisayımd ve basla butonu
    public void basla(View view) {


        //gerisayım countdowntime
        new CountDownTimer(20000, 1000) {

            @Override
            public void onTick(long l) {
                timeText.setText("Time: " + l / 1000);   // her geri sayımda ne olsun
            }

            @Override
            public void onFinish() {   // süre bittiğinde ne olsun
                timeText.setText("Time off");
                handler.removeCallbacks(runnable);
                for (ImageView temp : imageArray) {
                    temp.setVisibility(View.INVISIBLE);   // resimlerin oyun bitince görünmez yap
                }

                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Yenidn oyna!");
                alert.setMessage("Yeniden başlamak için evet'e bas");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // evete basınca oyun restart olsun
                        Intent intent=getIntent();
                        finish(); //aktiviteyi kapattım
                        startActivity(intent); // yeniden başlattım yano oyun yenşden başladı.

                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // no yabasınca ne olacak
                        Toast.makeText(MainActivity.this, "Oyun bitti!!!", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();


            }
        }.start();



        // runable ile rastgele imaj göstermek
        handler= new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for (ImageView temp : imageArray) {
                    temp.setVisibility(View.INVISIBLE);   // resimlerin hemsini oyun bitince
                }


                // random sayı üretmek için ise
                Random random=new Random(); //13 e kadar random sayı üretecek
                int i =random.nextInt(14);
                imageArray[i].setVisibility(View.VISIBLE); // rasgele gelen sayıya karşılık gelen dizideki imajı görünür yap

                handler.postDelayed(this,1000); // her yarım saniyede bir rastgele image görünür olsun.
            }
        };

        handler.post(runnable);


    }

    // imajları saklamak
    public void hideImage(){    // bu metodu oncreate altında çalıştırdığımız için daha başlangıçta gizli olacaklar

         for (ImageView temp : imageArray) {
            temp.setVisibility(View.INVISIBLE);   // resimlerin hemsini daha başlandıçta görünmez yap
        }

    }

}