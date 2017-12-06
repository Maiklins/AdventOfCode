package year2017

import java.io.File
import java.util.*

fun main(args : Array<String>) {

    val mSize = 16
    val s = Scanner(File("resources/2017/input_6.txt")!!)
    val memory = IntArray(mSize)
    val states = HashSet<String>()

    for(i in 0 .. (mSize - 1)) {
        memory[i] = s.nextInt()
    }

    //iterate

    var secondRound = false
    var stateToFind = ""
    var lCycle = 1


    while(true) {
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
            iMax = (iMax + 1) % mSize
            memory[iMax] = memory[iMax] + 1
            max--
        }

        var hash = hash(memory)
        println("hash: $hash")

        if(!secondRound) {
            if (states.contains(hash)) {
                println("state to find: $stateToFind")
                secondRound = true
                stateToFind = hash
                lCycle = 1
            } else {
                states.add(hash)
            }
        } else {
            if(hash.equals(stateToFind) || lCycle > 6690) {
                break
            } else {
                lCycle++
            }

        }
    }

    println(states.size)

    println("cycles: $lCycle")
    s.close()
}

