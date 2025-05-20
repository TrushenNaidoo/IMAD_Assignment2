package vcmsa.ci.imad_assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question_Activity : AppCompatActivity() {
    //array declaration
    val questions = arrayOf(
        "Gunpowder was invented in China",
        "The Nazis invaded Greece during WWII",
        "China fought in WWII",
        "Ireland was colonized by the ancient Romans",
        "Most scholars now believe that Shakespeare did not write most of the plays that bear his name"
    )

    //an array to store the questions answers
    val answers = booleanArrayOf(true, true, true, false, false)

    //initialized declared variables
    var score = 0
    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.questions)


    //declarations for the Textviews and Buttons
    val questionText = findViewById<TextView>(R.id.displayQuestion)
    val feedbackText = findViewById<TextView>(R.id.feedback)
    val trueBtn = findViewById<Button>(R.id.trueButton)
    val falseBtn = findViewById<Button>(R.id.falseButton)
    val nextBtn = findViewById<Button>(R.id.next)

    //updateQuestion() updates the UI to show the current question and  resets the feedback and buttons for the next interaction
    fun updateQuestion() {
        questionText.text = questions[currentIndex]//sets text of UI element
        feedbackText.text = ""//clears  feedback texts
        trueBtn.isEnabled = true//enables the button
        falseBtn.isEnabled = true//enables the button
    }

    //updates UI
    updateQuestion()

    //when the true button is clicked it will determine if the answer is true
    trueBtn.setOnClickListener {
        checkAnswer(true)
    }
      //when the false button is clicked it will determine if the answer is false
    falseBtn.setOnClickListener {
        checkAnswer(false)
    }

    //this button will prompt the next question
    nextBtn.setOnClickListener {
        currentIndex++
        if (currentIndex < questions.size) {
            updateQuestion()
        } else {
            val intent = Intent(this, ScoreScreen::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        }
    }
}

fun checkAnswer(userAnswer: Boolean) {
    val correctAnswer = answers[currentIndex]
    if (userAnswer == correctAnswer) {
        score++
    }

    val feedbackText = findViewById<TextView>(R.id.feedback)
    if (userAnswer == correctAnswer) {
        feedbackText.text = "Correct!"
    } else {
        feedbackText.text = "Incorrect!"
    }

    // Disable the buttons after selection
    findViewById<Button>(R.id.trueButton).isEnabled = false
    findViewById<Button>(R.id.falseButton).isEnabled = false
}
}

//title: Kotlin Arrays
//Author: W3Schools
//Date: 16 May 2025
//version: 1.0
//Available at:https://www.w3schools.com/kotlin/kotlin_arrays.php

//title: Kotlin Booleans
//Author: W3Schools
//Date: 16 May 2025
//version: 1.0
//Available at:https://www.w3schools.com/kotlin/kotlin_booleans.php