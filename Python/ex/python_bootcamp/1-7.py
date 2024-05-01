# 문제 1
class DataInformation:
    
    def __init__(self, OHLCV_list): # OHLCV_list 예시 : [10000,11400, 9900, 11000, 21928455]
        self.Open = OHLCV_list[0]
        self.High = OHLCV_list[1]
        self.Low = OHLCV_list[2]
        self.Close = OHLCV_list[3]
        self.Volume = OHLCV_list[4]

    def Price_range(self):
        return self.High / self.Low * 100

    def Daily_return(self):
        return self.Close / self.Open * 100

stock_info = {'현대건설':[44400, 44850, 43100, 43250, 886166], '카카오':[463000, 477000, 461000, 465000, 698996],
             '셀트리온':[326000, 333000, 318000, 329000, 962484], '하이트진로':[33950, 34200, 33500, 33600, 345566],
             'LG전자':[148500, 167000, 146500, 167000, 10340439], 'SK하이닉스':[129000, 133500, 128500, 133000, 6791044],
             'NAVER':[316500, 326000, 316000, 322500, 1941446], '아모레퍼시픽':[246000, 248000, 235000, 238000, 423762],
             '넷마블':[126500, 132000, 125500, 131500, 448819], '강원랜드':[24750, 25200, 24300, 24350, 1052458]}

range = {}
daily = {}

for i in stock_info.keys():
    data = DataInformation(stock_info[i])
    range[i] = data.Price_range()
    daily[i] = data.Daily_return()

print(sorted(range.items(), key=lambda x: x[1])[-3:])
print(sorted(daily.items(), key=lambda x: x[1])[-3:])