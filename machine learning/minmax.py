import pandas as pd

from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()

X = [1400, 1600, 1700, 1875, 1100, 1550, 2350, 2450]

y = [245000, 312000, 279000, 308000, 199000, 219000, 405000, 324000]

data = pd.DataFrame(X)
data[1] = pd.DataFrame(y)


scaler.fit(data)
data = scaler.transform(data)
print(data)