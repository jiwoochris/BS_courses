import bt

from yahoo_fin import stock_info as si
import pandas as pd
import numpy as np
tickers = {'sp500':'IVV', 'cash':'SHY', 
           'sectors':
           ['QQQ', 'TLT', 'IAU', 'GSG']}

symbols = tickers['sectors']+[tickers['sp500'],tickers['cash']]

print(symbols)

data = {k : si.get_data(k) for k in symbols}

prices = pd.DataFrame.from_dict({k : v.adjclose for k,v in data.items() }).dropna()

#// Plot Performance
import matplotlib
matplotlib.use('TkAgg')
import matplotlib.pyplot as plt

#// pd.DataFrame.rebase() 함수 : 초기값 100이나 1000으로 맞춰준다!(디폴트는 100)
prices[[tickers['sp500']] + tickers['sectors']].rebase().plot()
plt.title('S&P sector performance',{'fontsize':16})
plt.legend(ncol=3)
plt.show()

class StatInfoRatio(bt.Algo):
    def __init__(self, benchmark, lookback = pd.DateOffset(months = 3), 
                lag = pd.DateOffset(days =0)):
        super(StatInfoRatio, self).__init__()
        self.benchmark = benchmark
        self.lookback = lookback
        self.lag = lag
        
    def __call__(self, target): 
        #//call해서 target.temp의 stat에 전략 넣어주면 된다
        #//나중에 뒤에서  bt.algos.SelectN (5, sort_descending = False) 이런식으로 뽑아냄
        selected = target.temp['selected']  #넣은것중에 보기 원하는 것들! loc의 열선택으로 쓰임
        t0 = target.now - self.lag
        prc = target.universe.loc[(t0 - self.lookback):t0, selected].pct_change().dropna()
        bmk = target.universe.loc[(t0 - self.lookback):t0, self.benchmark].pct_change().dropna()
        ##// Dataframe 그냥 for문하면 컬럼들 나오니까, 각 ETF에 대한 score를 stat에 담아주느듯!
        target.temp['stat'] = pd.Series({p:prc[p].calc_information_ratio(bmk) for p in prc})
        return True

backtest_result = bt.Strategy("jiwoo_backtest",
                   algos = [
                       bt.algos.RunQuarterly(),
                       bt.algos.SelectAll(),
                       bt.algos.WeighEqually(),
                       bt.algos.Rebalance()
                   ])

backtest = bt.Backtest(backtest_result, prices)
result = bt.run(backtest)
print(result.prices)

result.plot(figsize = (10, 6), legend = False)
plt.show()
