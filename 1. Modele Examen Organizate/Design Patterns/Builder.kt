
data class Mail(var destinatar: String,
                var expeditor: String,
                var mesaj: String = "",
                var titlu: String = "",
                var ora: Int = 0)

class MailBuilder(val destinatar: String, val expeditor: String)
{
    private var mail: Mail = Mail(destinatar,expeditor)

    fun mesaj(mesaj: String)
    {
        mail.mesaj = mesaj
    }

    fun titlu(titlu: String)
    {
        mail.titlu = titlu
    }

    fun ora(ora: Int)
    {
        mail.ora = ora
    }

    fun build(): Mail
    {
        return mail
    }

    override fun toString(): String {
        return super.toString()
    }

}

fun main()
{

    val mailBuilder = MailBuilder("paul", "geanina")
    mailBuilder.titlu("titlu2")
    mailBuilder.ora(17)

    val mail2 = mailBuilder.build()

    println(mail2)


}