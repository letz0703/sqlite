package com.letz.sqlite;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView tvStart;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStart = findViewById(R.id.tvWelcom_Main);
        btnStart = findViewById(R.id.btnStart_Main);

        btnStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent igoQuizActivity = new Intent(MainActivity.this,QuizActivity.class);
                startActivity(igoQuizActivity);
                finish();
            }
        });
    }

}