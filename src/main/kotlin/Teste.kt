import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Instant

//fun main() = runBlocking{
//    println("${Instant.now()}: My program runs...: ${Thread.currentThread().name}")
//
//    val productId = findProduct()
//
//    launch (Dispatchers.Unconfined) { // start a coroutine
//        val price = fetchPrice(productId) // call the suspending function
//    }
//    updateProduct()
//
//    println("${Instant.now()}: My program run ends...: ${Thread.currentThread().name}")
//}

suspend fun fetchPrice(productId: String) : Double{
    println("${Instant.now()}: fetchPrice starts on...: ${Thread.currentThread().name} ")
    delay(5000) // simulate the slow function by adding a delay
    println("${Instant.now()}: fetchPrice ends on...: ${Thread.currentThread().name} ")
    return 234.5
}

fun findProduct() : String{
    println("${Instant.now()}: findProduct on...: ${Thread.currentThread().name}")
    return "P12333"
}

fun updateProduct() : String{
    println("${Instant.now()}: updateProduct on...: ${Thread.currentThread().name}")
    return "Product updated"
}


fun main() = runBlocking {
    repeat(1000) {
        val dispatcher = Dispatchers.Default
        launch(dispatcher) { // will get dispatched to DefaultDispatcher
            println("Default  : running in thread ${Thread.currentThread().name}")
            longTask()
        }
    }
}

suspend fun longTask(){
    println("executing longTask on...: ${Thread.currentThread().name}")
    delay(1000)
    println("longTask ends on thread ...: ${Thread.currentThread().name}")
}