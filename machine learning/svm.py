import numpy as np
from sklearn import svm
import pandas as pd
from sklearn.model_selection import StratifiedKFold, cross_val_score


df = pd.read_csv('breast-cancer-wisconsin.data', sep=',', header=None)
df = df.replace("?", np.nan)
df = df.dropna()

X, Y = df[[1, 2, 3, 4, 5, 6, 7, 8, 9]], df[10]
cv = StratifiedKFold(n_splits=7)

# hyperparameters
kernel = 'linear', 'rbf'
C = 0.1, 1, 10
gamma = 0.001, 0.1, 1, 'scale', 'auto'

def SVC(X, Y, cv, kernel, C, gamma):

    for k in kernel:

        if k == 'linear':
            clf = svm.SVC(kernel=k)
                
            scores = cross_val_score(clf, X, Y, cv = cv)
            
            print("Linear : ", scores.mean())

        if k == 'rbf':
            for c in C:
                for g in gamma:
                    clf = svm.SVC(kernel=k, C = c, gamma = g)

                    print(clf)
                    
                    scores = cross_val_score(clf, X, Y, cv = cv)
                    
                    print("rbf : ", "C = ", c, " G : ", g, "\n", scores.mean())

SVC(X, Y, cv, kernel, C, gamma)