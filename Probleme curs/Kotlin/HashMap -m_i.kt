
fun main(args: Array<String>){
    //HashMAps -immutable
    val builder =StringBuilder()
    val colors=mapOf("GOLD" to "#FFD700","YELLOW" to "#FFFF00","ALICEBLUE" to "#F0F8FF","BISQUE" to "#FFE4C4")

    builder.append("Parcurgere\n")
    colors.forEach{
        key,value ->builder.append("\n$key:$value")
        val keys:List<String> =colors.keys.toList()
        val values:List<String> = colors.values.toList()
        builder.append("\n\nHashMap keys list\n")
        keys.forEach{
            builder.append("$it,")
        }
        builder.append("\n\nHashMap values list\n")
        values.forEach{
            builder.append("$it,")
        }
    }
    //HashMaps -mutable
    val builder1=StringBuilder()
    val colors1=mutableMapOf<String,String>()

    colors1.put("INDIANDRED","#CD5C5C")
    colors1.put("CRIMSON","#DC143C")
    colors1.put("LIGHTCORAL","#F08080")

    builder1.append("Parcurgere")
    colors1.forEach{
        key,value ->builder1.append("\n$key,$value")
    }
    colors1.remove("CRIMSON")
    builder1.append("\n\n Dupa stergerea unui element")
    for((key,value)in colors1){
        builder1.append("\n$key,$value")
    }
    colors1.put("SALMON","NEW VALUE")
    builder1.append("\n\nEste HashMap goala?: ${colors1.isEmpty()}")

    val value =colors1.get("LIGHTCORAL")
    builder1.append("\n\nLIGHTCORAL value $value")

    val reds=mutableMapOf("RED" to "#FF0000","FIREBRICK" to "#B22222","CRIMSON" to "#DC145C")

    builder1.append("\n\nParcurgere harta")
    reds.forEach{
        key,value ->builder1.append("\n$key: $value")
    }

    //textView.text=builder1.toString()
}