import Student

if __name__ == '__main__':
    s1 = Student.Student("alex")
    s2 = Student.Student("gigi")
    s1.say_banc_to(s2)
    s2.say_banc_to(s1)
