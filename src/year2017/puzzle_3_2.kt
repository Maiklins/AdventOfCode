package year2017

fun main(args : Array<String>) {

    val spiral = ArrayList<Int>()

    var length = 4
    var curPos = 1

    spiral.add(1)
    spiral.add(1)
    spiral.add(2)
    spiral.add(4)
    spiral.add(5)
    spiral.add(10)
    spiral.add(11)
    for(i in 7 .. 100) {

        println("$i length: $length pso: $curPos")

        var backwards = (length - 2) * 2 + (length - 3) + 1
        backwards += ( if (curPos >= length - 1) length - 1 else length - 3)

        println("back: $backwards")

        //vorheriger
        var next = spiral[i-1]

        //oben rechts
        if(curPos != length - 2 && curPos != (2*length-3)) {
            println("back1: ${spiral[i - backwards + 1]}")
            next += spiral[i - backwards + 1]
        }

        //oben
        if(curPos != 0 && curPos != length -1) {
            println("back2: ${spiral[i-backwards]}")
            next += spiral[i-backwards]
        }

        //oben links
        if(curPos != 0 && curPos != length -1 && curPos != 1 && curPos != length) {
            println("back3: ${spiral[i-backwards-1]}")
            next += spiral[i-backwards-1]
        } else if (curPos == 1 || curPos == length){
            println("back4: ${spiral[i-2]}")
            next += spiral[i-2]
        }

        println("next: $next")
        spiral.add(next)

        if(curPos < length * 2) {
            curPos++
        }
        if(curPos == (length -1 ) * 2) {
            curPos = 0
            length++
        }
    }

    println("spiral: $spiral")
}

