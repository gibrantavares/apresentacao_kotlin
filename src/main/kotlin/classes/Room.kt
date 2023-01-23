package classes


private const val TAVERN_NAME = "The Prancing Pony"

open class Room(val name: String) {

    protected open val status = "Calm"

    fun description() = "$name (Currently: $status)"

    open fun enterRoom() {
        println("There is nothing to do here")
    }

}
class Tavern : Room(TAVERN_NAME) {
    private var player = Player("Jack")

    override val status = "Busy"

    override fun enterRoom() {
        println("${player.name} enters $TAVERN_NAME")
        println("There are several items for sale:")

        println("${player.name} sees several patrons in the tavern:")
    }
}

fun main() {





}