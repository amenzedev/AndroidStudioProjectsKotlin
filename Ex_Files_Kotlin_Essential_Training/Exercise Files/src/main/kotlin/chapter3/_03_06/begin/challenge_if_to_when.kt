package chapter3._03_06.begin

fun main() {
    var cardPoints = 7_000

    // TODO: replace this if with a when
    // bonus points for using ranges!

    var cardLevel: String = if (cardPoints >= 0 && cardPoints < 1000) {
        "pearl"
    } else if (cardPoints >= 1000 && cardPoints < 5_000) {
        "silver"
    } else if (cardPoints >= 5_000 && cardPoints < 10_000) {
        "gold"
    } else {
        "platinum"
    }

    var plural = if(cardPoints > 1 || cardPoints == 0) "s" else ""
    println("You have $cardPoints point$plural and are at the $cardLevel level.")

    cardLevel = when(cardPoints)
    {
        in 0..999 -> "pearl"
        in 1000..4999 -> "silver"
        in 5000..10000 -> "gold"
        else -> "platinum"
    }

    plural = if(cardPoints > 1 || cardPoints == 0) "s" else ""
    println("You have $cardPoints point$plural and are at the $cardLevel level.")
}
