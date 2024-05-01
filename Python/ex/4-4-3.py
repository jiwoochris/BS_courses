import pandas as pd
from matplotlib import pyplot as plt
from bs4 import BeautifulSoup
from urllib.request import Request, urlopen
import requests

url = 'https://finance.naver.com/item/sise_day.nhn?code=068270&page=1'

req = Request(url, headers={'User-Agent': 'Mozilla/5.0'})

with urlopen(req) as doc:
    html = BeautifulSoup(doc, 'lxml')
    pgrr = html.find('td', class_='pgRR')
    s = str(pgrr.a['href']).split('=')
    last_page = s[-1]
    print(last_page)

df = pd.DataFrame()
sise_url = 'https://finance.naver.com/item/sise_day.nhn?code=068270'

for page in range(1, int(last_page) + 1):
    page_url = '{}&page={}'.format(sise_url, page)
    df = df.append(pd.read_html(requests.get(page_url, headers={'User-agent': 'Mozilla/5.0'}).text)[0])

df = df.dropna()
print(df)


df = df.iloc[0:30]
df = df.sort_values(by = '날짜')

plt.title('Celltrion (close)') #오름차순으로 변경
plt.xticks(rotation = 45)
plt.plot(df['날짜'], df['종가'], 'co-')
plt.grid(color = 'gray', linestyle = '--')
plt.show()

import mplfinance as mpf

df = df.rename(columns = {'날짜' : 'Date', '시가' : 'Open', '고가' : 'High', '저가' : 'Low', '종가' : 'Close', '거래량' : 'Volume'})
df = df.sort_values(by = 'Date')
df.index = pd.to_datetime(df.Date)
df = df[ ['Open', 'High', "Low", "Close", "Volume"] ]

mpf.plot(df, title = 'Celltrion candle chart', type = 'candle')

kwargs = dict(title = 'Celltrion customized chart', type = 'candle', mav = (2, 4, 6), volume = True, ylabel = 'ohlc candles')
mc = mpf.make_marketcolors(up = 'r', down = 'b', inherit = True)
s = mpf.make_mpf_style(marketcolors = mc)
mpf.plot(df, **kwargs, style = s)

print(mpf)