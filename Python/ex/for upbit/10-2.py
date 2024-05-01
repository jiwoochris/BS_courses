from pandas import Series

저가 = Series([10, 200, 200, 400, 600])
고가 = Series([100, 300, 400, 500, 600])
cond = (고가 - 저가) >= 100

print(고가[cond])