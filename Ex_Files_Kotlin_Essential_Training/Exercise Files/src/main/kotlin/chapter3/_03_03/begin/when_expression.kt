package chapter3._03_03.begin

enum class Suit {
    Club, Diamond, Heart, Spade
}

fun main() {

    val x = 1
    when (x)
    {
        1 -> println("x == 1")
        2 -> println("x == 2")
        3,4 -> println("x==3 or 4")

    }

    val card = Suit.Spade
    val y = when(card)
    {
        Suit.Club,Suit.Spade -> println("black card")
        Suit.Diamond, Suit.Heart -> println("red card")
    }

    val name = "Troy"
    val lastName = when(name)
    {
        "Hattan" -> "Shbokshi"
        "Troy" -> "Miller"
        else ->{
            "Unknown"
        }

    }
    println("$name $lastName")
    val ageType = when(x){
        in 0..1 -> "baby"
        in 2..4 -> "toddler"
        in 5..12-> "teenager"
        in 20..60 ->"Adult"
        else -> "senior"
    }
    println("You are a $ageType")

}
