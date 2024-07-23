package com.example.exam_q3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnLaunchCalculator: Button
    private lateinit var btnLaunchColorSelector: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLaunchCalculator = findViewById(R.id.btnLaunchCalculator)
        btnLaunchColorSelector = findViewById(R.id.btnLaunchColorSelector)

        // Set up button click listeners
        btnLaunchCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("message", "Launching Calculator App")
            startActivity(intent)
        }

        btnLaunchColorSelector.setOnClickListener {
            val intent = Intent(this, ColorSelectorActivity::class.java)
            intent.putExtra("message", "Launching Color Selector App")
            startActivity(intent)
        }

        // Load the fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, InfoFragment())
            .commit()
    }
}
