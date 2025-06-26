import os


def main():
    string1 = input('Care este sirul?\n')

    files = []
    while True:
        n = int(input('Mai citesti fisier? 1 - DA ; 0 - NU\n'))
        if n == 0:
            break

        numele_fisierului = input('Care e numele fisierului?\n')
        current_path = os.getcwd()
        possible_existing_file = current_path + '\\' + numele_fisierului

        if os.path.isfile(possible_existing_file):
            files.append(possible_existing_file)

    vrei_inlocuire = int(input('Vrei inlocuire la stringul initial? 1 - DA ; 0 - NU\n'))
    if vrei_inlocuire == 1:
        string_inlocuire = input('Care este sirul nou???\n')

        for file in files:
            with open(file, "r+") as f:
                read_data = f.read()

                filedata = read_data.replace(string1, string_inlocuire)
                f.seek(0, 0)
                f.write(filedata)

    else:
        files_counter = 0
        for file in files:
            with open(file, "r+") as f:
                files_counter += 1
                flag = 0
                index = 0

                print('For file', files_counter)
                for line in f:
                    index += 1
                    if string1 in line:
                        flag = 1
                        print(f'\"{string1}\"', 'found at: ', index)
                if flag == 0:
                    print(f'\"{string1}\"', 'not Found')
                print()


if __name__ == '__main__':
    main()
