package com.example.iamahistorian

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class TestActivity : AppCompatActivity() {

    private lateinit var toolbarTB: Toolbar
    private lateinit var answer_1: RadioButton
    private lateinit var answer_2: RadioButton
    private lateinit var answer_3: RadioButton
    private lateinit var questionTV: TextView
    private var countQuestion = 1
    private var countPoints = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test)



        toolbarTB = findViewById(R.id.activity_testTB)
        answer_1 = findViewById(R.id.answer_1)
        answer_2 = findViewById(R.id.answer_2)
        answer_3 = findViewById(R.id.answer_3)
        questionTV = findViewById(R.id.questionTV)

        setSupportActionBar(toolbarTB)

        startQuiz()

    }

    fun startQuiz() {
        updateQuestion()
    }

    fun updateQuestion() {
        when (countQuestion) {
            1 -> {
                questionTV.setText(R.string.question_1)
                answer_1.setText(R.string.answer_1_1)
                answer_2.setText(R.string.answer_1_2)
                answer_3.setText(R.string.answer_1_3)
                setAnswerListeners(correctAnswer = 1)
            }
            2 -> {
                questionTV.setText(R.string.question_2)
                answer_1.setText(R.string.answer_2_1)
                answer_2.setText(R.string.answer_2_2)
                answer_3.setText(R.string.answer_2_3)
                setAnswerListeners(correctAnswer = 3)
            }
            3 -> {
                questionTV.setText(R.string.question_3)
                answer_1.setText(R.string.answer_3_1)
                answer_2.setText(R.string.answer_3_2)
                answer_3.setText(R.string.answer_3_3)
                setAnswerListeners(correctAnswer = 2)
            }
            4 -> {
                questionTV.setText(R.string.question_4)
                answer_1.setText(R.string.answer_4_1)
                answer_2.setText(R.string.answer_4_2)
                answer_3.setText(R.string.answer_4_3)
                setAnswerListeners(correctAnswer = 1)
            }
            5 -> {
                questionTV.setText(R.string.question_5)
                answer_1.setText(R.string.answer_5_1)
                answer_2.setText(R.string.answer_5_2)
                answer_3.setText(R.string.answer_5_3)
                setAnswerListeners(correctAnswer = 2)
            }
            6 -> {
                // Переход к результатам
                answer_1.setOnClickListener { finishQuiz() }
                answer_2.setOnClickListener { finishQuiz() }
                answer_3.setOnClickListener { finishQuiz() }
            }
        }
    }

    fun setAnswerListeners(correctAnswer: Int) {
        answer_1.setOnClickListener { checkingForCorrectness(correctAnswer == 1) }
        answer_2.setOnClickListener { checkingForCorrectness(correctAnswer == 2) }
        answer_3.setOnClickListener { checkingForCorrectness(correctAnswer == 3) }
    }

    fun checkingForCorrectness(isCorrect: Boolean) {
        if (isCorrect) {
            countPoints += 100
        }
        countQuestion++
        updateQuestion()
    }

    fun finishQuiz() {
        var resultIntent = Intent(this, ResultActivity::class.java)
        resultIntent.putExtra("count", countPoints)
        startActivity(resultIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.test_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitBTN -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}