점수 = {
    "국어" : 80,
    "영어" : 75,
    "수학" : 55
}
print(type(점수.values))

평균 = sum(list(점수.values())) / len(점수)
print(평균)