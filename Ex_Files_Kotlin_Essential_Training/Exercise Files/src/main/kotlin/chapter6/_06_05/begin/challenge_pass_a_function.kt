package chapter6._06_05.begin

fun replicate(func: (Int, String) -> Unit) {
    func(3, "Be Cool.")
}

fun main() {
    // call replicate() here
    replicate{count,msg ->
        for(i in 0..count)
            println(msg)
    }

}

