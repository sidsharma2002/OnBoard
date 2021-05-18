package com.example.canvas_practices

import android.content.Context
import android.view.View
import android.widget.Button
import com.example.canvas_practices.GameEngine.engine_checkend
import com.example.canvas_practices.graphics.CustomView
import com.example.canvas_practices.pieces.Pieces_moves

class businesslogic(context: Context) {

    private val start_coordiante  : Int = R.integer.start_coordinate
    private val end_coordinate  : Int = R.integer.end_coordinate

    private var player  = Pieces_moves(1 , 1)
    private var bot = Pieces_moves(8, 8)
    private var optimalmove_bot = Pieces_moves(0,0)


    fun  changepositions(PLAYER_ADDTOROW: Int, PLAYER_ADDTOCOL: Int , BoardView : CustomView , buttonR: View) {
        // move player
        player.row += PLAYER_ADDTOROW
        //player.col += PLAYER_ADDTOCOL

        // check for  GAME END!
        //TODO("ADD GAME END FUNCTION")
        val  check_gameend  = engine_checkend()
        val winner = check_gameend.check_gamend(player, bot)
        if(winner !=0){
            //TODO("implement alert box")
        }


        //button visibility setter function
        check_buttonvisibilty(player , buttonR)
        //TODO("IMPLEMENT  BUTTON VISIBILITY FUNCTION")


        optimalmove_bot = optimalmovebot_function(player , bot)
        bot = optimalmove_bot

        //update UI
        BoardView.updateboard(player, bot)
        BoardView.invalidate()
    }

    private fun check_buttonvisibilty(player: Pieces_moves , buttonR: View) {
                if(player.row == end_coordinate){
                        //buttonR.visibility = Button.INVISIBLE
                }
    }

    private fun optimalmovebot_function( player : Pieces_moves, bot : Pieces_moves) : Pieces_moves{
        //TODO("IMPLEMENT MINIMAX ALGORITHM")
             return Pieces_moves(bot.row-1 , bot.col)
        }


}