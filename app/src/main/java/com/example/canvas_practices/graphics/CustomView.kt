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
    init {
        // Setting properties of all thePaint()
        player_Paint.setColor(Color.DKGRAY)
        player_Paint.strokeWidth = 15F
        bot_Paint.setColor(Color.BLUE)
        bot_Paint.strokeWidth = 15F
        whitespace_Paint.setColor(Color.WHITE)
        whitespace_Paint.strokeWidth = 15F
    }
    // function to update pieces position
    fun updateboard( player : Pieces_moves , bot : Pieces_moves ) {
            this.player = player
            this.bot = bot
    }
    // Render Graphics
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // Draw all the pieces and whitespace
        drawBoard(canvas)
        drawpieces(canvas)
    }

    private fun drawpieces(canvas: Canvas?) {
        //TODO("modify WRT column")
           canvas?.drawRect((100*player.col).toFloat() + 25F , (100*player.row).toFloat() , (100*(player.col+1)).toFloat() + 25F, (100*(player.row+1)).toFloat() , player_Paint   )
           canvas?.drawRect((100*bot.col).toFloat() + 25F , (100*bot.row).toFloat() , (100*(bot.col+1)).toFloat() + 25F, (100*(bot.row+1)).toFloat() , bot_Paint   )
    }

    private fun drawBoard(canvas: Canvas?) {
        //TODO("modify for 2D board")
        // for row
        for (i in 1..8) {
            // for col
            for (j in 1..8) {
                canvas?.drawRect(
                    (100 * i).toFloat() + 25F,
                    (100 * j).toFloat(),
                    (100 * (i + 1)).toFloat() + 25F,
                    (100 * (j + 1)).toFloat(),
                    whitespace_Paint
                )
                //}
            }
        }
    }

}