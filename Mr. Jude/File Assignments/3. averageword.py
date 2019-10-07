def avgwordlen(file):
    totalwords = 0
    sumofwordlen = 0
    for i in open(file):
        for y in i.split():
            totalwords += 1
            sumofwordlen += len(y)
    avg = sumofwordlen/totalwords
    return avg
avgwordlen("A_Treatise_on_Fever.txt")