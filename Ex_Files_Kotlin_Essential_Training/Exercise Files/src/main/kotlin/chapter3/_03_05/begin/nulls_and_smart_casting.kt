package chapter3._03_05.begin

data class Person(var firstName: String, var lastName: String)

fun main() {

    val person2 : Person? = null

    val greeting:String? = "Hello there"  //change it to null to check line 18

    if(greeting != null)
        println("Joe says: $greeting")
    println("greeting length = ${greeting?.length}")

    val len = greeting?.length ?: 0
    println("Length = $len")

    val badLen = greeting!!.length

    val safeGreeting:String? = greeting as? String
}
