package com.example.lab_04_1

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_04_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.button
        val text = binding.textView
        val tasksSet = listOf("FOOTBALL", "BASKETBALL", "VOLLEYBALL", "TENNIS", "TABLE TENNIS", "MARBLES", "CHESS", "COMPUTER GAMES", "DODGEBALL", "GUITAR", "PIANO", "VIOLIN")

        button.setOnClickListener {
            val rnds = (0..11).random()
            var task = tasksSet[rnds]
            Toast.makeText(this, "ROZPOCZETO LOSOWANIE !!!!!!!!!", Toast.LENGTH_LONG).show()
            Thread.sleep(5000)
            text.text = tasksSet[rnds]
        }
    }
}