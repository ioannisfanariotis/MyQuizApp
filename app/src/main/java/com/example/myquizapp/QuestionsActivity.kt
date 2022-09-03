package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mUsername: String? = null
    private var mCorrectAnswers: Int = 0

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0

    private var progress: ProgressBar? = null
    private var percent: TextView? = null
    private var mainQuestion: TextView? = null
    private var flag: ImageView? = null
    private var submit: Button? = null

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUsername = intent.getStringExtra(Constants.USER_NAME)

        progress = findViewById(R.id.progressBar)
        percent = findViewById(R.id.progressPercent)
        mainQuestion = findViewById(R.id.mainQuestion)
        flag = findViewById(R.id.flags)
        submit = findViewById(R.id.submit)

        optionOne = findViewById(R.id.optionOne)
        optionTwo = findViewById(R.id.optionTwo)
        optionThree = findViewById(R.id.optionThree)
        optionFour = findViewById(R.id.optionFour)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        submit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {

        defaultOption()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        progress?.progress = mCurrentPosition
        percent?.text = "${mCurrentPosition}/${progress?.max}"
        flag?.setImageResource(question.image)
        mainQuestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size)
            submit?.text = "FINISH"
    }

    private fun defaultOption(){
        val options = ArrayList<TextView>()
        optionOne?.let { options.add(0, it) }
        optionTwo?.let { options.add(1, it) }
        optionThree?.let { options.add(2, it) }
        optionFour?.let { options.add(3, it) }

        for(i in options) {
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(this, R.drawable.default_option)
        }
    }

    private fun selectedOption(tv: TextView, optionNum: Int){
        defaultOption()
        mSelectedOption = optionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {optionOne?.let{selectedOption(it, 1)}}
            R.id.optionTwo -> {optionTwo?.let{selectedOption(it, 2)}}
            R.id.optionThree -> {optionThree?.let{selectedOption(it, 3)}}
            R.id.optionFour -> {optionFour?.let{selectedOption(it, 4)}}
            R.id.submit -> {
                if(mSelectedOption==0){
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correct != mSelectedOption)
                        answerView(mSelectedOption, R.drawable.wrong_option)
                    else
                        mCorrectAnswers++
                    answerView(question.correct, R.drawable.correct_option)
                    if(mCurrentPosition == mQuestionList!!.size)
                        submit?.text = "FINISH"
                    else
                        submit?.text = "NEXT QUESTION"
                    mSelectedOption = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> optionOne?.background = ContextCompat.getDrawable(this, drawableView)
            2 -> optionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            3 -> optionThree?.background = ContextCompat.getDrawable(this, drawableView)
            4 -> optionFour?.background = ContextCompat.getDrawable(this, drawableView)
        }
    }
}