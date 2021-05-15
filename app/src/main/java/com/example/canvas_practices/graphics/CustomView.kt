package com.example.canvas_practices.graphics

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.canvas_practices.pieces.Pieces_moves

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
)
    : View(context, attrs, defStyleAttr) {

    private var player_Paint  = Paint()
    private var bot_Paint = Paint()
    private var whitespace_Paint = Paint()
    private lateinit var player : Pieces_moves
    private  lateinit var bot : Pieces_moves

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
        canvas?.drawRect(100F,100F,200F, 200F,player_Paint)
    }


}