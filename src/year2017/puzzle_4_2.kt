package year2017

import java.io.File
import java.util.*

fun main(args : Array<String>) {

    val s = Scanner(File("resources/2017/input_4.txt")!!)
    var nValid = 0

    while(s.hasNextLine()) {
        val s2 = Scanner(s.nextLine())
        var valid = true
        val list = HashSet<String>()

        while(s2.hasNext() && valid) {
            val word = sortWord(s2.next())
            valid = !list.contains(word)
            list.add(word)
        }
        nValid += if(valid) 1 else 0
    }

    println("total valid: $nValid")

}

fun sortWord(word : String) : String {
    val result = StringBuffer()
    for(c in word.asSequence().sorted()) {
       result.append(c)
    }
    return result.toString()
}