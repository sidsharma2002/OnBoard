package com.example.canvas_practices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.canvas_practices.cache.Values
import com.example.canvas_practices.graphics.CustomView

class MainActivity : AppCompatActivity() {

      // Global variables
      private val gamelogic  = businesslogic(this)
      private val PLAYER_MOVEDLEFT : Int = 1
      private val PLAYER_MOVEDDOWN : Int = 1
      private val PLAYER_STILL : Int = 0
      private lateinit var BoardView  : CustomView
      private lateinit var scrollView  : LinearLayout
      private lateinit var Button_Rightmove : ImageButton
      private lateinit var Button_Downmove : ImageButton
      private lateinit var Textview_playerscore : TextView
    private lateinit var Textview_botscore : TextView
      private var values = Values()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize Views and Variables
        BoardView = findViewById(R.id.BoardView)
        scrollView = findViewById(R.id.scrollView)
        Button_Rightmove = findViewById(R.id.Button_Rightmove)
        Button_Downmove = findViewById(R.id.Button_Downmove)
        Textview_playerscore = findViewById(R.id.TextView_playerscore)
        Textview_botscore = findViewById(R.id.TextView_botscore)
        // set values to board

        // call change position logic when Right button is clicked
        Button_Rightmove.setOnClickListener {
               gamelogic.changepositions(PLAYER_STILL ,PLAYER_MOVEDLEFT
                                                                    ,   BoardView ,scrollView,
                                                                        Button_Rightmove,
                                                                       true,
                                                                        values,
                                                                        Textview_playerscore,
                                                                        Textview_botscore
                                                                        )
        }
        // call change position logic when Down button is clicked
        Button_Downmove.setOnClickListener {
            gamelogic.changepositions(PLAYER_MOVEDDOWN, PLAYER_STILL,
                                                                    BoardView,
                                                                    scrollView,
                                                                    Button_Downmove,
                                                                    false,
                                                                    values,
                                                                    Textview_playerscore,
                                                                    Textview_botscore
                )
        }
    }


}