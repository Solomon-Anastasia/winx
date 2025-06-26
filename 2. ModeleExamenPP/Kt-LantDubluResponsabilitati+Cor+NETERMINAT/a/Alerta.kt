
data class Alerta(val mes:String, val niv_alerta:Int, val comanda:()->Unit)
{
    var niv_emitere:Int?=null
}