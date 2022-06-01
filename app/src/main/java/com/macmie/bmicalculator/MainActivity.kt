package com.macmie.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // mapping
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)


        // set on-click listener
        calculateButton.setOnClickListener {

            // check whether inputs is empty
            if (heightEditText.text.isNotEmpty() && weightEditText.text.isNotEmpty()) {
                val height = heightEditText.text.toString().toDouble() / 100
                val weight = weightEditText.text.toString().toDouble()

                // check the validity of inputs
                if (weight > 5 && weight < 300 && height >= 0.5 && height < 3) {
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                    intent.putExtra("bmi", calculateBMI(weight, height))
                    startActivity(intent)
                } else {
                    showError("Incorrect Values")
                }
            } else {
                showError("Missing Variables!")
            }

        }
    }

    // function to calculate value BMI
    private fun calculateBMI(weight: Double, height: Double) =
        BigDecimal(weight / (height * height))
            .setScale(2, RoundingMode.HALF_EVEN).toDouble()

    // function to show errors
    private fun showError(errorMessage: String) {
        val snackbar = Snackbar.make(
            findViewById(R.id.container),
            "error: $errorMessage",
            Snackbar.LENGTH_LONG
        )
        snackbar.show()
    }
}