package vcmsa.ci.imad_assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        val questions = arrayOf(
            "Gunpowder was invented in China",
            "The Nazis invaded Greece during WWII",
            "China fought in WWII",
            "Ireland was colonized by the ancient Romans",
            "Most scholars now believe that Shakespeare did not write most of the plays that bear his name"
        )

        val answers = booleanArrayOf(true, true, true, false, false)

        val score = intent.getIntExtra("score", 0)

        val scoreTextView = findViewById<TextView>(R.id.score)
        val feedbackTextView = findViewById<TextView>(R.id.feedback)
        val reviewTextView = findViewById<TextView>(R.id.review)
        val reviewButton = findViewById<Button>(R.id.reviewQuiz)
        val exitButton = findViewById<Button>(R.id.exitQuiz)

        scoreTextView.text = "Your score: $score / 5"

        feedbackTextView.text = when (score) {
            in 3..5 -> "Great job!"
            in 1..2 -> "Keep practicing!"
            else -> "Ahh mahn"
        }

        reviewButton.setOnClickListener {
            val builder = StringBuilder()
            for (i in questions.indices) {
                builder.append("Q${i + 1}: ${questions[i]}\n")
                builder.append("Correct Answer: ${answers[i]}\n\n")
            }
            reviewTextView.text = builder.toString()
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}
//title: Kotlin Break and Continue
//Author: W3Schools
//Date: 16 May 2025
//version: 1.0
//Available at:https://www.w3schools.com/kotlin/kotlin_break.php

//title: Kotlin Booleans
//Author: W3Schools
//Date: 16 May 2025
//version: 1.0
//Available at:https://www.w3schools.com/kotlin/kotlin_booleans.php