def average(data):
    return(sum(data)/len(data))

def deviation(data):
    dev = []
    for i in data:
        dev.append(i-average(data))
    return dev

def variance(data):
    total = 0
    for i in deviation(data):
        total += i*i

    return total / len(data)
