package com.sanfor01.applicationa.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

import com.sanfor01.applicationa.R;
import com.sanfor01.applicationa.databinding.ActivitySplashScreenBinding;
import com.sanfor01.applicationa.utils.Constants;

import java.util.Random;

public class SplashScreen extends AppCompatActivity {

    int[] drawables = new int[]{R.drawable.screen01,R.drawable.screen02,R.drawable.screen03,R.drawable.screen04};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.background.setImageDrawable(ContextCompat.getDrawable(SplashScreen.this, drawables[new Random().nextInt(drawables.length)]));

        checkData();

    }

    private void checkData() {

        Handler  handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(Constants.loadingStatus == 0) {
                    handler.postDelayed(this, 500);
                }else if(Constants.loadingStatus == 1){
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(SplashScreen.this, "Sorry !! Data cannot be downloaded from the server. Please try again later", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        }, Constants.splash_delay);
    }

}