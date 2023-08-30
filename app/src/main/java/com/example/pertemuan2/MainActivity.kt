package com.example.pertemuan2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pertemuan2.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            binding.btnCount.setOnClickListener {
                val weightString = binding.weight.text.toString()
                val heightString = binding.height.text.toString()

                val weightcal = weightString.toFloatOrNull()
                val heightcal = heightString.toFloatOrNull()

                if (weightcal != null && heightcal != null && heightcal != 0f) {
                    // Melakukan perhitungan BMI
                    val bmi = weightcal / (heightcal * heightcal)

                    // Mengatur jumlah digit di belakang koma menjadi 1
                    val bmiWithOneDecimal = BigDecimal(bmi.toString()).setScale(1, RoundingMode.HALF_UP)

                    textNumber.text = bmiWithOneDecimal.toString()
                } else {
                    // Handle ketika input tidak valid
                    Toast.makeText(
                        this@MainActivity,
                        "Masukkan berat dan tinggi yang valid (tinggi tidak boleh nol)",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            btnToast.setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Count ${textNumber.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

}
