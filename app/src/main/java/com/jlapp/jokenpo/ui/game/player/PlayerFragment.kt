package com.jlapp.jokenpo.ui.game.player


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import com.jlapp.jokenpo.R
import kotlinx.android.synthetic.main.fragment_player.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PlayerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGoToGame.setOnClickListener {
            sendPlayerName()
        }
    }

    private fun sendPlayerName() {
        val intent = Intent("FILTER_PLAYER_NAME")
        intent.putExtra("player_name", etPlayerName.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

}
