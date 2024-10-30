package com.example.iamahistorian

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TestActivity : AppCompatActivity() {

    private lateinit var toolbarTB: Toolbar
    private lateinit var testRG: RadioGroup
    private lateinit var questionTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test)

        toolbarTB = findViewById(R.id.activity_testTB)
        testRG = findViewById(R.id.testRG)
        questionTV = findViewById(R.id.questionTV)

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