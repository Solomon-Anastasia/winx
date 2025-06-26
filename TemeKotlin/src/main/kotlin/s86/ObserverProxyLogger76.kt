package s86

import java.io.File
import java.time.LocalDateTime

// --- Observer Pattern ---
interface Observer {
    fun update(user: String, change: String)
}

interface Subject {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers(user: String, change: String)
}

// --- Logger Observer ---
class Logger(filePath: String = "log.txt") : Observer {
    private val logFile = File(filePath)

    override fun update(user: String, change: String) {
        val timestamp = LocalDateTime.now()
        logFile.appendText("[$timestamp] User: $user -> $change\n")
        println("Logged: [$timestamp] $user -> $change")
    }
}

// --- PriceCalculator (Subject) ---
class PriceCalculator(private var basePrice: Double) : Subject {
    private val observers = mutableListOf<Observer>()

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers(user: String, change: String) {
        observers.forEach { it.update(user, change) }
    }

    fun applyDiscount(user: String, discountRate: Double) {
        val oldPrice = basePrice
        basePrice *= (1 - discountRate)
        val change = "Applied $discountRate discount: $oldPrice -> $basePrice"
        println(change)
        notifyObservers(user, change)
    }
}

// --- Proxy ---
class PriceCalculatorProxy(
    private val realCalc: PriceCalculator,
    private val credentials: Map<String, String>
) {
    fun requestDiscount(user: String, password: String, rate: Double) {
        if (credentials[user] == password) {
            println("Access granted for $user.")
            realCalc.applyDiscount(user, rate)
        } else {
            println("Access denied for $user.")
        }
    }
}

// --- Main Program with Keyboard Input ---
fun main() {
    val calc = PriceCalculator(100.0)
    val logger = Logger()
    calc.addObserver(logger)

    val credentials = mapOf("admin" to "1234", "alice" to "pass", "bob" to "pwd")
    val proxy = PriceCalculatorProxy(calc, credentials)


    while (true) {
        print("Enter username (or 'exit'): ")
        val user = readln()
        if (user == "exit") break

        print("Enter password: ")
        val password = readln()

        print("Enter discount rate (e.g. 0.1 for 10%): ")
        val rateInput = readln()
        val rate = rateInput.toDoubleOrNull()

        if (rate == null || rate !in 0.0..1.0) {
            println("Invalid discount rate.")
            continue
        }

        proxy.requestDiscount(user, password, rate)
        println("---")
    }

    println("Session ended.")
}
