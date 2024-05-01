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

symbol = "BTC/USDT"
market = binance.market(symbol)
leverage = 3

resp = binance.fapiPrivate_post_leverage({
    'symbol' : market['id'],
    'leverage' : leverage
})

order = binance.create_market_buy_order(
    symbol = symbol,
    amount = 0.001
)