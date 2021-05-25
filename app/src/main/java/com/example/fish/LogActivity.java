package com.example.fish;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
public class LogActivity extends Activity {
    //Создаем переменные для нашей анимации
    private Animation logoAnim, buttonLogoAnim;
    private String TAG = "MyLog";
    private ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        init();
        startMainActivity();



    }
    private  void init() {
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_anim);
        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_anim);
        logoImage = findViewById(R.id.logImage);
        logoImage.startAnimation(logoAnim);

    }
    public void onClickStart(View view)
    {
        Intent i = new Intent(LogActivity.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void startMainActivity() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(LogActivity.this,MainActivity.class);
                startActivity(i);
            }
        }).start();
    }
}