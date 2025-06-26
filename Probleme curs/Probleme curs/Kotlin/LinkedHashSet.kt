val set=HasSet<String>()
	set.add("a")
	set.add("b")
	set.add("c")
val array =arrayOfNulls<string>(set.size)
set.toArray(array)
println("Array: ${Arrays.toString(array)}")

Set<Angajati> angajatiSet= new HashSet<>()
List<Angajati>angajatiList=new ArrayList<>()

long iterators=1000
Angajati angajati=new Angajati(100L,"Harry")

for(long i=0;i<iteration;i++){
	angajatiSet.add(new Angajati(i,"John"))
	angajatiList.add(new Angajati(i,"John"))
}
angajatiList.add(angajati)
angajatiSet.add(angajati)