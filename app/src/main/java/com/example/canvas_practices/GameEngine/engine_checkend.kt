package com.example.canvas_practices.GameEngine

import com.example.canvas_practices.pieces.Pieces_moves
import kotlin.math.abs

 class engine_checkend {

    fun check_gamend( player : Pieces_moves , bot : Pieces_moves ) : Int{
        // TODO("modify for column also")
        if (player.row+1==bot.row) {
                            return 0
        }
        return -1
        }


}