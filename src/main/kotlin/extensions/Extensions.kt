package extensions

private fun String.addEnthusiasm(enthusiasmLevel: Int = 1) =
    this + "!".repeat(enthusiasmLevel)

val String.numVowels
    get() = count { it.lowercase() in "aeiou" }


fun main() {

    val name = "Aurelio"

    println(name.numVowels) // 5

    println(name.addEnthusiasm(5)) // Aurelio!!!!!
}