import pyupbit
from pandas import Series

tickers = pyupbit.get_tickers(fiat = 'KRW')
data = Series(pyupbit.get_current_price(tickers))
cond = data < 100
print(data[cond].index)