package com.example.canvas_practices

import android.content.Context
import android.view.View
import android.widget.ImageButton
import com.example.canvas_practices.GameEngine.BOT_OPTIMALMOVE
import com.example.canvas_practices.GameEngine.engine_checkend
import com.example.canvas_practices.graphics.CustomView
import com.example.canvas_practices.pieces.Pieces_moves

class businesslogic(context: Context) {
    // Gobal Variables
    private var player  = Pieces_moves(1 , 1)
    private var bot = Pieces_moves(8, 8)
    private var optimalmove_bot = Pieces_moves(0,0)
    private val  BOT_OPTIMALMOVE = BOT_OPTIMALMOVE()

    fun  changepositions(PLAYER_ADDTOROW: Int, PLAYER_ADDTOCOL: Int , BoardView : CustomView , button: ImageButton, is_Rmove: Boolean) {
        // step 1
        // move player
        player.row += PLAYER_ADDTOROW
        player.col += PLAYER_ADDTOCOL

        // step 2
        // check for  GAME END!
        val  check_gameend  = engine_checkend()
        //TODO("correct the logic of below line ")
        // val winner = check_gameend.check_gameend(player, bot,)
        //if(winner !=0){
            //TODO("implement alert box")
        //}
        // Button visibility setter function
        check_buttonvisibilty(player , button, is_Rmove)

        // step 3
        // Find optimal move
      //  optimalmove_bot = BOT_OPTIMALMOVE.find(player, bot)
      //  bot = optimalmove_bot
            bot = fake_botmove(bot)

        // step 4
        // Update UI
        BoardView.updateboard(player, bot)
        BoardView.invalidate()
    }

    private fun fake_botmove(bot: Pieces_moves): Pieces_moves {

        lateinit var fakemove : Pieces_moves
        if(bot.col ==1 && bot.row==1) {
            fakemove =  Pieces_moves(bot.row,bot.col)
        }
        else{
                fakemove = Pieces_moves(bot.row-1,bot.col-1)
        }
        return fakemove
    }

    // Disables Button if necessary
    private fun check_buttonvisibilty(player: Pieces_moves , button: ImageButton , is_Rmove: Boolean) {
                if(player.col== 8 && is_Rmove){
                      button.visibility = View.INVISIBLE
                      button.invalidate()
                }
                if(player.row==8 && !is_Rmove){
                    button.visibility = View.INVISIBLE
                    button.invalidate()
                }
    }
}