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
        androidImage.value = when(randomNumber) {
            0 -> R.drawable.papel
            1 -> R.drawable.pedra
            2 -> R.drawable.tesoura
            else -> 0
        }
    }

    fun setPlayerSelectedImage(idImage: Int) {
        playerImage.value = idImage
    }

    fun calculateResult() {
        calculateVictory()
        calculateDefeats()
    }

    private fun calculateVictory() {
        victoryNumbers.value?.plus(when {
            playerImage.value == 0 && androidImage.value == 1 -> 1
            playerImage.value == 1 && androidImage.value == 2 -> 1
            playerImage.value == 2 && androidImage.value == 0 -> 1
            else -> 0
        })

        setRoundState("Você ganhou essa!")
    }

    private fun calculateDefeats() {
        defeatNumbers.value?.plus(when {
            playerImage.value == 0 && androidImage.value == 2 -> 1
            playerImage.value == 1 && androidImage.value == 0 -> 1
            playerImage.value == 2 && androidImage.value == 1 -> 1
            else -> 0
        })

        setRoundState("Você perdeu essa!")
    }

    private fun setRoundState(state: String) {
        roundState.value = state
    }

    fun checkFinalStatus() : String {
        return when {
            victoryNumbers.value == 2 -> "win"
            defeatNumbers.value == 2 -> "lose"
            else -> ""
        }
    }
}