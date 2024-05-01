cur = {'BTC':600, 'XRP': 6}

def update(price):
    price['BTC'] = 500
    price['XRP'] = 5

update(cur)
print(cur)