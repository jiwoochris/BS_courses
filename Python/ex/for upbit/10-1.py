from numpy.core.arrayprint import set_printoptions
from pandas import Series

icecream = [500, 800, 200]

s = Series(data = icecream, index = ['메로나', '누가바', '빠삐코'])

print(s)