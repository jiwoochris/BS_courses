import numpy as np
a = np.array( [ [2, -1, 1], [1, 3, -1], [1 ,0, 2] ])
b = np.linalg.inv(a)
c = np.array( [ [-2], [10], [-8] ])
d = np.dot(b, c)
print(d)
