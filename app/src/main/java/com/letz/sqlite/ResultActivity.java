package com.letz.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvTotalCorrect, tvTotalWrong, tvEmpty, tvSuccessRate;
    private Button btnPlayAgain, btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvTotalCorrect = findViewById(R.id.tvTotalCorrect_ResultActivity);
        tvTotalWrong = findViewById(R.id.tvTotalWrong_ResultActivity);
        tvEmpty = findViewById(R.id.tvTotalEmpty_ResultActivity);
        tvSuccessRate = findViewById(R.id.tvSuccessRate_ResultActivity);

        btnPlayAgain = findViewById(R.id.btnPlayAgain_aResult);
        btnQuit = findViewById(R.id.btnQuit_aResult);

        btnPlayAgain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

            }
        });
    }
}