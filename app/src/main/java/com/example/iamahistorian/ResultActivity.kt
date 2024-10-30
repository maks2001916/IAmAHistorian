package com.example.iamahistorian

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var numberOfPointsTV: TextView
    private lateinit var characteristicSV: ScrollView
    private lateinit var characteristicTV: TextView
    private lateinit var exitBTN: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        numberOfPointsTV = findViewById(R.id.number_of_pointsTV)
        characteristicSV = findViewById(R.id.characteristicSV)
        characteristicTV = findViewById(R.id.characteristicTV)
        exitBTN = findViewById(R.id.exitBTN)
        exitBTN.setOnClickListener {
            finish()
        }

    }
}