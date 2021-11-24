package br.com.jm.evolution

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ChooseCategory: AppCompatActivity() {
    private val componentButton: ImageButton by lazy {
        findViewById(R.id.component_category_button)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_category)

        componentButton.setOnClickListener {
            startActivity(Intent(this, ModulesListActivity::class.java))
        }
    }
}