package year2017

import java.io.File
import java.util.*

fun main(args : Array<String>) {

    val mSize = 16
    val s = Scanner(File("resources/2017/input_6.txt")!!)
    val memory = IntArray(mSize)
    val states = HashSet<String>()

    for(i in 0 until mSize) {
        memory[i] = s.nextInt()
    }

    states.add(memory.joinToString())
    do {
        val hash = nextHash(memory)
    } while ( if(states.contains(hash) ) false else {states.add(hash); true} )

    println(states.size)
    s.close()
}

fun nextHash(memory : IntArray) : String {

    var max = 0
    var iMax = 0

    memory.forEachIndexed { i, m ->
        if (m > max) {
            max = m
            iMax = i
        }
    }

    memory[iMax] = 0
    while (max > 0) {
        iMax = (iMax + 1) % memory.size
        memory[iMax] = memory[iMax] + 1
        max--
    }

    return memory.joinToString()
}