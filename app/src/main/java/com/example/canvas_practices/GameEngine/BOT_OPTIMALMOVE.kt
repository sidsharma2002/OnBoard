package com.example.canvas_practices.GameEngine

import android.R.bool
import com.example.canvas_practices.pieces.Pieces_moves


class BOT_OPTIMALMOVE{
        //Global Variables
        private  lateinit var player: Pieces_moves
        private lateinit var bot : Pieces_moves
        private  var bot_optimalmove = Pieces_moves(0,0)
        private var engine = engine_checkend()

        //Find function is directly called
        fun  find(player : Pieces_moves , bot : Pieces_moves) :Pieces_moves {
           // TODO("Design minimax algorithm and change return Data")
            this.player = player
            this.bot = bot
            bot_optimalmove = optimalmove(player,bot)
            return bot_optimalmove
        }

        private fun optimalmove(player: Pieces_moves, bot: Pieces_moves): Pieces_moves {

            val bestmove_row: Boolean = minimax(player, Pieces_moves(bot.row - 1, bot.col), 0)
            if (bestmove_row) return Pieces_moves(bot.row - 1, bot.col)

            val bestmove_col: Boolean = minimax(player, Pieces_moves(bot.row, bot.col - 1), 0)
            return if (bestmove_col) Pieces_moves(bot.row, bot.col - 1) else bot
            return bot
        }

        private fun minimax(player: Pieces_moves, bot: Pieces_moves , isbot : Int) : Boolean {
            //player won and bot cannot win from this position
            if(engine.check_gameend(player,bot,isbot)== 1) return false
            //player lost and bot can win from this position
            if(engine.check_gameend(player,bot,isbot)== -1) return true

            if(isbot==1){
                // if bot can win by moving up or right
                if(minimax(player, Pieces_moves(bot.row,bot.col-1),0) ||
                    minimax(player, Pieces_moves(bot.row-1,bot.col),0)) return true
                return false
            }
            else{
                // if player can win by moving down or left
                if(!minimax(Pieces_moves(player.row,player.col+1),bot,1) ||
                    !minimax(Pieces_moves(player.row+1,player.col),bot,1)) return false
                return true;
            }
    }
}