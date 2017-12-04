package year2017

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun main(args : Array<String>) {

    var sum = 0
    val s = Scanner(File("resources/2017/input_2.txt")!!)

    while(s.hasNextLine()) {
        val sTemp = Scanner(s.nextLine())
        val list = ArrayList<Int>()
        var result = 0

        while(sTemp.hasNextInt()) {
            val cur = sTemp.nextInt()
            for(test in list) {
                result += if(cur % test == 0) cur / test else if (test % cur == 0) test / cur else 0
                if(result > 1) {
                    break
                }
            }
            if(result > 1) {
                sum += result
                break
            }
            list.add(cur)
        }
    }

    println(sum)
}