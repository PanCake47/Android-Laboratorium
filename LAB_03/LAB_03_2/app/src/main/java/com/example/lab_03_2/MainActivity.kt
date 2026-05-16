package com.example.lab_03_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_03_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var clicksCounter = 0
        binding.clicksTextView.text = "Licznik wciśnięć przycisku = 0"

        binding.addButton.setOnClickListener {
            clicksCounter++
            val showCount = "Licznik wciśnięć przycisku = $clicksCounter"
            binding.clicksTextView.text = showCount
        }

        binding.subButton.setOnClickListener {
            clicksCounter--
            val showCount = "Licznik wciśnięć przycisku = $clicksCounter"
            binding.clicksTextView.text = showCount
        }

        binding.resetButton.setOnClickListener {
            clicksCounter = 0
            val showCount = "Licznik wciśnięć przycisku = $clicksCounter"
            binding.clicksTextView.text = showCount
        }
    }
}