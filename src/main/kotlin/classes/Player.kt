package classes


enum class SoccerPlayerPosition {
    STRIKER,
    CENTER_MID,
    CENTER_BACK
}

data class PlayerInfo(
    val hometown: String = "Aracati",
    var healthPoints: Int,
    val isImmortal: Boolean
)

class Player(
    initialName: String,
    private val playerInfo: PlayerInfo
) {

    var name = initialName
        get() = field.replaceFirstChar { it.uppercase() }
        private set(value) {
            field = value.trim()
        }

    val title: String
        get() = when {
            name.all { it.isDigit() } -> "The Identifiable"
            name.none { it.isLetter() } -> "The Witness Protection Member"
            name.count { it.lowercase() in "aeiou" } > 4 -> "The Master of Vowels"
            else -> "The Renowned Hero"
        }

    init {
        println("INIT =======")
        require( playerInfo.healthPoints > 0) { "healthPoints must be greater than zero" }
        require(name.isNotBlank()) { "Player must have a name" }
    }

    constructor(name: String) : this(
        initialName = name,
        PlayerInfo(healthPoints = 100, isImmortal = false)
    ) {
        println("Constructor")
        if (name.equals("David", ignoreCase = true)) {
            playerInfo.healthPoints = 500
        }
    }

    companion object {
        fun printEnumValues() {
            SoccerPlayerPosition.values().forEach { println(it) }
            println(SoccerPlayerPosition.valueOf("STRIKER"))
        }

    }
}

fun main() {

    val playerInfo1 = PlayerInfo(healthPoints = 100, isImmortal = false)
    val playerInfo2 = PlayerInfo(healthPoints = 100, isImmortal = false)

    println(playerInfo1 == playerInfo2)
    println(playerInfo1 === playerInfo2)

    val player = Player("john")

    println(playerInfo1)
    println(player)


    println("Name ===> ${player.name}")

    println("Title ===> ${player.title}")

    Player.printEnumValues()
}