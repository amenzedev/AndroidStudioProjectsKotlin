package chapter5._05_04.begin

import java.io.File

fun main() {
    val res = "./resources"
    val sales = "sales.txt"
    val inFile = File("${res}/$sales")
    val newSales = mutableListOf<Double>()
    inFile.forEachLine { val a = it
        val b = a.toDoubleOrNull() ?: ""
        if(b != "") {
            newSales.add(it.toDouble())
        }

    }
    println(newSales)

}
