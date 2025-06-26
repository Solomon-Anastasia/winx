import shelve
from person import Person
from manager import Manager

bob=Person('Bob Smith',42,30000,'sweng')
sue=Person('Sue Jones',45,40000,'music')
tom=manager('Tom Doe',50,50000)
db=shelve.open('class-shelve')
db['bob']=bob
db['sue']=sue
db['tom']=tom
db.close()

import shelve
db=shelve.open('class-shelve')
for key in db:
	print key,'=>\n ',db[key].name,db[key].pay

bob=db['bob']
print(bob.lastName())
print(db['tom'].lastName())

#o modif a val exist in zona persis
import shelve
db=shelve.open('class-shelve')
sue=db['sue']
sue.giveRaise(.25)
db['sue']=sue
tom=db['tom']
tom.giveRaise(.20)
db['tom']=tom
db.close()