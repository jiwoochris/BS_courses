import random

i=0

while i<6:
    number = random.randint(1,45)
    print(number)
    i += 1

lotto=[]

while len(lotto) != 6:
    number = random.randint(1,45)
    if number not in lotto:
        lotto.append(number)

print(lotto)
