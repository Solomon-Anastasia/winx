fun <U, V>List<Pair<U,V>>.showPoints(){
    this.forEachIndexed { index, pair ->
        print(" P$index(${pair.first}, ${pair.second}) ")
    }
    println("")
}
fun main(args: Array<String>) {
    val point3D =  listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 1),
        listOf(7, 0, 2),
        listOf(8, -4, 2),
        listOf(1, 1, 1),
        listOf(-1, 10, 23)
    )

    println("Punctele 3D:")
    println(point3D)

    val point2D = point3D.asSequence().map{point3 ->
        listOf(
            Pair(point3[0], point3[1]), //XoY
            Pair(point3[1], point3[2]), //XoZ
            Pair(point3[0], point3[2])  //YoZ
        )
    }.toList()

    println("Lista cu intersectiile cu cele 3 planuri: ")
    println(point2D)

    // creem grupuri de cate 2 puncte
    val goupsOfPairs = point2D.map{
        (it + it[0]).zipWithNext()
    }
    println(goupsOfPairs)

    // creez dreptele de forma (a, b, c) cu semnificatia ax + by + c = 0
    val drepte = goupsOfPairs.map {group ->
        group.map {
            val point1 = it.first
            val point2 = it.second

            if(point1.first == point2.first) // x1 = x2 -> problemuta
            {
                // a=1, b=0, c=x1
                listOf(1, 0, point1.first )
            }
            else{
                var a = (point2.second - point1.second)/(point2.first - point1.first)
                var b = point1.second - a*point1.first

                // de forma ax + b = y   => ax - y + b = 0  => a=a ,  b=-1,  c=b
                listOf(a, -1, b)
            }
        }
    }

    println(drepte)

    // se depisteaza intersectia dreptelor
    val puncteDeIntersectie = drepte.map {
        val listWithFirst = it + listOf(it.first())
        listWithFirst.zipWithNext().map{
            val dr1 = it.first
            val dr2 = it.second

            // y = mx + n
            // m1 == m2 => ori paralele, ori coincid

            if(dr1[1] == 0 || dr2[1] == 0)
            {
                // complicat
                if(dr1[1] == dr2[1]){
                    // ambele sunt 0
                    //ax1 + c1 = 0
                    //ax2 + c1 = 0
                    // y = orice
                    // x = -c1/a1
                    Pair(-dr1[2]/dr1[0], null)
                }
                else{
                    // una este nula
                    var elem1 = dr1
                    var elem2 = dr2
                    if(dr2[1] == 0){
                        val aux = elem1
                        elem1 = elem2
                        elem2 = aux
                    }
                    //elem1 are b = 0
                    // a1x + c1 = 0
                    // a2x + b2y + c2 = 0
                    val x = -elem1[2]/elem1[0]
                    val y = (-elem2[2] - elem2[0] * x) / elem2[1]
                    Pair(x, y)

                }
            }
            else{
                if(-dr1[0]/dr1[1] == -dr2[0]/dr2[1]){
                    // sunt paralele sau coincid
                    Pair(null, null)

                }else{
                    val m1 = -dr1[0]/dr1[1]
                    val m2 = -dr2[0]/dr2[1]
                    val n1 = -dr1[2]/dr1[1]
                    val n2 = -dr2[2]/dr2[1]


                    val x = (n2-n1) / (m1 - m2)
                    val y = m1 * x + n1

                    Pair(x, y)
                }
            }
        }
    }.flatMap { it }

    println()
    println(puncteDeIntersectie)

    println()
    puncteDeIntersectie.showPoints()

}