def numberedLine(file, newfile):
    n = 0
    numbline = ""
    for i in open(file):
        print(i)
        n += 1
        numbline += str(n) + ". " + i
    nfile = open(newfile, 'w')
    nfile.write(numbline)
    nfile.close()

    nfile = open(newfile, 'r')
    print(nfile.read())
    nfile.close()
numberedLine("A_Treatise_on_Fever.txt", "Blanktext.txt")