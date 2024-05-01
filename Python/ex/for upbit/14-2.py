import pyupbit

def williams():
    df = pyupbit.get_ohlcv("KRW-BTC")
    k = 0.5

    range = (df['high'] - df['low']) * k
    target = df['open'] + range.shift(1)

    cond = df['high'] > target
    buy = target[cond]
    sell = df['close'][cond]

    rate = sell / buy

    print(rate.cumprod().iloc[-1])

williams()