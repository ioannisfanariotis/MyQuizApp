package com.example.myquizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val q1 = Question(1, "What country does this flag belong to?",
            R.drawable.estonia, "Latvia", "Estonia", "Austria",
            "Lithuania", 2)
        questionList.add(q1)

        val q2 = Question(2, "What country does this flag belong to?",
            R.drawable.slovakia, "Serbia", "Slovenia", "Croatia",
            "Slovakia", 4)
        questionList.add(q2)

        val q3 = Question(3, "What country does this flag belong to?",
            R.drawable.bosnia, "Montenegro", "Azerbaijan", "Belarus",
            "Bosnia", 4)
        questionList.add(q3)

        val q4 = Question(4, "What country does this flag belong to?",
            R.drawable.denmark, "Finland", "Iceland", "Denmark",
            "Sweden", 3)
        questionList.add(q4)

        val q5 = Question(5, "What country does this flag belong to?",
            R.drawable.latvia, "Latvia", "Estonia", "Austria",
            "Lithuania", 1)
        questionList.add(q5)

        val q6 = Question(6, "What country does this flag belong to?",
            R.drawable.croatia, "Serbia", "Slovenia", "Croatia",
            "Slovakia", 3)
        questionList.add(q6)

        val q7 = Question(7, "What country does this flag belong to?",
            R.drawable.belarus, "Montenegro", "Azerbaijan", "Belarus",
            "Bosnia", 3)
        questionList.add(q7)

        val q8 = Question(8, "What country does this flag belong to?",
            R.drawable.finland, "Finland", "Iceland", "Denmark",
            "Sweden", 1)
        questionList.add(q8)

        val q9 = Question(9, "What country does this flag belong to?",
            R.drawable.lithuania, "Latvia", "Estonia", "Austria",
            "Lithuania", 4)
        questionList.add(q9)

        val q10 = Question(10, "What country does this flag belong to?",
            R.drawable.slovenia, "Serbia", "Slovenia", "Croatia",
            "Slovakia", 2)
        questionList.add(q10)

        val q11 = Question(11, "What country does this flag belong to?",
            R.drawable.montenegro, "Montenegro", "Azerbaijan", "Belarus",
            "Bosnia", 1)
        questionList.add(q11)

        val q12 = Question(12, "What country does this flag belong to?",
            R.drawable.sweden, "Finland", "Iceland", "Denmark",
            "Sweden", 4)
        questionList.add(q12)

        val q13 = Question(13, "What country does this flag belong to?",
            R.drawable.austria, "Latvia", "Estonia", "Austria",
            "Lithuania", 3)
        questionList.add(q13)

        val q14 = Question(14, "What country does this flag belong to?",
            R.drawable.serbia, "Serbia", "Slovenia", "Croatia",
            "Slovakia", 1)
        questionList.add(q14)

        val q15 = Question(15, "What country does this flag belong to?",
            R.drawable.azerbaijan, "Montenegro", "Azerbaijan", "Belarus",
            "Bosnia", 2)
        questionList.add(q15)

        val q16 = Question(16, "What country does this flag belong to?",
            R.drawable.iceland, "Finland", "Iceland", "Denmark",
            "Sweden", 2)
        questionList.add(q16)

        return questionList
    }
}