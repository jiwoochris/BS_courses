from pandas import Series

종가 = Series([93000, 82400, 99100, 81000, 72300], ['05/14', '05/15', '05/16', '05/17', '05/18'])

cond = (80000 <= 종가) & (종가 < 90000)

print(종가[cond].index)

for date in 종가[cond].index:
    print(date)