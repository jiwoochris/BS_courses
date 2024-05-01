import numpy as np
a = np.array( [ [0, 1, 0], [1, 0, 0], [0 ,0, 1] ])
for i in range(2,11):
    c= np.linalg.matrix_power(a, i)
    print("A^", i)
    print(c)


