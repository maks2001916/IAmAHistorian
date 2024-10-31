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
    private var countQuestion = 0
    private var countPoints = 0

    val myintent = Intent(this, ResultActivity::class.java)


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

        questionTV.setText(R.string.question_1)
        answer_1.setText(R.string.answer_1_1)
        answer_1.setOnClickListener {checkingForCorrectness(true)}
        answer_2.setText(R.string.answer_1_2)
        answer_1.setOnClickListener {checkingForCorrectness(false)}
        answer_3.setText(R.string.answer_1_3)
        answer_1.setOnClickListener {checkingForCorrectness(false)}



    }

    fun nextQuestion() {
        if (countQuestion < 6) {
            when (countQuestion) {
                2 -> {
                    questionTV.setText(R.string.question_2)
                    answer_1.setText(R.string.answer_2_1)
                    answer_1.setOnClickListener {checkingForCorrectness(false)}
                    answer_2.setText(R.string.answer_2_2)
                    answer_2.setOnClickListener {checkingForCorrectness(false)}
                    answer_3.setText(R.string.answer_3_3)
                    answer_3.setOnClickListener {checkingForCorrectness(true)}
                }
                3 -> {
                    questionTV.setText(R.string.question_3)
                    answer_1.setText(R.string.answer_3_1)
                    answer_1.setOnClickListener {checkingForCorrectness(false)}
                    answer_2.setText(R.string.answer_3_2)
                    answer_1.setOnClickListener {checkingForCorrectness(true)}
                    answer_3.setText(R.string.answer_3_3)
                    answer_1.setOnClickListener {checkingForCorrectness(false)}
                }
                4 -> {
                    questionTV.setText(R.string.question_4)
                    answer_1.setText(R.string.answer_4_1)
                    answer_1.setOnClickListener {checkingForCorrectness(true)}
                    answer_2.setText(R.string.answer_4_2)
                    answer_1.setOnClickListener {checkingForCorrectness(false)}
                    answer_3.setText(R.string.answer_4_3)
                    answer_1.setOnClickListener {checkingForCorrectness(false)}
                }
                5 -> {
                    questionTV.setText(R.string.question_5)
                    answer_1.setText(R.string.answer_5_1)
                    answer_1.setOnClickListener {checkingForCorrectness(false)}
                    answer_2.setText(R.string.answer_5_2)
                    answer_1.setOnClickListener {checkingForCorrectness(true)}
                    answer_3.setText(R.string.answer_5_3)
                    answer_1.setOnClickListener {checkingForCorrectness(false)}
                }
                6 -> {
                    answer_1.setOnClickListener {
                        myintent.putExtra("count", countPoints)
                        startActivity(intent) }
                    answer_2.setOnClickListener {
                        myintent.putExtra("count", countPoints)
                        startActivity(intent) }
                    answer_3.setOnClickListener {
                        myintent.putExtra("count", countPoints)
                        startActivity(intent) }
                }
            }
        }
    }

    fun checkingForCorrectness(answer: Boolean) {
        if (answer) {
            countPoints+=100
            countQuestion++
            nextQuestion()
        } else {
            countQuestion++
            nextQuestion()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.test_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitBTN -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}