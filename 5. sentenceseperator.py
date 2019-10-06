def newline(file):
    punctuations='.?!'
    titles = ['Mr','Mrs','Dr']
    for line in open(file):
        for j in range(len(line) - 1):
            if line[j - 2 : j] in titles or line[j - 3: j] in titles:
                print(line[j], end='')
            elif (line[j] in punctuations) and line[j + 1] == ' ' and line[j + 2].isupper():
                print(line[j], end='\n')
            else:
                print(line[j], end='')

newline('Mr.Miyagi.txt')