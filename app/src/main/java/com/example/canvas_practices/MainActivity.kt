package com.example.canvas_practices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

      private val gamelogic  = businesslogic(this)
      private val PLAYER_MOVEDLEFT : Int = 1
      private val PLAYER_STILL : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onleft_clicked(view : View) {
                gamelogic.changepositions(PLAYER_MOVEDLEFT, PLAYER_STILL)
    }
}