import bt

from yahoo_fin import stock_info as si
import pandas as pd
import matplotlib
matplotlib.use('TkAgg')
import matplotlib.pyplot as plt

tickers = {'sectors':
           ['QQQ', 'TLT', 'IAU', 'GSG']}

symbols = tickers['sectors']

print(symbols)

data = {k : si.get_data(k) for k in symbols}

prices = pd.DataFrame.from_dict({k : v.adjclose for k,v in data.items() }).dropna()

new = bt.Strategy('new 60/40',
                    [bt.algos.SelectAll(),
                     bt.algos.WeighSpecified(QQQ = 0.6, TLT = 0.3, IAU = 0.05, GSG = 0.05),
                     bt.algos.RunQuarterly(),
                     bt.algos.Rebalance()])
backtest = bt.Backtest(new, prices)
result = bt.run(backtest)
print(result.prices)

result.plot(figsize = (10, 6), title = 'new 60/40', legend = False)
plt.show()

result.display()