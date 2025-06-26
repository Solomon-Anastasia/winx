#liste

lst=[3,1,4,1,5,9]
lst.append(2)
print("\n"+str(lst))
lst.sort()
print("\n"+str(lst))
lst.reverse()
print("\n"+str(lst)+" "+str(lst.index(4)))
lst.insert(4,"Hello")
print("\n"+str(lst)+" "+str(lst.count(1)))
lst.remove(1)
print("\n"+str(lst))
lst.pop(3)
print("\n"+str(lst))