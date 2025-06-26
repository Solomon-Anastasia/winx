package com.pp.laborator

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

fun main() = runBlocking<Unit>{
    launch{
        var line = File("input.txt").readLines()
        var cuvinte : List<String> = mutableListOf()

        line.forEach{
                line -> cuvinte = line.split(" ")
        }

        var rezultat : String = ""
        var newList = mutableListOf<String>()
        cuvinte.asSequence()
            .filter{it.length > 3}
            .toList()
            .forEach {
                var it2 = it.toList()
                if (it2.size % 2 == 0) {
                    var length = it2.size / 2 - 1
                    var newString = it.drop(length).dropLast(length)
                    newList.add(newString)
                }
            }

        rezultat = newList.asSequence().joinToString(separator = "")
        println(rezultat)
    }
}