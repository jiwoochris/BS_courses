from sklearn.model_selection import train_test_split
from sklearn import datasets
from sklearn.tree import DecisionTreeRegressor, export_graphviz

import pandas as pd

lst_A = [
    ['SW', 2, 'F', 20],
    ['Math', 3, 'M', 20],
    ['Art', 3, 'F', 15],
    ['English', 3, 'M', 28],
    ['Math', 3, 'F', 26],
    ['English', 3, 'M', 17],
    ['Math', 3, 'F', 26],
    ['SW', 3, 'F', 40],
    ['SW', 3, 'M', 33],
    ['English', 3,'M', 18],
    ['Math', 3, 'M', 25],
    ['Math', 3, 'F', 30],
    ['SW', 3, 'F', 45],
    ['Art', 3, 'M', 20]
    ]

df = pd.DataFrame(lst_A, columns = ['Major', 'Year', 'Gender', 'StudyHours'])

t_features = df[df.columns[:-1]]
t_target = df[df.columns[-1]]

t_features = pd.get_dummies(data = t_features, columns = ['Major'], prefix = 'Major')
t_features = pd.get_dummies(data = t_features, columns = ['Year'], prefix = 'Year')
t_features = pd.get_dummies(data = t_features, columns = ['Gender'], prefix = 'Gender')

x_training_set, x_test_set, y_training_set, y_test_set = train_test_split(t_features, t_target, test_size=0.10, random_state=42, shuffle=True)
model = DecisionTreeRegressor(max_depth=5, random_state=0)
model.fit(x_training_set, y_training_set)

y_1 = model.predict(x_test_set)

dot_data4 = export_graphviz(model, out_file=None, 
                                filled=True, rounded=True,  
                                special_characters=True)

print(dot_data4)