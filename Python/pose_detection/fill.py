from yahoo_fin import stock_info as si
import pandas as pd
import matplotlib
matplotlib.use('TkAgg')
import matplotlib.pyplot as plt


symbols = 'TQQQ'

print(symbols)

data = si.get_data(symbols).dropna()[ -350 : ]

data['change'] = data['adjclose'] / data['adjclose'].shift(1) - 1
data['profit'] = data['change'] * 100


print(data)


print("mine : ", data['profit'].sum())

print("buy and hold : ", (data.iloc[-1]['adjclose'] / data.iloc[0]['adjclose'] - 1) * 100)




# result.plot(figsize = (10, 6), title = 'new 60/40', legend = False)
# plt.show()

# result.display()