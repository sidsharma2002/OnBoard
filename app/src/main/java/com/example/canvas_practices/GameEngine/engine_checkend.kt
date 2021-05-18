package com.example.canvas_practices.GameEngine

import com.example.canvas_practices.pieces.Pieces_moves
import kotlin.math.abs

public class engine_checkend {

    public fun check_gamend( player : Pieces_moves , bot : Pieces_moves ) : Int{
                    if (player.row+1==bot.row) {
                            return 0;
                    }
                    return -1;
        }


}