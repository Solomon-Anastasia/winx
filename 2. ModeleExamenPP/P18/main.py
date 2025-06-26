from functional import seq
import sys

if __name__ == '__main__':
    args=sys.argv[1:]
    i=0
    if len(sys.argv)<3 or sys.argv[1][0]!='-':
        print("Parametri invalizi!\nParam1: -sir_de_cautat\nParam2: -sir_care_inlocuieste cel cautat(poate lipsi)\nRestul:file in care se face cautare")
        sys.exit(1)
    files=seq(args).filter(lambda it:it[0]!='-').list()
    for file in files:
        lines=open(file,'r').readlines()
        indexes=[]
        for index,line in enumerate(lines):
            if line.count(args[0][1:])>0:
                indexes.append(index)
        print(f"File: {file}, lines with string: {indexes}")
        if len(indexes)>0 and args[1][0]=='-':
            newLines=[]
            for line in lines:
                newLines.append(line.replace(args[0][1:],args[1][1:]))
            opened=open(file,'w')
            opened.writelines(newLines)
            opened.close()