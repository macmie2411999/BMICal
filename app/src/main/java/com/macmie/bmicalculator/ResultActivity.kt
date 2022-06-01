package com.macmie.bmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // mapping
        val bmiFlagImageView = findViewById<ImageView>(R.id.bmiFlagImageView)
        val bmiLabelTextView = findViewById<TextView>(R.id.bmiLabelTextView)
        val bmiValueTextView = findViewById<TextView>(R.id.bmiValueTextView)
        val commentTextView = findViewById<TextView>(R.id.commentTextView)

        val firstAdviceImageView = findViewById<ImageView>(R.id.firstAdviceImageView)
        val firstAdviceTextView = findViewById<TextView>(R.id.firstAdviceTextView)

        val secondAdviceImageView = findViewById<ImageView>(R.id.secondAdviceImageView)
        val secondAdviceTextView = findViewById<TextView>(R.id.secondAdviceTextView)

        val thirdAdviceImageView = findViewById<ImageView>(R.id.thirdAdviceImageView)
        val thirdAdviceTextView = findViewById<TextView>(R.id.thirdAdviceTextView)

        val containerR = findViewById<LinearLayout>(R.id.containerR)

        // get intent
        val bmiValue = intent.getDoubleExtra("bmi", -1.0)

        // check value
        if (bmiValue == -1.0) {

            // hide layout
            containerR.visibility = View.GONE
        } else {
            bmiValueTextView.text = bmiValue.toString()
            if (bmiValue < 18.5) {

                // assign appropriate values
                containerR.setBackgroundResource(R.drawable.yellow_dg)
                bmiFlagImageView.setImageResource(R.drawable.warning)
                bmiLabelTextView.text = "You Are Underweight!"
                commentTextView.text = "Here Are Some Advices To Gain Weight"

                firstAdviceImageView.setImageResource(R.drawable.nowater)
                firstAdviceTextView.text = "Do Not Drink Water Before Meals"

                secondAdviceImageView.setImageResource(R.drawable.bigmeal)
                secondAdviceTextView.text = "Have Nutritious Meals"

                thirdAdviceImageView.setImageResource(R.drawable.sleep)
                thirdAdviceTextView.text = "Sleep On Time"

            } else {
                if (bmiValue > 25) {

                    // assign appropriate values
                    containerR.setBackgroundResource(R.drawable.red_dg)
                    bmiFlagImageView.setImageResource(R.drawable.exclamation_mark2)
                    bmiLabelTextView.text = "You Are Overweight!"
                    commentTextView.text = "Here Are Some Advices To Loose Weight"

                    firstAdviceImageView.setImageResource(R.drawable.water)
                    firstAdviceTextView.text = "Drink Water Before Meals"

                    secondAdviceImageView.setImageResource(R.drawable.twoeggs)
                    secondAdviceTextView.text = "Control Daily Calories"

                    thirdAdviceImageView.setImageResource(R.drawable.nosugar)
                    thirdAdviceTextView.text = "No Refined Sugar"
                }
            }

        }

    }
}