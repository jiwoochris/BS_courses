import pandas as pd
import numpy as np
from pykrx import stock


top_10 = {'삼성전자':'005930', 'SK하이닉스':'000660', 'NAVER':'035420', '삼성전자우':'005935',
          'LG화학':'051910', '현대차':'005380', '삼성바이오로직스':'207940', '삼성SDI':'006400',
          '카카오':'035720','셀트리온':'068270'}

import time

result = pd.DataFrame()

for ticker in top_10.values():
    df = stock.get_market_ohlcv_by_date("20180101", "20210630", ticker)
    df = df['종가'].fillna(method='ffill')

    result = pd.concat([result, df],axis=1)

    time.sleep(1)

result.columns = top_10.keys()

result = np.log(result / result.shift(1))
result = result.dropna()

print(result.shape)

cov = np.cov(result.T)

print(cov)
print(cov.shape)