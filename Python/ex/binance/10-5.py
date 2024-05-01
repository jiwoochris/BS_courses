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

orderbook = binance.fetch_order_book("BTC/USDT")
asks = orderbook['asks']
bids = orderbook['bids']
print(asks[0])
print(bids[0])

#print(asks)
#print(bids)