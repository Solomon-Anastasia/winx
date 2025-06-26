from FactoryProducer import FactoryProducer
if __name__ == '__main__':
    factoryProducer = FactoryProducer()
    elitefact = factoryProducer.getHandler("Elite")
    workerfact = factoryProducer.getHandler("HappyWorkerFactory")

    ceo1 = elitefact.getHandler("CEO")
    ceo2 = elitefact.getHandler("CEO")

    ex1 = elitefact.getHandler("Executive")
    ex2 = elitefact.getHandler("Executive")

    man1 = elitefact.getHandler("Manager")
    man2 = elitefact.getHandler("Manager")

    work1 = workerfact.getHandler("HappyWorker")
    work2 = workerfact.getHandler("HappyWorker")


    ceo1.SetRight(ex1)
    ex1.SetVertical(ex2)
    ex1.SetRight(man1)

    man1.SetRight(work1)
    man1.SetVertical(man2)


    ceo2.SetVertical(ceo1)

    ex2.SetLeft(ceo2)
    ex2.SetRight(man2)

    man2.SetLeft(ex2)
    man2.SetRight(work2)


    ceo1.handleRequest("right","2:Request")

    #man2.handleRequest("right", "2:Alt Request")

    #work1.handleRequest("right","9:Request eronat")
