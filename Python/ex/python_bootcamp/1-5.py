# mean_close_price 함수는 아래의 두 경우를 모두 풀 수 있어야 합니다

def mean_close_price(t):
    mean = 0
    for i in t:
        mean += i

    mean /= len(t)
    
    return mean

print(mean_close_price([8000,9000,8900,8600]))
print(mean_close_price([1000,1005,1005,1010,1015,1020,1010,1025,1000,1010,1010,1000]))