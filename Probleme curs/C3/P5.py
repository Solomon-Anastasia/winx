x=[1,2,3]
print("\n"+str(x))
y=x
print("\n"+str(y))
x[1]=15
print("\n"+str(x))
x.append(12)
print("\n"+str(x)+" "+ str(y))
x=[1,'hello',(3+2j)]
print("\n"+str(x)+" "+str(x[2])+" "+str(x[0:2]))

x=[1,2,3]
y=x
x=x+[9,10]
print("\n"+str(x)+ " "+str(y))