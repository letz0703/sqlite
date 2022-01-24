package com.letz.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity
{
    private TextView tvCorrect, tvWrong, tvEmpty, tvQuestion;
    private ImageView ivFlag, ivNext;
    private Button btnA, btnB, btnC, btnD;

    private FlagsDatabase flagsDatabase;
    private ArrayList<FlagsModel> questionList;

    int correct = 0;
    int wrong = 0;
    int empty = 0;
    int question = 0;

    private FlagsModel correctFlag; // create model for what?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvCorrect = findViewById(R.id.tvCorrect_QuizActivity);
        tvWrong = findViewById(R.id.tvWrong_QuizActivity);
        tvEmpty = findViewById(R.id.tvEmpty_QuizActivity);
        tvQuestion = findViewById(R.id.tvQuestion_QuizActivity);
        ivFlag = findViewById(R.id.ivFlag_QuizActivity);
        ivNext = findViewById(R.id.ivNext_QuziActivity);
        btnA = findViewById(R.id.btnA_QuizActivity);
        btnB = findViewById(R.id.btnB_QuizActivity);
        btnC = findViewById(R.id.btnC_QuizActivity);
        btnD = findViewById(R.id.btnD_QuizActivity);

        flagsDatabase = new FlagsDatabase(QuizActivity.this);
        questionList = new FlagsDAO().getRandomTenQuestion(flagsDatabase);

        // Onclick
        loadQuestions();
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

    public void loadQuestions() {
        tvQuestion.setText("Question : "+questionList);

        correctFlag = questionList.get(question);

        ivFlag.setImageResource(getResources().getIdentifier(
                correctFlag.getFlag_name(),"drawable", getPackageName()
        ));
    }
}