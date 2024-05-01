from pandas_datareader import data as pdr
import yfinance as yf
yf.pdr_override()

import matplotlib.pyplot as plt

dow = pdr.get_data_yahoo("^DJI", '2000-01-04')
kospi = pdr.get_data_yahoo("^KS11", '2000-01-04')

d = (dow.Close / dow.Close.loc['2000-01-04']) * 100
k = (kospi.Close / kospi.Close.loc['2000-01-04']) * 100

plt.figure( figsize = (9, 5))
plt.plot(dow.index, d, 'r--', label = 'Dow Jones Industrial')
plt.plot(kospi.index, k, 'b', label = "KOSPI")
plt.grid(True)
plt.legend(loc = 'best')
plt.show()

import pandas as pd

df = pd.DataFrame( {"DOW" : dow['Close'], "KOSPI" : kospi["Close"]} )
df = df.fillna(method = 'bfill')
df = df.fillna(method = 'ffill')

plt.figure( figsize = (7, 7))
plt.scatter(df['DOW'], df['KOSPI'], marker = '.')
plt.xlabel('Dow Jones Industrial Average')
plt.ylabel('KOSPI')
plt.show()


from scipy import stats
regr = stats.linregress(df["DOW"], df["KOSPI"])
print(regr)

print(df.corr())

r_value = df['DOW'].corr(df['KOSPI'])
r_squared = r_value ** 2
print(r_squared)


df = pd.DataFrame( {"X" : dow['Close'], "Y" : kospi["Close"]} )
df = df.fillna(method = 'bfill')
df = df.fillna(method = 'ffill')

regr = stats.linregress(df.X, df.Y)
regr_line = f'Y = {regr.slope : .2f} * X + {regr.intercept : .2f}'

plt.figure(figsize = (7, 7))
plt.plot(df.X, df.Y, '.')
plt.plot(df.X, regr.slope * df.X + regr.intercept, 'r')
plt.legend( ['DOW x KOSPI', regr_line] )
plt.title(f'DOW x KOSPI (R = {regr.rvalue: .2f})')
plt.xlabel('Dow Jones Industrial Average')
plt.ylabel('KOSPI')
plt.show()

tlt = pdr.get_data_yahoo("TLT", '2002-07-30')
t = (tlt.Close / tlt.Close.loc['2002-07-30']) * 100

df = pd.DataFrame( {"X" : tlt['Close'], "Y" : kospi["Close"]} )
df = df.fillna(method = 'bfill')
df = df.fillna(method = 'ffill')

regr = stats.linregress(df.X, df.Y)
regr_line = f'Y = {regr.slope : .2f} * X + {regr.intercept : .2f}'

plt.figure(figsize = (7, 7))
plt.plot(df.X, df.Y, '.')
plt.plot(df.X, regr.slope * df.X + regr.intercept, 'r')
plt.legend( ['TLT x KOSPI', regr_line] )
plt.title(f'TLT x KOSPI (R = {regr.rvalue: .2f})')
plt.xlabel('TLT Average')
plt.ylabel('KOSPI')
plt.show()