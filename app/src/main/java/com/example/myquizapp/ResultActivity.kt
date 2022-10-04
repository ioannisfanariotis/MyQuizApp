package com.example.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username: TextView = findViewById(R.id.usermame)
        val score: TextView = findViewById(R.id.score)
        val finish: Button = findViewById(R.id.btnfinish)

        username.text = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        score.text = "Your score is $correctAnswers out of $totalQuestions!"

        finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}