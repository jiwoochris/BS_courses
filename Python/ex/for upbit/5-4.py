portfolio = {
    'BTC':[100,120], 'XRP':[600,500], 'ETH':[1000,1100]
}

for k, v in portfolio.items():
    if v[0]*1.03 < v[1]:
        print(k)