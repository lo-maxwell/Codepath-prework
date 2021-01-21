package com.example.codepath_prework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorStateList oldTextColor =  ((TextView)findViewById(R.id.mainText)).getTextColors();
        Context context = this.getApplicationContext();
        findViewById(R.id.mainConstraintLayout).setBackgroundColor(ContextCompat.getColor(context, R.color.background));
        findViewById(R.id.textColorChangeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ((TextView)findViewById(R.id.mainText)).setTextColor(getRandomColor());
            }
        });

        findViewById(R.id.backgroundColorChangeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                (findViewById(R.id.mainConstraintLayout)).setBackgroundColor(getRandomColor());
            }
        });

        findViewById(R.id.textChangeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if ((((TextView)findViewById(R.id.editText)).getText()).toString().trim().length() == 0) ((TextView)findViewById(R.id.mainText)).setText("Android is awesome!");
                else ((TextView)findViewById(R.id.mainText)).setText(((TextView)findViewById(R.id.editText)).getText());
                ((TextView)findViewById(R.id.editText)).setText(null);
            }
        });

        findViewById(R.id.mainConstraintLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ((TextView)findViewById(R.id.mainText)).setText("Hello from Maxwell!");
                ((TextView)findViewById(R.id.mainText)).setTextColor(oldTextColor);
                findViewById(R.id.mainConstraintLayout).setBackgroundColor(ContextCompat.getColor(context, R.color.background));
            }
        });
    }

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

}