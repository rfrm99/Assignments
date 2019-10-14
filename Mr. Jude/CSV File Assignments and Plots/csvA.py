import csv
import statistics as st
from matplotlib import pyplot as plt
import datetime as dt

filename = "activity.csv"

dict = {}
dictInterval = {}

with open(filename) as f:
    reader = csv.reader(f)
    headerRow = next(reader)
    for row in reader:
        steps = row[0]
        if steps != "NA":
            date = row[1]
            date2 = int(dt.datetime.strptime(date, "%Y-%m-%d").day)
            interval = int(row[2])

            dict.setdefault(str(date), [])
            dict[str(date)].append(int(steps))

            dictInterval.setdefault(interval, [])
            dictInterval[interval].append(int(steps))


listTotal = []
listDate = []
listAve = []

for i in dict.keys():
    listDate.append(i)
    listTotal.append(sum(dict.get(i)))
    listAve.append(st.mean(dict.get(i)))

plt.hist(listTotal)
plt.title("Total Steps Per Day")
plt.xlabel("Steps per Day")
plt.ylabel("Frequency")
plt.show()