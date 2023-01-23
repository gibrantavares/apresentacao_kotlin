package coroutines

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDate
import java.time.LocalDateTime
import kotlinx.coroutines.flow.Flow
import java.lang.RuntimeException

//fun main() {
//    runBlocking {
//        launch {
//            delay(1000L)
//            println("World!")
//        }
//        println("Hello")
//    }
//    println("WoW")
//}

private const val BASE_URL = "http://kotlin-book.bignerdranch.com/2e"
private const val FLIGHT_ENDPOINT = "$BASE_URL/flight"
private const val LOYALTY_ENDPOINT = "$BASE_URL/loyalty"

val client = HttpClient(CIO)

//fun main() {
//
//    var flight: String? = null
//    var loyalty: String? = null
//
//
////    println(Thread.currentThread().name)
////    flight = flightEndpoint()
////    println(Thread.currentThread().name)
////    loyalty = loyaltyEndpoint()
//
//
//    println("========> $flight")
//    println("========> $loyalty")
//}


fun main() {

    val (flight, loyalty) = runBlocking {
        println("Thread: ${Thread.currentThread().name}")
        val flightDeferred = async(Dispatchers.Default) { flightEndpoint() }
        val loyaltyDeferred = async(Dispatchers.Default) { loyaltyEndpoint() }
        awaitAll(flightDeferred, loyaltyDeferred)
    }

    println(flight)
    println(loyalty)
}



//fun main() = runBlocking {
//        simpleFlow().transform { emit(it.uppercase()) }.collect { println(it) }
//    }

fun simpleFlow(): Flow<String> = flow {
    val funcs = listOf(flightEndpoint(), loyaltyEndpoint())
    funcs.forEach { emit(it)   }
}


suspend fun flightEndpoint() = client.get<String>(FLIGHT_ENDPOINT).also {
        println("========== 1")
    }
suspend fun loyaltyEndpoint() = client.get<String>(LOYALTY_ENDPOINT).also {
        println("========== 2")
    }

