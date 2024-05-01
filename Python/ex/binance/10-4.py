import ccxt
import pprint
import pandas as pd

with open("binance_key.txt") as f:
    lines = f.readlines()
    api_key = lines[0].strip()
    secret = lines[1].strip()

binance = ccxt.binance(config = {
    'apiKey' : api_key,
    'secret' : secret,
    'enableRateLimit':True,
    'options' : {
        'defaultType' : 'future'
    }
})

btc_ohlcv = binance.fetch_ohlcv(symbol = "BTC/USDT", timeframe = '1d', since = None, limit = 10)

df = pd.DataFrame(btc_ohlcv, columns = ['datetime', 'open', 'high', 'low', 'close', 'volume'])
df['datetime'] = pd.to_datetime(df['datetime'], unit = 'ms')
df.set_index('datetime', inplace = True)
print(df)