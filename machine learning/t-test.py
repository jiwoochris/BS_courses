import numpy as np
from scipy import stats

N = 10

older = np.array([45, 38, 52, 48, 25, 39, 51, 46, 55, 46])
younger = np.array([34, 22, 15, 27, 37, 41, 24, 19, 26, 36])

## Calculate the Standard Deviation
#Calculate the variance to get the standard deviation
#For unbiased max likelihood estimate, we have to divide the var by N-1, and therefore the parameter ddof = 1
#”var” means variance, and ddof means delta degree of freedom

var_a = older.var(ddof=1)
var_b = younger.var(ddof=1)

#std deviation
s = np.sqrt((var_a + var_b)/2)

## Calculate the t-statistics
t = (older.mean() - younger.mean())/(s*np.sqrt(2/N))
## Compare with the critical t value
#degrees of freedom
df = 2*N - 2
#p value after comparison with the t
p = 1 - stats.t.cdf(t,df=df)
print("t = " + str(t))
print("p = " + str(2*p))


### We can see that after comparing the t statistic with the critical t value (computed internally) we get a good p value of 0.0005 and thus we reject the null hypothesis. The means of the two distributions are different and statistically significant.
## Cross check with the internal SciPy function
## a, b are datasets generated earlier on “Code (2/5)”
t2, p2 = stats.ttest_ind(older, younger)
print("t = " + str(t2))
print("p = " + str(p2))
## Use scipy.stats.ttest_rel() for paired-samples test