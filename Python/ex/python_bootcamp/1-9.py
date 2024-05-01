하림 = 136480
종목코드 = "A" + str(하림)]
print(종목코드)


print(종목코드[1:])


전날종가 = 9300
오늘시가 = 10100

전날종가 < 오늘시가
전날종가 == 오늘시가
전날종가 <= 오늘시가
전날종가 >= 오늘시가
전날종가 > 오늘시가


날짜_list = ['8/1', '8/2', '8/3', '8/4', '8/5']
전일종가_dict = {'8/1':9900, '8/2':10200, '8/3':9300, '8/4':8900, '8/5':9500} # 9900원은 8/1 기준 전일의 종가입니다
오늘시가_dict = {'8/1':10100, '8/2':9500, '8/3':9100, '8/4':9200, '8/5':9900}

for i in 날짜_list:
    if 전일종가_dict[i] < 오늘시가_dict[i]:
        print("매수")

    else:
        print("매도")


삼성전자주가_list = [80000, 79000, 79500, 80200, 80000, 79600, 79800, 80100]
현재잔고 = 350000


# 문제1

i = 0

while i < 8:
    if 현재잔고 >= 삼성전자주가_list[i]:
        print("매수")
        현재잔고 -= 삼성전자주가_list[i]
    else:
        print("잔고부족")
    
    i += 1


# 문제2

분할매수 = 0

for p in 삼성전자주가_list:
    분할매수 += p

분할매수 /= len(삼성전자주가_list)

print(분할매수)
print(80000)


잘못된주가_list = [800000, 801000, 802000, 801000, 800000, 799000, 798000, 797000, 799000, 800000]

print( [(p / 10) for p in 잘못된주가_list])


# 문제1

def get_range(OHLCV_list):
    return OHLCV_list[1] - OHLCV_list[2]


# 문제2

def get_ratio(OHLCV_list):
    return OHLCV_list[3] / OHLCV_list[0] * 100


# 문제3
daily_bar = {'8/1':[1000, 1080, 990, 1040], '8/2':[990, 1050, 990, 995], 
             '8/3':[990, 990, 950, 960], '8/4':[970, 1010, 965, 990], '8/5':[1010, 1100, 1010, 1090]}

for i in daily_bar.keys():
    print(i)
    print(get_range(daily_bar[i]))
    print(get_ratio(daily_bar[i]))
    print()


# mean_close_price 함수는 아래의 두 경우를 모두 풀 수 있어야 합니다

def mean_close_price(t):
    mean = 0
    for i in t:
        mean += i

    mean /= len(t)
    
    return mean

print(mean_close_price([8000,9000,8900,8600]))
print(mean_close_price([1000,1005,1005,1010,1015,1020,1010,1025,1000,1010,1010,1000]))


# 문제 1
virtual_signal_dict = [{'시간':'09:02:22', '종목명':'삼성전자', '현재가':79000, '매매시그널':'매수'},
                      {'시간':'11:11:55', '종목명':'푸드나무', '현재가':35000, '매매시그널':'매도'},
                      {'시간':'11:31:12', '종목명':'아이에이', '현재가':1600, '매매시그널':'매수'},
                      {'시간':'13:44:01', '종목명':'하이닉스', '현재가':102000, '매매시그널':'매수'},
                      {'시간':'15:09:26', '종목명':'심성전자', '현재가':79000, '매매시그널':'매수'},
                      {'시간':'15:26:15', '종목명':'HMM', '현재가':37000, '매매시그널':'매도'}]

print(f"매매 시그널 포착 : {virtual_signal_dict[0]['시간']} {virtual_signal_dict[0]['종목명']} {virtual_signal_dict[0]['현재가']} {virtual_signal_dict[0]['매매시그널']}")


# 문제 2

for i in virtual_signal_dict:
    print(f"매매 시그널 포착 : {i['시간']} {i['종목명']} {i['현재가']} {i['매매시그널']}")

    inp = input(f"매매 시그널 포착 : {i['시간']} {i['종목명']} {i['현재가']} {i['매매시그널']} 매매하시겠습니까? : ")

    if inp == "매수":
        print("매수되었습니다")
    elif inp == "매도":
        print("매도되었습니다")


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


minute_data = {1520: [55500, 56000, 55000, 55200],
               1521: [56000, 56600, 54900, 55500],
               1522: [54900, 55600, 54600, 55500],
               1523: [],
               1524: [56200, 57400, 55900, 56800],
               1525: [58400, 58600, 57400, 58600]}

for i in minute_data.keys():
    try:
        if minute_data[i][3] >= 55000:
            print("매수 시그널")
    except(IndexError):
        print('데이터 형식 에러')
