package year2016

import java.io.File
import kotlin.math.absoluteValue

fun main(args : Array<String>) {

    var x = 0
    var y = 0
    var d = 0 // 0: east, 1: north, 2: west, 3: south
    var trace = true

    File("resources/2016/input1.txt").forEachLine {
        it ->

        if(trace) {
            println("Step: $it at position ($x,$y).")
        }

        when(it.substring(0,1)) {
            "L" -> d = (d + 1) % 4
            "R" -> d = (d + 3) % 4
        }

        var steps = Integer.parseInt(it.substring(1))

        x += when(d) {
            0 -> steps
            2 -> -steps
            else -> 0
        }

        y += when(d) {
            1 -> steps
            3 -> -steps
            else -> 0
        }
    }

    var dist = x.absoluteValue + y.absoluteValue
    println("The distance from the start is $dist steps.")
}