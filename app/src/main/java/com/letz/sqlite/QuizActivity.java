package com.letz.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity
{
    private TextView tvCorrect, tvWrong, tvEmpty;
    private ImageView ivFlag, ivNext;
    private Button btnA, btnB, btnC, btnD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvCorrect = findViewById(R.id.tvCorrect_QuizActivity);
        tvWrong = findViewById(R.id.tvWrong_QuizActivity);
        tvEmpty = findViewById(R.id.tvEmpty_QuizActivity);
        ivFlag = findViewById(R.id.ivFlag_QuizActivity);
        ivNext = findViewById(R.id.ivNext_QuziActivity);
        btnA = findViewById(R.id.btnA_QuizActivity);
        btnB = findViewById(R.id.btnB_QuizActivity);
        btnC = findViewById(R.id.btnC_QuizActivity);
        btnD = findViewById(R.id.btnD_QuizActivity);

        // Onclick
        btnA.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

            }
        });
        btnB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

            }
        });
        btnC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

            }
        });
        btnD.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

            }
        });

    }
}