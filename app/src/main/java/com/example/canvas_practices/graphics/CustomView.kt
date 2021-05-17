package com.example.canvas_practices.graphics

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.canvas_practices.R
import com.example.canvas_practices.pieces.Pieces_moves
import  com.example.canvas_practices.businesslogic

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
)
    : View(context, attrs, defStyleAttr) {

    private var player_Paint  = Paint()
    private var bot_Paint = Paint()
    private var whitespace_Paint = Paint()
    private  var player  = Pieces_moves(1,1)
    private   var bot = Pieces_moves(8,8)
    private val start_coordinate  : Int = R.integer.start_coordinate
    private val end_coordinate  : Int = R.integer.end_coordinate

    init {
        player_Paint.setColor(Color.CYAN)
        player_Paint.strokeWidth = 15F

        bot_Paint.setColor(Color.MAGENTA)
        bot_Paint.strokeWidth = 15F

        whitespace_Paint.setColor(Color.WHITE)
        whitespace_Paint.strokeWidth = 15F
    }

    fun updateboard( player : Pieces_moves , bot : Pieces_moves ) {
            this.player = player
            this.bot = bot
            //TODO(" In test feature")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // Draw all the pieces and whitespace
        drawBoard(canvas)
        drawpieces(canvas)
    }

    private fun drawpieces(canvas: Canvas?) {
           canvas?.drawRect((100*player.row).toFloat() + 25F , 100F , (100*(player.row+1)).toFloat() + 25F, 200F , player_Paint   )
           canvas?.drawRect((100*bot.row).toFloat() + 25F , 100F , (100*(bot.row+1)).toFloat() + 25F, 200F , bot_Paint   )
    }

    private fun drawBoard(canvas: Canvas?) {
        // for row
        for( i in 1..8) {
            // for col
            //for( j in 1..8 ){
            canvas?.drawRect((100*i).toFloat() + 25F, 100F , (100*(i+1)).toFloat() + 25F,200F , whitespace_Paint)
            //}
        }
    }


}