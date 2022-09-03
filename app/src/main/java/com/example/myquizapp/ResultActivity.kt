package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var username: TextView = findViewById(R.id.usermame)
        var score: TextView = findViewById(R.id.score)
        var finish: Button = findViewById(R.id.btnfinish)

        username.text = intent.getStringExtra(Constants.USER_NAME)
        var totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        var correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        score.text = "Your score is $correctAnswers out of $totalQuestions!"

        finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))}
    }
}