package com.example.lab_03_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_03_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val outputText = binding.OUTPUT
        val input1Button = binding.INPUT1
        val input2Button = binding.INPUT2
        val bramkaText = binding.BRAMKA
        val bramkaImage = binding.ZDJECIE

        var i = 0
        var input1 = "0"
        var input2 = "0"
        val gateList = listOf("AND", "NAND", "OR", "NOR", "XOR", "XNOR")
        val drawList = listOf("and", "nand", "or", "nor", "xor", "xnor")

        fun calculateOutput() {
            val a = input1 == "1"
            val b = input2 == "1"

            val result = when (gateList[i]) {
                "AND"  -> a && b
                "NAND" -> !(a && b)
                "OR"   -> a || b
                "NOR"  -> !(a || b)
                "XOR"  -> a xor b
                "XNOR" -> !(a xor b)
                else   -> false
            }

            outputText.text = if (result) "1" else "0"
        }



        bramkaText.text = gateList[i]
        input1Button.text = input1
        input2Button.text = input2
        calculateOutput()

        bramkaText.setOnClickListener {
            i = (i + 1) % gateList.size

            val curr = i % gateList.size

            if (curr == 0) {
                bramkaImage.setBackgroundResource(R.drawable.and);
            }
            else if (curr == 1) {
                bramkaImage.setBackgroundResource(R.drawable.nand);
            }
            else if (curr == 2) {
                bramkaImage.setBackgroundResource(R.drawable.or);
            }
            else if (curr == 3) {
                bramkaImage.setBackgroundResource(R.drawable.nor);
            }
            else if (curr == 4) {
                bramkaImage.setBackgroundResource(R.drawable.xor);
            }
            else if (curr == 5) {
                bramkaImage.setBackgroundResource(R.drawable.xnor);
            }

            bramkaText.text = gateList[i]
            calculateOutput()
        }

        input1Button.setOnClickListener {
            input1 = if (input1 == "0") "1" else "0"
            input1Button.text = input1
            calculateOutput()
        }

        input2Button.setOnClickListener {
            input2 = if (input2 == "0") "1" else "0"
            input2Button.text = input2
            calculateOutput()
        }
    }
}