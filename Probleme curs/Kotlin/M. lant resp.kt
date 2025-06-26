import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

//Model lant de responsabilitati

interface HeadersChain{
    fun addHeader(inputHeader :String):String
}
class AuthenticationHeader(val token: String?,var next: HeadersChain? =null): HeadersChain{
    override fun addHeader(inputHeader: String):String{
        token?:throw IllegalStateException("Token should be not null")
        return inputHeader + "Authorization: Bearer $token\n".let{next?.addHeader(it)?:it}
    }
}
class ContentTypeHeader(val contentType:String, var next: HeadersChain?=null):HeadersChain{
    override fun addHeader(inputHeader:String):String=inputHeader+"ContentType: $contentType\n".let{next?.addHeader(it)?:it}
}
class BodyPayload(val body: String,var next: HeadersChain? =null):HeadersChain{
    override fun addHeader(inputHeader: String):String=inputHeader+"$body".let{next?.addHeader(it)?:it}
}
/*class ChainOfResponsibilityTest{
    @Test
    fun 'Chain Of Responsibility'(){
        val authenticationHeader =AuthenticationHeader("123456")
        val contentTypeHeader = ContentTypeHeader("json")
        val messageBody= BodyPayload("Body:\n{\n\"username\"=\"dbacinski\"\n}")

        authenticationHeader.next =contentTypeHeader
        contentTypeHeader.next =messageBody

        val messageWithAuthentication = authenticationHeader.addHeader("Header with Authentication:\n")
        println(messageWithAuthentication)
        val messageWithoutAuth=contentTypeHeader.addHeader("Headers:\n")
        println(messageWithoutAuth)
        assertThat(messageWithAuthentication).isEqualTo(
            """Headers with Authentication:
            Authorization: Bearer 123456
            ContentType: json
            Body:{"username"="bonjovi2987"}
            """.trimIndent()
        )
        assertThat(messageWithoutAuth).isEqualTo(
            """Headers:
            ContentType: json
            Body:{"username"="dbacinski"}
            """.trimIndent()
        )
    }
}*/