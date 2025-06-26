#Modelul iterator
class FootballTeamIterator:
    def __init__(self,members):
        self.members =members
        self.index=0
    def __iter__(self):
        return self
    def __next__(self):
        if self.index <len(self.members):
            val=self.members[self.index]
            self.index +=1
            return val
        else:
            raise StopIteration()
class FootballTeam:
    def __init__(self,members):
        self.members=members
    def __iter__(self):
        return FootballTeamIterator(self.members)
def main():
    members =[]
    for x in range(1,23):
        members.append(f'jucator_nr_{str(x)}')
    members =members +['antrenor principal','antrenor secund','antrenorul cu cafelele']
    team =FootballTeam(members)
    team_it =iter(team)

    while True:
        try:
            print(next(team_it))
        except StopIteration:
            break

if __name__=='__main__':
    main()