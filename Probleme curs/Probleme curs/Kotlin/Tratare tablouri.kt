public fun IntArray.take(n:Int):List<Int>{
	require(n>=0){"Numarul de elemente $n este negativ"}
	if(n==0) return emptyList()
	if(n>=size) return toList()
	if(n==1) return listOf(this[0])
	var count=0
	val list=ArrayList<Int>(n)
	for(item in this){
		if(count++==n) break
		list.add(item)
	}
	return list
}