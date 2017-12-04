package year2017

import kotlin.math.absoluteValue
import kotlin.math.sqrt

fun main(args : Array<String>) {

    println(distance(325489))

    for(i in 1 .. 40) {
        println("cell: $i d=${distance(i)}")
    }
}

fun distance(input: Int) : Int {
    val dSqrt = Math.sqrt(input.toDouble())
    val iSqrt : Int = dSqrt.toInt()

    //this doesn't hold if the input is a square itself
    val size = iSqrt + 1

    //row and column of the smaller square
    var col = iSqrt / 2 - (1 - iSqrt % 2)
    var row = col + (1 - iSqrt % 2)

    val nextCorner = iSqrt * iSqrt + iSqrt + 1
    if(input > nextCorner) {
        col -= (input - nextCorner -1)
        row -= (size - 1)
    } else {
        col += 1
        row  = size / 2 - (nextCorner - input)
    }

    val d = row.absoluteValue + col.absoluteValue

    return d
}