package generics

open class Escola
open class AriDeSa: Escola()
open class Master: Escola()
val ariDeSa: Master = Master()
val master: AriDeSa = AriDeSa()


//fun main() {
//    // ? extends Integer
//    var foo1: MutableList<out Number> = mutableListOf(45, 23, 2L, 4.4)
//    val foo2: MutableList<out Number> = mutableListOf<Int>()
//    val foo3: MutableList<out Number> = mutableListOf<Double>()
//
//    val foo4: MutableList<Int> = mutableListOf(45, 23, 2)
//    val foo5: MutableList<Double> = mutableListOf(4.4)
//
//    foo1 = foo4
//    foo1 = foo5 // variance
//
//    println(foo1.get(0))
//
//    foo1.add(5.2)
//
////    foo1.add(5)
//}


fun main() {

    // ? super Integer
    var foo1: MutableList<in Int> = mutableListOf(45, 23, 58, 34)

    val foo4: MutableList<in Int> = mutableListOf<Number>(45, 23, 2)
    val foo5: MutableList<in Int> = mutableListOf<Number>(4.4)

    foo1 = foo4
    foo1 = foo5 // variance

    println(foo1.get(0))

    foo1.add(5)

    println(foo1.get(1))
}