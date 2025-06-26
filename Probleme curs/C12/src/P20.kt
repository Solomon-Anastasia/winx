//Delegat construit de programator

import kotlin.reflect.KProperty
class ExempluDelegatPropriu{
    var valoareDelegata: String by DelegatPropriu()
    override fun toString()="Exemplu delegat propriu"
}
class DelegatPropriu() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef am primit urmatoarea delegare '${prop.name}'"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>,value:String){
        println("$value a fost trimisa catre ${prop.name} in $thisRef")
    }
}
fun main(){
    val exemplu =ExempluDelegatPropriu()
    println(exemplu.valoareDelegata)
    exemplu.valoareDelegata ="Unul nou"
}