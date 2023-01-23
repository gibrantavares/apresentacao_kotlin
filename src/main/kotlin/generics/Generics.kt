package generics

open class OperationalSystem(open val name: String) {
    open fun updatePackages() {
        println("update OS packages")
    }
}

class Windows (
    override val name: String = "Windows XP"
): OperationalSystem(name) {
    override fun updatePackages() {
        println("update windows packages")
    }
}

class Linux (
    override val name: String = "Linux Ubuntu"
): OperationalSystem(name) {
    override fun updatePackages() {
        println("update linux packages")
    }
}

open class OSX (
    override val name: String = "OSX Monterey"
): OperationalSystem(name) {
    override fun updatePackages() {
        println("update osx packages")
    }
}

open class Computer<T: OperationalSystem>(
    private val os: T,
) {

    fun turnOff() {
        println("desligando computador")
    }

    fun turnOn() {
        println("desligando computador")
    }

    fun showOperationalSystem() {
        println(os.name)
    }

    val x = listOf(232, 2323)
}



fun main() {

    val computer= Computer(Linux())

    computer.turnOff()
    computer.turnOn()
    computer.showOperationalSystem()

    val computers: List<OperationalSystem> = listOf(OSX())

}