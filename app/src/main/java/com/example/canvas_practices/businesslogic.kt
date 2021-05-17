package com.example.canvas_practices

import android.content.Context
import com.example.canvas_practices.graphics.CustomView
import com.example.canvas_practices.pieces.Pieces_moves

class businesslogic(context: Context) {

    private var player  = Pieces_moves(1,1)
    private var bot = Pieces_moves(7,7)
    private var optimalmove_bot = Pieces_moves(0,0)
    //private var boardview = CustomView(context)

    init {
       // boardview.updateboard(player, bot)
      //  boardview.invalidate()
    }

    fun  changepositions(PLAYER_ADDTOROW: Int, PLAYER_ADDTOCOL: Int) {
        // move player
        player.row += PLAYER_ADDTOROW
        player.col += PLAYER_ADDTOCOL
        // check for  GAME END!
        //TODO("ADD GAME END FUNCTION")

        optimalmove_bot = optimalmovebot_function(player , bot)
        bot = optimalmove_bot

        //update UI
        //boardview.updateboard(player, bot)
        //boardview.invalidate()

    }

        private fun optimalmovebot_function( player : Pieces_moves, bot : Pieces_moves) : Pieces_moves{
        //TODO("IMPLEMENT MINIMAX ALGORITHM")
             return Pieces_moves(bot.row-1 , bot.col)
        }


}