import pyupbit

df = pyupbit.get_ohlcv("KRW-BTC")

df['range'] = df['high'] -df['low']

k = 0.5

df['range'] = k * df['range']
df['target'] = df['open'] + df['range'].shift(1)

cond = df['high'] >= df['target']

df['buy'] = df.loc[cond, 'target']
df['sell'] = df.loc[cond, 'close']

df['return'] = df['sell'] / df['buy']


print(df[cond])
print(df)
print(df[cond]['return'].cumprod())