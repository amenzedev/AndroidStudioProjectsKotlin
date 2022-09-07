package chapter7._07_05.begin

class CantCreate private constructor(val message: String) {
    fun showMessage() {
        println(message)
    }
    companion object {
        const val Light_Speed = 299_792_458
        fun factory(msg: String):CantCreate{
            return CantCreate(msg)
        }

        fun sillyPrint(self: CantCreate)
        {
            println("Accessing ${self.message}")
        }
    }
}

fun main() {
    val c1 = CantCreate.factory("Hello")
    c1.showMessage()
    CantCreate.sillyPrint(c1)
    println("The speed of light is ${CantCreate.Light_Speed} m/s")
}
