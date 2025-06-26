capitole={1:5,2:46,3:52,4:87,5:90}
hexStr="3f8"
for x in capitole:
    print("Capitole "+str(x)+str(capitole[x]).rjust(15,'.'))
print("Capitol %d %15s"%(x,str(capitole[x])))
print("\nHex String: "+hexStr.upper().rjust(8,'0'))
print("\nHex String: "+hexStr.upper().ljust(8,'0'))

for x in capitole:
    print("Capitol %d %15s" %(x,str(capitole[x])))

print("\n\n Alt exercitiu : \n\n")

print("Hello {0}{1},you may have won ${2}".format("Mr.","Smith",10000))
print('This int,{0:5},was placed in a fieil of width5'.format(7))
print('This int,{0:10},was placed in a field of width 10'.format(10))
print('This float,{0:10.5},has width 10 and precision5.'.format(3.1415926))
print('This float,{0:10.5f}, is fixed at 5 decimal places.'.format(3.1415926))