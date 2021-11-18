package br.com.jm.evolution

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val continueButton by lazy { findViewById<Button>(R.id.welcome_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        continueButton.setOnClickListener {
            startActivity(Intent(this, ChooseCategory::class.java))
        }
    }
}