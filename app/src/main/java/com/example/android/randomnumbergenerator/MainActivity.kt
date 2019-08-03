package com.example.android.randomnumbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var lowerBoundEditText: EditText
    private lateinit var upperBoundEdiText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lowerBoundEditText = findViewById(R.id.lowerBound)
        upperBoundEdiText = findViewById(R.id.upperBound)

        findViewById<Button>(R.id.button).setOnClickListener {
            lowerBoundEditText.clearFocus()
            upperBoundEdiText.clearFocus()

            val lowerBound = lowerBoundEditText.text?.toString()
            val upperBound = upperBoundEdiText.text?.toString()

            if (TextUtils.isEmpty(lowerBound) || TextUtils.isEmpty(upperBound)) {
                Toast.makeText(this, "Must enter lower and upper bounds!", Toast.LENGTH_SHORT).show()
            } else {
                val handler = Handler()
                handler.post(object : Runnable {
                    private var timesRun = 0

                    override fun run() {
                        val generatedNumber =
                                getRandomNumber(lowerBound!!.toInt(), upperBound!!.toInt())
                        Log.i("Caren", "generated number: $generatedNumber")
                        findViewById<TextView>(R.id.textView).text = generatedNumber.toString()

                        timesRun++
                        if (timesRun <= 10) {
                            handler.postDelayed(this, 100)
                        }
                    }
                })
            }
        }
    }

    // Generates a random number from lowerBound to upperBound, inclusive of both provided bounds
    // IE : getRandomNumber(1, 5) can return 1, 2, 3, 4 or 5
    private fun getRandomNumber(lowerBound: Int, upperBound: Int): Int {
        return (lowerBound..upperBound).random()
    }
}
