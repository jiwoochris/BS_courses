from statistics import pstdev


list = [20, 28, 17, 33, 18, 25, 20]

dev = pstdev(list)
len = len(list) / 14

print(dev, " / ", len)