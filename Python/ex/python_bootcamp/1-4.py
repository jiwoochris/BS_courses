def get_range(OHLCV_list):
    return OHLCV_list[1] - OHLCV_list[2]

def get_ratio(OHLCV_list):
    return OHLCV_list[3] / OHLCV_list[0] * 100

daily_bar = {'8/1':[1000, 1080, 990, 1040], '8/2':[990, 1050, 990, 995], 
             '8/3':[990, 990, 950, 960], '8/4':[970, 1010, 965, 990], '8/5':[1010, 1100, 1010, 1090]}

for i in daily_bar.keys():
    print(i)
    print(get_range(daily_bar[i]))
    print(get_ratio(daily_bar[i]))
    print()
