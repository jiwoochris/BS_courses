#define NumPy array of income values
import numpy as np

#define function to calculate Gini coefficient
def gini(x):
    total = np.sum(x)

    one = 1

    for i in x:
        one -= (i/total)**2

    return one

def w(x):
    total = np.sum(x)
    return x / total
    
# incomes = np.array([2, 4])

# #calculate Gini coefficient for array of incomes
# gini_index = gini(incomes)

# print(gini_index)




incomes = np.array([9.80420567815628, 5.451081150953975])
weight = np.array([0.5, 0.5])
weight = w(weight)

print(np.sum(incomes * weight))

print(8.455465567263797 - 7.627643414555127)