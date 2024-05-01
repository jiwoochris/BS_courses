import ccxt
import pprint

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

markets = binance.load_markets()
for m in markets:
    print(m)

print(len(markets))
print(type(markets))

pprint.pprint(markets)