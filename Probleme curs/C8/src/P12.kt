//Modelul comanda
data class User(val name: String){}
interface Command{ fun execute(user: User)}
class AddUser: Command{
    override fun execute(user: User){
        println("Adding a new user with name: "+ user.name)
    }
}
class DeleteUser : Command{
    override fun execute(user: User){
        println("Deleting user with name: "+user.name)
    }
}
class EditUser: Command{
    override fun execute(user: User){
        println("Editing user with name: "+user.name)
    }
}
fun main(args: Array<String>){
    var user = User("Kotlin")

    var add= AddUser()
    add.execute(user)

    var edit =EditUser()
    edit.execute(user)

    var delete = DeleteUser()
    delete.execute(user)
}