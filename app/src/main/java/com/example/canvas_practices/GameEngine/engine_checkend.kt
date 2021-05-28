package com.example.canvas_practices.GameEngine

import com.example.canvas_practices.pieces.Pieces_moves
import kotlin.math.abs

 class engine_checkend {

    fun check_gameend(player: Pieces_moves, bot: Pieces_moves, isbot: Int)  : Int {
        if(player.row==8 && player.col==8) return 1
        if(player.row>8 || player.col>8) return -1

        if(bot.row==player.row && player.col+1==bot.col) return -1
        if(bot.col==player.col && player.row+1==bot.row) return -1
        if(bot.row<1 || bot.col<1) return 1

        if(player.col==bot.col && bot.row-player.row>1 && player.col!=8){
            if(isbot==1) return -1
            return 1
        }

        if(player.row==bot.row && bot.col-player.col>1 && player.row!=8 && isbot==0){
            if(isbot==1) return -1
            return 1
        }
        return 0;

    }
}