package year2017

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun main(args : Array<String>) {

    var sum = 0
    val s = Scanner(File("resources/2017/input_1.txt")!!).useDelimiter("")
    val digits = ArrayList<Integer>()

    while(s.hasNext()) {
        digits.add(Integer(s.next()))
    }

    val l = digits.size
    val step = l / 2
    for(i in digits.indices) {
        val other = ( i + step ) % l
        sum += (if(digits[i].compareTo( digits[other].toInt()) == 0) digits[i].toInt() else 0)
    }

    println(sum)

}