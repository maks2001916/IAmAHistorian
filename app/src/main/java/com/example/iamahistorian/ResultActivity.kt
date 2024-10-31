package com.example.iamahistorian

import android.annotation.SuppressLint
import android.content.Intent
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

        numberOfPointsTV.setText("${R.string.Number_of_points} ${intent.getIntExtra("count", 0)}")
        when (intent.getIntExtra("count", 0)) {
            100 -> characteristicTV.setText("${R.string.characteristic_default} ${R.string.bad}")
            200 -> characteristicTV.setText("${R.string.characteristic_default} ${R.string.not_satisfactory}")
            300 -> characteristicTV.setText("${R.string.characteristic_default} ${R.string.satisfactory}")
            400 -> characteristicTV.setText("${R.string.characteristic_default} ${R.string.good}")
            500 -> characteristicTV.setText("${R.string.characteristic_default} ${R.string.excellent}")
        }
        exitBTN.setOnClickListener { finish() }

    }
}