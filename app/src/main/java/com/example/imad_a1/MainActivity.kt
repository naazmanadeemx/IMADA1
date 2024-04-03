// Author: Naazma Iqbal
// Date: 28/03/2024

package com.example.imad_a1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.util.Log

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity" // tag for logging
    }

    // declaring UI elements
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText
    private lateinit var clearButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing UI elements
        searchButton = findViewById(R.id.searchButton)
        resultTextView = findViewById(R.id.resultTextView)
        ageInput = findViewById(R.id.ageInput)
        clearButton = findViewById(R.id.clearButton)

        // search button click listener
        searchButton.setOnClickListener {
            // get age input from EditText and trim leading/trailing whitespace
            val ageText = ageInput.text.toString().trim()
            Log.d(TAG, "User entered age: $ageText") // logging user input

            // check if age input is empty
            if (ageText.isEmpty()) {
                resultTextView.text = getString(R.string.empty_age_input)
                Log.w(TAG, "Empty age input") // logging empty age input
                return@setOnClickListener
            }

            // check if age input contains non-digit characters
            if (!ageText.all { it.isDigit() }) {
                resultTextView.text = getString(R.string.invalid_age_input)
                Log.w(TAG, "Invalid age input: $ageText") // logging invalid age input
                return@setOnClickListener
            }

            // convert age input to integer
            val age = ageText.toInt()

            // check if age is within valid range

            if (age !in 20..100) {
                resultTextView.text = getString(R.string.age_out_of_range)
                Log.w(TAG, "Age out of range: $age") // logging age out of range

                return@setOnClickListener
            }

            // determine historical figure based on age
            val historicalFigureName = when (age) {
                31 -> "Steve Biko"
                36 -> "Diana, Princess of Wales"
                38 -> "John F. Kennedy Jr"
                37 -> "Van Gogh"
                39 -> "Malcolm X"
                //39 -> "Martin Luther King Jr"
                51 -> "Michael Jackson"
                52 -> "William Shakespeare"
                56 -> "Adolf Hitler"
                63 -> "Prophet Muhammad ﷺ"
                66 -> "Marie Curie"
                67 -> "Leonardo da Vinci"
                69 -> "Faisal of Saudi Arabia"
                74 -> "Muhammad Ali"
                76 -> "Albert Einstein"
                77 -> "Frederick Douglass"
                //82 -> "Pelé"
                82 -> "Neil Armstrong"
                84 -> "Isaac Newton"
                90 -> "Desmond Tutu"
                //90 -> "Winston Churchill"
                95 -> "Nelson Mandela"
                96 -> "Queen Elizabeth II"
                else -> null
            }

            // construct result message based on historical figure
            val message = if (historicalFigureName != null)  "You are $age years old, which is the same age as $historicalFigureName. $historicalFigureName was a famous historical figure."
            else "Oops! No historical figures found with the entered age. Keep exploring!"
            // display result message
            resultTextView.text = message
            Log.i(TAG, "Result message: $message") // logging result message
        }

        // clear button click listener
        clearButton.setOnClickListener {
            // clear age input and result text
            ageInput.text.clear()
            resultTextView.text = ""
        }
    }
}

