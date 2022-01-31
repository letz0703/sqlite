package com.letz.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvTotalCorrect, tvTotalWrong, tvTotalEmpty, tvSuccessRate;
    private Button btnPlayAgain, btnQuit;

    // 3 variable for
    int correct, wrong, empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvTotalCorrect = findViewById(R.id.tvTotalCorrect_ResultActivity);
        tvTotalWrong = findViewById(R.id.tvTotalWrong_ResultActivity);
        tvTotalEmpty = findViewById(R.id.tvTotalEmpty_ResultActivity);
        tvSuccessRate = findViewById(R.id.tvSuccessRate_ResultActivity);

        btnPlayAgain = findViewById(R.id.btnPlayAgain_aResult);
        btnQuit = findViewById(R.id.btnQuit_aResult);

        correct = getIntent().getIntExtra("correct",0);
        wrong = getIntent().getIntExtra("wrong",0);
        empty = getIntent().getIntExtra("empty",0);

        //print correct number
        tvTotalCorrect.setText("Total Correct Answer : "+correct);
        tvTotalWrong.setText("Total Wrong Answer : "+wrong);
        tvTotalEmpty.setText("Total  Empty : "+empty);
        tvSuccessRate.setText("Success Rate : "+(correct*10));

        btnPlayAgain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent igoMainActivity = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(igoMainActivity);
                finish();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(Intent.ACTION_MAIN);
                newIntent.addCategory(Intent.CATEGORY_HOME);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(newIntent);
                finish();
            }
        });
    }
}