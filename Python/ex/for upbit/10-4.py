from pandas import DataFrame

data = [ [980, 990, 920, 930],
        [200, 300, 180, 180],
        [300, 500, 300, 400]]

index = ['비트코인', '리플', '이더리움']
columns = ['시가', '고가', '저가', '종가']

df = DataFrame(data, index, columns)

print(df)