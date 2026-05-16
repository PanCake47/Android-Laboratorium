package com.example.lab_03_1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_03_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button1 = findViewById<Button>(R.id.button)
        val edittext1 = findViewById<EditText>(R.id.editTextText)
        val textview1 = findViewById<TextView>(R.id.textView)

        button1.setOnClickListener {
            val inputText = edittext1.text

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Błędne wprowadzenie danych", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            textview1.text = inputText
            Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()
            Log.d("inputText", "Imię i nazwisko: $inputText")
        }
    }
}