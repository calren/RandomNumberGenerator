package com.example.android.randomnumbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            val generatedNumber = getRandomNumber(1,6)
            findViewById<TextView>(R.id.textView).text = generatedNumber.toString()
        }
    }

    // Generates a random number from lowerBound to upperBound, inclusive of both provided bounds
    // IE : getRandomNumber(1, 5) can return 1, 2, 3, 4 or 5
    private fun getRandomNumber(lowerBound: Int, upperBound: Int) : Int {
        return (lowerBound..upperBound).random()
    }
}
