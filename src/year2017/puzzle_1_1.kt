package year2017

import java.io.File
import java.util.*

fun main(args : Array<String>) {


    val s = Scanner(File("resources/2017/input_1_1.txt")!!).useDelimiter("")

    val first = Integer.parseInt(s.next())
    var prev = first
    var sum = 0

    while(s.hasNext()) {
        var cur = Integer.parseInt(s.next())
        sum += (if(cur == prev) prev else 0)
        prev = cur
    }

    sum += (if(prev == first) prev else 0)

    println(sum)

}