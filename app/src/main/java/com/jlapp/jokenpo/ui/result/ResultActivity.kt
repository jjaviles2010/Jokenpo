package com.jlapp.jokenpo.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jlapp.jokenpo.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getStringExtra("game_result")

        if (result == "win") {
            animation_view.setAnimation("win_anim.json")
            tvResult.text = "Você ganhou!"
        } else {
            animation_view.setAnimation("lose_anim.json")
            tvResult.text = "Você perdeu!"
        }

    }
}
