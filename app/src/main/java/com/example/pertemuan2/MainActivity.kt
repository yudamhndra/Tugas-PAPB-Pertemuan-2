package com.example.pertemuan2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.EditText
import android.widget.Toast
import com.example.pertemuan2.databinding.ActivityMainBinding
import java.math.BigDecimal


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

                val weightcal = BigDecimal(weightString)
                val heightcal = BigDecimal(heightString)

                val bmi = weightcal/(heightcal*heightcal)
                textNumber.text = bmi.toString()
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
