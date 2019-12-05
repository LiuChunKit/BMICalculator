package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val inputWeight = findViewById<EditText>(R.id.editTextWeight)
        val inputHeight = findViewById<EditText>(R.id.editTextHeight)

        buttonCalculate.setOnClickListener() {
            var bmi = 0.0
            val decimalPointBmi = DecimalFormat("##.##")
            imageViewProfile.setImageResource(R.drawable.empty)

            val weight = editTextWeight.text.toString()
            val height = editTextHeight.text.toString()

            if (inputWeight.text.isEmpty() && inputHeight.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Please enter the details to calculate.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                bmi = weight.toDouble() / ((height.toDouble() / 100) * (height.toDouble() / 100))
                when (bmi) {
                    in 0..18.5.toInt() -> {
                        textViewBMI.setText("BMI: " + decimalPointBmi.format(bmi))
                        bmiCondition.setText("Underweight")
                        imageViewProfile.setImageResource(R.drawable.under)
                    }
                    in 18.6..24.9 -> {
                        textViewBMI.setText("BMI: " + decimalPointBmi.format(bmi))
                        bmiCondition.setText("Normal")
                        imageViewProfile.setImageResource(R.drawable.normal)
                    }
                    else -> {
                        textViewBMI.setText("BMI: " + decimalPointBmi.format(bmi))
                        bmiCondition.setText("Overweight")
                        imageViewProfile.setImageResource(R.drawable.over)
                    }
                }
            }
        }

        buttonReset.setOnClickListener() {
            inputWeight.setText("")
            inputHeight.setText("")

            textViewBMI.setText("BMI : ")
            bmiCondition.setText("")
            imageViewProfile.setImageResource(R.drawable.empty)
        }
    }
}
