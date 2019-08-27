package com.jlapp.jokenpo.ui.player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jlapp.jokenpo.R
import com.jlapp.jokenpo.ui.game.GameActivity
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        btnGoToGame.setOnClickListener {
            navigateToGame()
        }
    }

    private fun navigateToGame() {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("player_name", etPlayerName.text.toString())
        startActivity(intent)
    }
}
