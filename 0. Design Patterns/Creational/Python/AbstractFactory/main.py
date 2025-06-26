from ModernFurnitureFactory import ModernFurnitureFactory
from RusticFurnitureFactory import RusticFurnitureFactory


def main():
    farica_moderna = ModernFurnitureFactory()
    farica_rustica = RusticFurnitureFactory()

    scaun1 = farica_moderna.create_chair()
    scaun2 = farica_rustica.create_chair()

    masa1 = farica_moderna.create_table()
    masa2 = farica_rustica.create_table()

    print(scaun1)
    print(scaun2)
    print(masa1)
    print(masa2)


if __name__ == '__main__':
    main()
