package com.yak7.la22an;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {

  //  @Override
  //  protected void onCreate(Bundle savedInstanceState) {
   //     super.onCreate(savedInstanceState);
   //     setContentView(R.layout.splash_activity);

   //     new Handler().postDelayed(new Runnable() {
    //        @Override
    //        public void run() {
     //           Intent i = new Intent(SplashActivity.this, MenuActivity.class);
    //            startActivity(i);
    //            finish();
    //        }
    //    }, 2*1000);
   // }
    private Handler handler = new Handler();
@Override
    protected void onStart(){
    super.onStart();
    handler.postDelayed(runnable, TimeUnit.SECONDS.toMillis(2));
}

    @Override
    protected void onStop(){
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    private Runnable runnable = () -> {
   Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
   startActivity(intent);
    finish();
   };

}
