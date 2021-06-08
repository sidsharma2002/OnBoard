package com.example.canvas_practices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ScrollView
import com.example.canvas_practices.graphics.CustomView
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

      // Global variables
      //TODO(" code Button_Leftmove")
      private val gamelogic  = businesslogic(this)
      private val PLAYER_MOVEDLEFT : Int = 1
      private val PLAYER_MOVEDDOWN : Int = 1
      private val PLAYER_STILL : Int = 0
      private lateinit var BoardView  : CustomView
     private lateinit var scrollView  : LinearLayout
      private lateinit var Button_Rightmove : ImageButton
      private lateinit var Button_Downmove : ImageButton
      val database = Firebase.database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize Views and Variables
        val myRef = database.getReference("message")
        BoardView = findViewById(R.id.BoardView)
        scrollView = findViewById(R.id.scrollView)
        Button_Rightmove = findViewById(R.id.Button_Rightmove)
        Button_Downmove = findViewById(R.id.Button_Downmove)

        // call change position logic when Right button is clicked
        Button_Rightmove.setOnClickListener {
               gamelogic.changepositions(PLAYER_STILL ,PLAYER_MOVEDLEFT
                                                                    ,   BoardView ,scrollView,
                                                                        Button_Rightmove,
                                                                       true)
        }
        // call change position logic when Down button is clicked
        Button_Downmove.setOnClickListener {
            gamelogic.changepositions(PLAYER_MOVEDDOWN,
                                                                        PLAYER_STILL ,
                                                                        BoardView ,
                                                                        scrollView,
                                                                        Button_Downmove,
                                                                       false)
        }
    }

}