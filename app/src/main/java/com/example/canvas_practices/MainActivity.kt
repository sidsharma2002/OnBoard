package com.example.canvas_practices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.canvas_practices.graphics.CustomView

class MainActivity : AppCompatActivity() {

      private val gamelogic  = businesslogic(this)
      private val PLAYER_MOVEDLEFT : Int = 1
      private val PLAYER_STILL : Int = 0
    private lateinit var BoardView  : CustomView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BoardView = findViewById(R.id.BoardView)
    }

    fun onleft_clicked(view : View) {
                gamelogic.changepositions(PLAYER_MOVEDLEFT, PLAYER_STILL , BoardView , view)
    }
}