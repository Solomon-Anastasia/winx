class Student:
    def __init__(self,name,hours,qpoints):
        self.name=name
        self.hours=hours
        self.qpoints=qpoints
    def getName(self):
        return self.name
    def getHours(self):
        return self.hours
    def getQPoints(self):
        return self.qpoints
    def gpa(self):
        return self.qpoints/self.hours

def makeStudent(infoStr):
    name,hours,qpoints=infoStr.split("\t")
    return Student(name,hours,qpoints)

def main():    # Are ceva erori ciudate
    filename=input("Fisierul cu notele: ")
    try:
        infile=open(filename,'r')
        best =makeStudent(infile.readline())
        for line in infile:
            s = makeStudent(line)
            if s.gpa() > best.gpa():
                best=s
        infile.close()
    except FileNotFoundError:
        print("Erroare deschidere fisier")
    print("Tcel mai bun student este:",best.getName())
    print("Ore: ",best.getHours())
    print("GPA: ",best.getgpa())

main()