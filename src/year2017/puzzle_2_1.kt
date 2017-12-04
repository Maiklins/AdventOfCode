package year2017

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun main(args : Array<String>) {

    var sum = 0
    val s = Scanner(File("resources/2017/input_2.txt")!!)
    var min : Int
    var max : Int

    while(s.hasNextLine()) {
        val sTemp = Scanner(s.nextLine())

        min = Int.MAX_VALUE
        max = 0
        while(sTemp.hasNextInt()) {
            val cur = sTemp.nextInt()
            min = if(cur < min) cur else min
            max = if(cur > max) cur else max
        }

        sum += (max - min)
    }

    println(sum)
}