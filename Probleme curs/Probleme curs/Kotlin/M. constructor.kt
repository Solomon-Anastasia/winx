//Model constructor
data class Mail(val to:String,
                var title:String="",
                val message:String="",
                val cc:List<String> =listOf(),
                val bcc:List<String> =listOf(),
                val attachments: List<java.io.File> =listOf())

class MailBuilder(val to: String){
    private var mail: Mail=Mail(to)
    fun title(title: String):MailBuilder{
        mail.title=title
        return this
    }
    fun build():Mail{
        return mail
    }
}

fun main(args: Array<String>){
    val mail = Mail("one@recepient.org","Hi","How are you")

    val email =MailBuilder("hello@hello.com").title("What's up?").build()
    println(mail)
    println(email)
}