package com.example.canvas_practices.pieces

import kotlin.properties.Delegates

class Pieces_moves(row : Int , col : Int) {
    var  col by Delegates.notNull<Int>()
    var  row by Delegates.notNull<Int>()

    init {
        this.row = row
        this.col = col
    }

}