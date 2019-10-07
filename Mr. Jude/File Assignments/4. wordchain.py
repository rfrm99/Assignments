def longestwordchain(file):
    pokemonnames = []
    storage = []
    loop = 0

    for i in open(file):
        for y in i.split():
            pokemonnames.append(y)

    for i in range(len(pokemonnames)):
        wordchain = []
        usedname = []
        wordchain.append(pokemonnames[i])
        x = wordchain[-1][-1]
        while loop < 70:
            for name in pokemonnames:
                if x == name[0]:
                    wordchain.append(name)
                    usedname.append(name)
                    pokemonnames.remove(name)
                    x = name[-1]
            loop += 1
        loop = 0
        storage.append(wordchain)
        for used in usedname:
            pokemonnames.append(used)

    print(max(storage, key=len))
longestwordchain("pokemonname.txt")