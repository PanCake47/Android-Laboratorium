package com.example.lab_04_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_04_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.button
        val text = binding.textView
        val moneta = binding.losowanie
        val monety = listOf("ORZEL", "RESZKA")
        var rnds_control = 0

        fun rzut() {
            var rnds = (0..1).random()
            rnds_control = rnds
            Toast.makeText(this, "RZUCILES MONETA", Toast.LENGTH_SHORT).show()

            if (rnds == 1) {
                moneta.setBackgroundResource(R.drawable.reszka)
            }
            else moneta.setBackgroundResource(R.drawable.orzel)
            text.text = monety[rnds]
        }

        button.setOnClickListener {
            if (rnds_control == 1) {
                moneta.animate().apply {
                    duration = 1000
                    rotationXBy(720f)
                }.withStartAction {
                    rzut()
                }.start()
            }
            else if (rnds_control == 0) {
                moneta.animate().apply {
                    duration = 1000
                    rotationXBy(900f)
                }.withStartAction {
                    rzut()
                }.start()
            }
        }
    }
}