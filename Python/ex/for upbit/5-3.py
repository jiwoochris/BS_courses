data = [
    ('삼성전자', 15.75),
    ('LG전자', 308.67),
    ('현대차', 8.51),
    ('NAVER', 55.82)
]

for i in data :
    if i[1] < 10 :
        print(i[0])

for i in data:
    name, per = i
    if per < 10:
        print(name, per)