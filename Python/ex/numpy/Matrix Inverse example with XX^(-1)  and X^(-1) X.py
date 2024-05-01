import numpy as np
a = np.array([ [2, 8], [1,7] ])

c = np.linalg.inv(a)
d = np.linalg.inv(c)
print(c)
print(d)
