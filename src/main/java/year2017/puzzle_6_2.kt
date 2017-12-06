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

    val toFind = memory.joinToString()
    var count = 0
    while(nextHash(memory) != toFind) {
        count++
    }

    println("We need to loop ${states.size} until we reach an existing state and the cycle is $count.")
    s.close()
}
