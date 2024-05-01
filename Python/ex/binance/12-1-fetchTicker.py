import ccxt
import time
import datetime

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

while True:
    btc = binance.fetch_ticker(symbol)
    cur_price = btc['last']
    now = datetime.datetime.now()

    print(now, cur_price)
    time.sleep(1)