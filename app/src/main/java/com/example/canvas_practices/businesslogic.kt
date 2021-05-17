package com.example.canvas_practices

import android.content.Context
import com.example.canvas_practices.graphics.CustomView
import com.example.canvas_practices.pieces.Pieces_moves

class businesslogic(context: Context) {

    private val start_coordiante  : Int = R.integer.start_coordinate
    private val end_coordinate  : Int = R.integer.end_coordinate

    private var player  = Pieces_moves(1 , 1)
    private var bot = Pieces_moves(8, 8)
    private var optimalmove_bot = Pieces_moves(0,0)




    fun  changepositions(PLAYER_ADDTOROW: Int, PLAYER_ADDTOCOL: Int , BoardView : CustomView) {
        // move player
        player.row += 1
        //player.col += PLAYER_ADDTOCOL

        // check for  GAME END!
        //TODO("ADD GAME END FUNCTION")

        optimalmove_bot = optimalmovebot_function(player , bot)
        bot = optimalmove_bot

        //update UI
        BoardView.updateboard(player, bot)
        BoardView.invalidate()
    }

        private fun optimalmovebot_function( player : Pieces_moves, bot : Pieces_moves) : Pieces_moves{
        //TODO("IMPLEMENT MINIMAX ALGORITHM")
             return Pieces_moves(bot.row-1 , bot.col)
        }


}