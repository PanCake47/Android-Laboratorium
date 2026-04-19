package com.example.lab_02_03

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonShowName = findViewById<Button>(R.id.buttonShowName)

        buttonShowName.setOnClickListener {
            val name = editTextName.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "Nie podano imienia!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Cześć, $name!", Toast.LENGTH_LONG).show()
        }

        val textViewCounter = findViewById<TextView>(R.id.TextViewCounter)
        val buttonAddOne = findViewById<Button>(R.id.buttonAddOne)

        var currentCount = 0

        buttonAddOne.setOnClickListener {
            currentCount++
            val showCount = "Licznik wciśnięć przycisku: $currentCount"
            textViewCounter.text = showCount
        }

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)

        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)


        buttonMultiply.setOnClickListener {
            val num1 = editTextNumber1.text
            val num2 = editTextNumber2.text


            if (num1.isEmpty() || num2.isEmpty()) {
                Toast.makeText(this, "Błędne wprowadzenie danych", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = num1.toString().toBigDecimal() * num2.toString().toBigDecimal()

            textViewResult.text = result.toString()
        }
    }
}