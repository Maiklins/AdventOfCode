package year2017

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun main(args : Array<String>) {

    val mSize = 16
    val s = Scanner(File("resources/2017/input_6.txt")!!)
    val memory = IntArray(mSize)
    val states = HashSet<String>()


    for(i in 0 .. (mSize - 1)) {
        memory[i] = s.nextInt()
    }

    //iterate


    while(true) {
        var max = 0
        var iMax = 0
        memory.forEachIndexed { i, m ->
            if (m > max) {
                max = m
                iMax = i
            }
            return@forEachIndexed
        }
        


        memory[iMax] = 0
        while (max > 0) {
            iMax = (iMax + 1) % mSize
            memory[iMax] = memory[iMax] + 1
            max--
        }

        var hash = memory.joinToString()
        println("hash: $hash")

        if (states.contains(hash)) {
            break
        } else {
            states.add(hash)
        }
    }

    println(states.size)
    s.close()
}

fun hash(memory : IntArray) : String {

    val hash = StringBuffer()
    for( i in memory) {
        hash.append(i)
    }

    return hash.toString()
}