package com.example.lab_05_1

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_05_1.databinding.ActivityMainBinding
import kotlin.math.sqrt
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = binding.titleText
        val waga = binding.wagaText
        val wzrost = binding.wzrostText
        val oblicz = binding.obliczButton
        val wynik = binding.wynikText

        fun anim() {
            title.animate()
                .apply {
                    duration = 4000
                    rotationYBy(360f)
                }
                .withEndAction {
                    anim()
                }
                .start()
        }

        anim()

        oblicz.setOnClickListener {
            val weight = waga.text.toString().toFloat()
            val height = wzrost.text.toString().toFloat()

            if (waga.text.isEmpty() || wzrost.text.isEmpty()) {
                Toast.makeText(this, "WPROWADŹ POPRAWNE DANE", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = "%.2f".format((weight / (height * height)))

            wynik.text = result

            if (result < 18.5.toString()) {
                wynik.setTextColor("#76A2E8".toColorInt())
            }
            if (result >= 18.5.toString() && result < 24.9.toString()) {
                wynik.setTextColor("#55AD26".toColorInt())
            }
            if (result >= 25.0.toString() && result < 29.9.toString()) {
                wynik.setTextColor("#FFBC2B".toColorInt())
            }
            if (result >= 30.0.toString() && result < 34.9.toString()) {
                wynik.setTextColor("#E84E27".toColorInt())
            }
            if (result > 35.0.toString()) {
                wynik.setTextColor("#FF0000".toColorInt())
            }
        }

    }
}