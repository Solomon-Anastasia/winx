import FSM

if __name__ == '__main__':
    l = list(range(10))
    fsm = FSM.FSM(l)
    while fsm.do_task():
        pass
