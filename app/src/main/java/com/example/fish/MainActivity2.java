package com.example.fish;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity2 extends AppCompatActivity {
    private TextView text_content;
    private ActionBar actionBar;
    private int category=0;
    private int position=0;
    private ImageView iContent;
    private Typeface face1;
    private SharedPreferences def_pref;
    private int [] array_fish = {R.string.fish1, R.string.fish_2, R.string.fish3, R.string.fish4, R.string.fish5};
    private int [] array_na= {R.string.na_1, R.string.na_2, R.string.na_3, R.string.na_4};
    private  int [] array_image = {R.drawable.karp, R.drawable.som, R.drawable.schuka, R.drawable.osetr, R.drawable.nalim};
    private  String [] array_title = {"Карп", "Сом","Щука","Осетр", "Налим"};
    private int [] array_advice = {R.string.advice1, R.string.advice2, R.string.advice3, R.string.advice4, R.string.advice5, R.string.advice6, R.string.advice7, R.string.advice8, R.string.advice9, R.string.advice10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageView);
        receiveIntent();
        init();

    }
    private  void receiveIntent() {
        Intent i = getIntent();
        if (i!= null) {
            category = i.getIntExtra("category",0);
            position = i.getIntExtra("position", 0);
        }
        switch (category) {
            case 0:
                iContent.setImageResource(array_image[position]);
                text_content.setText(array_fish[position]);
                //find actionBar
                actionBar = getSupportActionBar();
                actionBar.setTitle(array_title[position]);

                break;
            case 1:
                text_content.setText(array_na[position]);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                text_content.setTextColor(Color.RED);
                text_content.setText(array_advice[position]);
                break;
        }
    }
    private void init() {
        def_pref = PreferenceManager.getDefaultSharedPreferences(this);
        face1 = Typeface.createFromAsset(this.getAssets(), "fonts/AkayaTelivigala-Regular.ttf");
        text_content.setTypeface(face1);
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        String text = def_pref.getString("main_text_size", "Средний");
        if (text != null) {
            switch (text) {
                case "Большой":
                    text_content.setTextSize(24);
                    break;
                case "Средний":
                    text_content.setTextSize(18);
                    break;
                case "Маленький":
                    text_content.setTextSize(14);
                    break;
            }
        }

    }
}