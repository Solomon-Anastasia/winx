import Studenti

if __name__ == '__main__':
    s1 = Studenti.Student("Florin")
    c1 = Studenti.Colega("Andreea")
    s1.act_bad(c1)
    s1.print_state()
    s1.act_nice(c1)
    s1.print_state()
