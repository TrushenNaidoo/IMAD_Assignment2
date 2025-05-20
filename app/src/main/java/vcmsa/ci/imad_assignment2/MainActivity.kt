package vcmsa.ci.imad_assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //The button to start then game
        val startButton = findViewById<Button>(R.id.start)

        //setOnClickListener is to link the click of the button to its desired function
        startButton.setOnClickListener {
            val intent = Intent(this, Question_Activity::class.java)//links the two activities
            startActivity(intent)
            finish()
        }
    }
}

//title: Kotlin Variables
//Author: W3Schools
//Date: 16 May 2025
//version: 1.0
//Available at:https://www.w3schools.com/kotlin/kotlin_variables.php