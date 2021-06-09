package com.example.canvas_practices.cache

import kotlin.math.abs

class Values {
        var score_player = 0
        var score_bot = 0
        val rows = 9
        val cols = 9
        var arr = Array(rows){r->IntArray(cols){0}}
//
//        val arr = Array(rows){r ->
//        IntArray(cols) { c -> r+ r*c } }
//        }
        init {
                precompute()
        }
        fun add_score(addscore_player:Int , addscore_bot: Int) {
                score_bot+=addscore_bot
                score_player+=addscore_player
        }

        private fun precompute(){

                 arr = Array(rows){r ->
                 IntArray(cols) { c->(0..10).random() } }
                }
        }
