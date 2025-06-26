class User(private val username : String) : Subscriber {
    var notificantions = 0

    companion object {
        var id = 0
    }

    init {
        id++
    }

    override fun updateVideoAdded() {
        notificantions++
        println("User: $username ID: $id received notification. User has $notificantions notifications")
    }

    override fun updateSubscriberAdded() {
        println("$username has subscribed")
    }
}