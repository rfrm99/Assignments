def findHapax(file):
    hapax_list = []
    text = ''
    with open(file, 'r') as f:
        for line in f:
            text = (line + ' ').lower()
        for word in text.split():
            x = text.split().count(word)
            if x == 1:
                hapax_list.append(word)
    print(hapax_list)
findHapax('A_Treatise_on_Fever.txt')