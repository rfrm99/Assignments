import csv
import statistics as st
from matplotlib import pyplot as plt
from pylab import legend
import datetime as dt

filename = "activity.csv"

dict = {}
dictInterval = {}
dictIntervalWeekDays = {}
dictIntervalWeekEnds = {}

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

            if (date2 % 7 == 0):
                dictIntervalWeekEnds.setdefault(interval, [])
                dictIntervalWeekEnds[interval].append(int(steps))
            else:
                dictIntervalWeekDays.setdefault(interval, [])
                dictIntervalWeekDays[interval].append(int(steps))

listWeekEndInterval = []
listWeekEndTotal = []
listWeekEndAve = []
listWeekDayInterval = []
listWeekDayTotal = []
listWeekDayAve = []

for i in dictIntervalWeekEnds.keys():
    listWeekEndInterval.append(i)
    listWeekEndTotal.append(sum(dictIntervalWeekEnds.get(i)))
    listWeekEndAve.append(st.mean(dictIntervalWeekEnds.get(i)))

for l in dictIntervalWeekDays.keys():
    listWeekDayInterval.append(l)
    listWeekDayTotal.append(sum(dictIntervalWeekDays.get(l)))
    listWeekDayAve.append(st.mean(dictIntervalWeekDays.get(l)))

plt.plot(listWeekEndAve, c="blue")
plt.plot(listWeekDayAve, c="red")
legend(["Weekend", "Weekday"])
plt.title("Total Steps Per Interval in Weekday and Weekend")
plt.xlabel("Steps per Interval")
plt.ylabel("Frequency")
plt.show()
