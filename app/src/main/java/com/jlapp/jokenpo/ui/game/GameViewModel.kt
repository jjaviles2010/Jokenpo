package com.jlapp.jokenpo.ui.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jlapp.jokenpo.R
import java.util.*

class GameViewModel : ViewModel() {
    val playerName = MutableLiveData<String>()
    val victoryNumbers = MutableLiveData<Int>()
    val defeatNumbers = MutableLiveData<Int>()
    val playerImage = MutableLiveData<Int>()
    val androidImage = MutableLiveData<Int>()
    val roundState = MutableLiveData<String>()

    init {
        playerName.value = ""
        victoryNumbers.value = 0
        defeatNumbers.value = 0
    }

    fun generateAndroidSelection() {
        val randomNumber = (0..2).random()
        setAndroidSelectedImage(randomNumber)
    }

    private fun setAndroidSelectedImage(randomNumber: Int) {
        androidImage.value = getImageResourceId(randomNumber)
    }

    fun setPlayerSelectedImage(idImage: Int) {
        playerImage.value = getImageResourceId(idImage)
    }

    fun getImageResourceId(idImage: Int): Int {
        return when (idImage) {
            0 -> R.drawable.papel
            1 -> R.drawable.pedra
            2 -> R.drawable.tesoura
            else -> 0
        }
    }

    fun calculateResult() {
        calculateVictory()
        calculateDefeats()
    }

    private fun calculateVictory() {
        if ((playerImage.value == R.drawable.papel && androidImage.value == R.drawable.pedra) ||
            (playerImage.value == R.drawable.pedra && androidImage.value == R.drawable.tesoura) ||
            (playerImage.value == R.drawable.tesoura && androidImage.value == R.drawable.papel)
        ) {
            victoryNumbers.value = victoryNumbers.value?.plus(1)
            setRoundState("Você ganhou essa!")
        }
    }

    private fun calculateDefeats() {
        if ((androidImage.value == R.drawable.papel && playerImage.value == R.drawable.pedra) ||
            (androidImage.value == R.drawable.pedra && playerImage.value == R.drawable.tesoura) ||
            (androidImage.value == R.drawable.tesoura && playerImage.value == R.drawable.papel)
        ) {
            defeatNumbers.value = defeatNumbers.value?.plus(1)
            setRoundState("Você perdeu essa!")
        }
    }

    private fun setRoundState(state: String) {
        roundState.value = state
    }

    fun checkFinalStatus(): String {
        return when {
            victoryNumbers.value == 2 -> "win"
            defeatNumbers.value == 2 -> "lose"
            else -> ""
        }
    }
}