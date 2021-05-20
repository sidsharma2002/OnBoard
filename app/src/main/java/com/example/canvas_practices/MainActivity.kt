package com.example.canvas_practices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.canvas_practices.graphics.CustomView

class MainActivity : AppCompatActivity() {

      private val gamelogic  = businesslogic(this)
      private val PLAYER_MOVEDLEFT : Int = 1
      private val PLAYER_STILL : Int = 0
      private lateinit var BoardView  : CustomView
      private lateinit var Button_Rightmove : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BoardView = findViewById(R.id.BoardView)
        Button_Rightmove = findViewById(R.id.Button_Rightmove)
        Button_Rightmove.setOnClickListener {
               gamelogic.changepositions(PLAYER_MOVEDLEFT, PLAYER_STILL , BoardView , Button_Rightmove)
        }
    }

}