import org.omg.CORBA.ORB.init

class Person constructor(val firstName: String, val lastName:String, val age:Int?){}

class Person2 (val firstName: String,val lastName:String,val age:Int?){
    init{
        require(firstName.trim().length >0){
            "Invalid firstName argument." }
        require(lastName.trim().length >0){
            "Invalid lastName argument." }
        if(age!=null){
            require(age>=0 && age<150){"Invalid age argument."}
        }
    }
}
/*fun main(args:Array<String>){
    val person1 =Person("Alex","Smith",29)
    val person2 =Person("Jane","Smith",null)
    println("${person1.firstName} ${person1.lastName}is ${person1.age} years old")
    println("${person2.firstName} ${person2.lastName}is ${person2.age?.toString()?:"?"} years old")

    //Nu merge....
    //Person2 p = new Person2("Jack", "Miller", 21);
}*/