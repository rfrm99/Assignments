import matplotlib.pyplot as plt
import os

os.chdir('/Users/Gebruiker/Documents/GitHub/Assignments/Mr. Stavin/Bar Plot')
filename = "indo.txt"

with open(filename, 'r') as f:
    string = f.read()
    string_list = string.split()
    string_dict = {}

for word in string_list:
    if word in string_dict:
        string_dict[word] += 1
    else:
        string_dict[word] = 1

sortedDict = {}
listofvalues = []

for key, value in string_dict.items():
    listofvalues.append(value)

listofvalues.sort(reverse = True)

for value in listofvalues:
    for key in string_dict:
        if value == string_dict[key]:
            sortedDict[key] = value


count_list = sortedDict.values()
indentation = list(range(1,len(count_list)+1))

b1 = plt.barh(indentation, count_list,color=('green'))
plt.yticks(indentation, sortedDict.keys())
plt.title("The amount of words in a string")
plt.xlabel("Amount of word")
plt.ylabel("Words")
plt.show