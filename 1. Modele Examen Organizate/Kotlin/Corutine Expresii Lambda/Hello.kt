package com.pp.laborator

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

fun List<Int>.divide3() : List<Int>{
    return this.map{it -> Math.floor((it / 3).toDouble()).toInt()}
}

fun List<Int>.multiply5() : List<Int>{
    return this.map{it -> it * 5}
}

fun main(args: Array<String>) = runBlocking<Unit>{
    val fileName = "intrare.txt"
    var file = File(fileName).readText(Charsets.UTF_8)
    var myListString = file.split(" ")
    var myList = myListString.map{it -> it.toInt()}

    launch{
        println(myList)
        println(myList.divide3().toString())
        myList = myList.divide3()
        println(myList.multiply5().toString())
    }


}





