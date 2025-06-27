package s24

import java.io.File

// --- Base Student interface ---
interface Student {
    val name: String
    val group: String
    val grades: Map<String, Double>
    fun displayStatus()
}

// --- Concrete classes for each student type ---
class IntegralistStudent(
    override val name: String,
    override val group: String,
    override val grades: Map<String, Double>
) : Student {
    override fun displayStatus() {
        println("$name ($group) is an INTEGRALIST.")
    }
}

class RestantierStudent(
    override val name: String,
    override val group: String,
    override val grades: Map<String, Double>
) : Student {
    override fun displayStatus() {
        println("$name ($group) is a RESTANTIER.")
    }

    fun accessData(password: String) {
        if (password == "secret") {
            println("Access granted for restantier $name. Grades: $grades")
        } else {
            println("Access denied for restantier $name.")
        }
    }
}

class RepetentStudent(
    override val name: String,
    override val group: String,
    override val grades: Map<String, Double>
) : Student {
    override fun displayStatus() {
        println("$name ($group) is a REPETENT.")
    }

    fun accessData(password: String) {
        if (password == "secret") {
            println("Access granted for repetent $name. Grades: $grades")
        } else {
            println("Access denied for repetent $name.")
        }
    }
}

// --- Factory ---
object StudentFactory {
    fun createStudent(name: String, group: String, grades: Map<String, Double>): Student {
        val countFails = grades.values.count { it < 5 }
        return when {
            countFails == 0 -> IntegralistStudent(name, group, grades)
            countFails in 2..3 -> RestantierStudent(name, group, grades)
            countFails >= 4 -> RepetentStudent(name, group, grades)
            else -> IntegralistStudent(name, group, grades) // fallback
        }
    }
}

// --- Main ---
fun main() {
    val filename = "student.txt" // Your input file path

    File(filename).forEachLine { line ->
        val parts = line.split(",")
        val name = parts[0].trim()
        val group = parts[1].trim()

        val grades = mutableMapOf<String, Double>()
        for (i in 2 until parts.size step 2) {
            val course = parts[i].trim()
            val grade = parts[i + 1].trim().toDouble()
            grades[course] = grade
        }

        val student = StudentFactory.createStudent(name, group, grades)
        student.displayStatus()

        // Proxy access for restantier and repetent
        when (student) {
            is RestantierStudent -> student.accessData("secret")
            is RepetentStudent -> student.accessData("wrongpass")
        }
    }
}
