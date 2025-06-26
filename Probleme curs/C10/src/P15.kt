import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

//Reflexie la nivel de instanta

fun main(args: Array<String>){
    val person =Person("Lisa",23)
    println(person.present())
    printProperty(person,Person::name)
    incrementProperty(person,Person::age)
    println(person.present())
}
class Person(val name: String, var age:Int){
    fun present() ="Sunt $name, si a, $age ani"
    fun greet(other:String)="Salut, $other, sunt $name"
}
fun <T>printProperty(instance: T, prop: KProperty1<T, *>){
    println("${prop.name} = ${prop.get(instance)}")
}
fun <T> incrementProperty(instance: T, prop: KMutableProperty1<T,Int>){
    val value =prop.get(instance)
    prop.set(instance,value+1)
}