package com.letz.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

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
    private ArrayList<FlagsModel> wrongOptionsList;

    HashSet<FlagsModel> mixOptions = new HashSet<>();
    ArrayList<FlagsModel> options = new ArrayList<>();

    boolean buttonControl = false;

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
                answerControl(btnA);
            }
        });
        btnB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                answerControl(btnB);
            }
        });
        btnC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                answerControl(btnC);

            }
        });
        btnD.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                answerControl(btnD);
            }
        });

        ivNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                // inc. value of question var.
                question++;

                if (!buttonControl && question < 10) {
                    empty++;
                    tvEmpty.setText("Empty:" + empty);
                    loadQuestions();
                } else if (buttonControl && question < 10) {
                    loadQuestions();

                    btnA.setClickable(true);
                    btnB.setClickable(true);
                    btnC.setClickable(true);
                    btnD.setClickable(true);

                    btnA.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary_dark));
                    btnB.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary_dark));
                    btnC.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary_dark));
                    btnD.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary_dark));
                }

                else if (question == 10)
                {
                    Intent igoResultActivity = new Intent(QuizActivity.this,ResultActivity.class);
                    igoResultActivity.putExtra("correct", correct);
                    igoResultActivity.putExtra("wrong", wrong);
                    igoResultActivity.putExtra("empty", empty);
                    startActivity(igoResultActivity);
                    finish();
                }
                buttonControl = false;

            }
        });
    }

    public void loadQuestions() {
        tvQuestion.setText("Question : " + (question + 1));

        correctFlag = questionList.get(question);

        ivFlag.setImageResource(getResources().getIdentifier(
                correctFlag.getFlag_name(), "drawable", getPackageName()
        ));

        wrongOptionsList = new FlagsDAO().getRandomThreeOptions(flagsDatabase, correctFlag.getFlag_id());
        mixOptions.clear();
        mixOptions.add(correctFlag);
        mixOptions.add(wrongOptionsList.get(0));
        mixOptions.add(wrongOptionsList.get(1));
        mixOptions.add(wrongOptionsList.get(2));

        options.clear();
        for (FlagsModel flg : mixOptions) // (condition) ? [true path] : [false path];
        {
            options.add(flg);
        }

        btnA.setText(options.get(0).getFlag_name());
        btnB.setText(options.get(1).getFlag_name());
        btnC.setText(options.get(2).getFlag_name());
        btnD.setText(options.get(3).getFlag_name());
    }

    public void answerControl(Button button) {
        String buttonText = button.getText().toString();
        String correctAnswer = correctFlag.getFlag_name();

        if (buttonText.equals(correctAnswer)) {
            correct++;
            button.setBackgroundColor(Color.GREEN);
        } else {
            wrong++;
            button.setBackgroundColor(Color.RED);

            if (btnA.getText().toString().equals(correctAnswer)) {
                btnA.setBackgroundColor(Color.GREEN);
            }
            if (btnB.getText().toString().equals(correctAnswer)) {
                btnB.setBackgroundColor(Color.GREEN);
            }
            if (btnC.getText().toString().equals(correctAnswer)) {
                btnC.setBackgroundColor(Color.GREEN);
            }
            if (btnD.getText().toString().equals(correctAnswer)) {
                btnD.setBackgroundColor(Color.GREEN);
            }
        }

        btnA.setClickable(false);
        btnB.setClickable(false);
        btnC.setClickable(false);
        btnD.setClickable(false);
        // 정답 오답 갯수 표시
        tvCorrect.setText("Correct: " + correct);
        tvWrong.setText("Wrong: " + wrong);

        buttonControl = true;
    }
}