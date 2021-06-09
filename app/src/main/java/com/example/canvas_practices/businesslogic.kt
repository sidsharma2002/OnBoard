package com.example.canvas_practices

import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.canvas_practices.GameEngine.BOT_OPTIMALMOVE
import com.example.canvas_practices.GameEngine.engine_checkend
import com.example.canvas_practices.cache.Values
import com.example.canvas_practices.graphics.CustomView
import com.example.canvas_practices.pieces.Pieces_moves



class businesslogic(context: Context) {
    // Gobal Variables
    private var player  = Pieces_moves(1 , 1)
    private var bot = Pieces_moves(8, 8)
    private var optimalmove_bot = Pieces_moves(0,0)
    private val  BOT_OPTIMALMOVE = BOT_OPTIMALMOVE()
    private val context = context


    fun  changepositions(  PLAYER_ADDTOROW: Int, PLAYER_ADDTOCOL: Int,
                                                BoardView: CustomView, scrollView: LinearLayout, button: ImageButton,
                                                is_Rmove: Boolean,
                                                values : Values,
                                                Textview_playerscore : TextView,
                                                 Textview_botscore : TextView,
                                                ) {
        // step 1
        // move player
        player.row += PLAYER_ADDTOROW
        player.col += PLAYER_ADDTOCOL
        // update score
        values.add_score(values.arr[player.row][player.col],0)

        // step 2
        // check for  GAME END!
        val  check_gameend  = engine_checkend()
        val winner = check_gameend.check_gameend1(player, bot)
          if(winner !=0){
                        // someone won
        }
        // Button visibility setter function
        check_buttonvisibilty(player , button, is_Rmove)

        // step 3
        // Find optimal move
          optimalmove_bot = BOT_OPTIMALMOVE.find(player, bot)
          bot = optimalmove_bot
          values.add_score(0, values.arr[bot.row][bot.col])

        // step 4
        // Update UI
        BoardView.updateboard(player, bot)
        BoardView.invalidate()
        Textview_playerscore.text = values.score_player.toString()
        Textview_playerscore.invalidate()
        Textview_botscore.text = values.score_bot.toString()
        Textview_botscore.invalidate()
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