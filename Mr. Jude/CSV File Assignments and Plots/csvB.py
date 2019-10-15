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


listInterval = []
listTotal = []
listAve = []

for i in dictInterval.keys():
    listInterval.append(i)
    listTotal.append(sum(dictInterval.get(i)))
    listAve.append(st.mean(dictInterval.get(i)))

plt.plot(listAve)
plt.title("Average Steps Per Interval")
plt.xlabel("Steps per Interval")
plt.ylabel("Frequency")
plt.show()

maxValue = max(listAve)

for key, value in dictInterval.items():
    if maxValue == st.mean(value):
        print("The interval with the maximum number of steps is: " + str(key))