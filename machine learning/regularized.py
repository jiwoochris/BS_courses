import pandas as pd
import numpy as np


# dataset : Google Stock Prediction
data = pd.read_csv('GOOG.csv', sep=',')
# print(data)


data_shift = data.shift(-1)
# print(data_shift)

data['target'] = data_shift['close']

# print(data)

# replace the value of ? to NaN
data.replace("?", np.NaN, inplace = True)
# print(data.isna().sum())

# drop the row which has NaN value
data.dropna(inplace = True)


from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()

data = data.iloc[:, [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14]]

scaler.fit(data)
data = scaler.transform(data)


X = data[:, 0:-1]
# print(X)

y = data[:, -1] # target feature
# print(y)


# OLS(Linear)

from sklearn.linear_model import LinearRegression
from sklearn.model_selection import cross_val_score

reg = LinearRegression().fit(X, y)

MSE5 = cross_val_score(reg, X, y, scoring='neg_mean_squared_error', cv=5)
mean_MSE = np.mean(MSE5)

print("OLS(Linear) : ", mean_MSE)



# Ridge

from sklearn.model_selection import GridSearchCV
from sklearn.linear_model import Ridge

ridge = Ridge(normalize=True)
parameters = {'alpha' : [1e-15, 1e-10, 1e-8, 1e-4, 1e-3, 1e-2, 1, 5, 10, 20]}

ridge_reg = GridSearchCV(ridge, parameters, scoring='neg_mean_squared_error', cv=5)
ridge_reg.fit(X, y)

print(ridge_reg.best_params_)
print("Ridge : ", ridge_reg.best_score_)


# Lasso

from sklearn.linear_model import Lasso
lasso = Lasso(normalize=True, tol=1e-2)
parameters = {'alpha' : [1e-15, 1e-10, 1e-8, 1e-4, 1e-3, 1e-2, 1, 5, 10, 20]}
lasso_reg = GridSearchCV(lasso, parameters, scoring='neg_mean_squared_error', cv=5)
lasso_reg.fit(X, y)

print(lasso_reg.best_params_)
print("Lasso : ", lasso_reg.best_score_)


# ElasticNet

from sklearn.linear_model import ElasticNet
elasticNet = ElasticNet(normalize=True, tol=1e-2)
parameters = {'alpha' : [1e-15, 1e-10, 1e-8, 1e-4, 1e-3, 1e-2, 1, 5, 10, 20]}
elastic_reg = GridSearchCV(elasticNet, parameters, scoring='neg_mean_squared_error', cv=5)
elastic_reg.fit(X, y)

print(elastic_reg.best_params_)
print("ElasticNet : ", elastic_reg.best_score_)