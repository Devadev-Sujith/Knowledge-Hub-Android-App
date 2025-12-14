package com.example.knowledgehub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val letsGoButton = findViewById<Button>(R.id.lets_go_button)
        letsGoButton.setOnClickListener {
            val intent = Intent(this, TechnologiesActivity::class.java)
            startActivity(intent)
        }
    }
}