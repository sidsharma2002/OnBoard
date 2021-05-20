package com.example.canvas_practices.GameEngine

import com.example.canvas_practices.pieces.Pieces_moves

class BOT_OPTIMALMOVE{
        //Global Variables
        private  lateinit var player: Pieces_moves
        private lateinit var bot : Pieces_moves
        private  var bot_optimalmove = Pieces_moves(0,0)

        //Find function is directly called
        fun  find(player : Pieces_moves , bot : Pieces_moves) :Pieces_moves {
           // TODO("Design minimax algorithm and change return Data")
            this.player = player
            this.bot = bot
            return bot_optimalmove
        }
}