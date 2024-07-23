package com.example.exam_q3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        tvResult = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener { calculate("add") }
        btnSubtract.setOnClickListener { calculate("subtract") }
        btnMultiply.setOnClickListener { calculate("multiply") }
        btnDivide.setOnClickListener { calculate("divide") }
    }

    private fun calculate(operation: String) {
        val number1Str = etNumber1.text.toString()
        val number2Str = etNumber2.text.toString()

        if (number1Str.isEmpty() || number2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val number1 = number1Str.toDouble()
        val number2 = number2Str.toDouble()
        var result = 0.0

        when (operation) {
            "add" -> result = number1 + number2
            "subtract" -> result = number1 - number2
            "multiply" -> result = number1 * number2
            "divide" -> {
                if (number2 == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
                result = number1 / number2
            }
        }

        tvResult.text = "Result: $result"
    }
}
