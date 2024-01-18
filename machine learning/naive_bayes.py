fever = ['L', 'M', 'H', 'M', 'M', 'M', 'H', 'M', 'L', 'M', 'H', 'L', 'L', 'M', 'H', 'M', 'L', 'H', 'H', 'M', 'L', 'M', 'H', 'M', 'M', 'M', 'H', 'M', 'L', 'M', 'H', 'H']
sinus = ['Y', 'N', 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'Y', 'N', 'Y', 'N', 'Y', 'Y', 'N', 'N']
ache = ['Y', 'N', 'N', 'N', 'Y', 'N', 'Y', 'Y', 'Y', 'N', 'N', 'N', 'N', 'Y', 'N', 'N', 'Y', 'N', 'N', 'N', 'Y', 'N', 'Y', 'N', 'N', 'N', 'N', 'N', 'Y', 'Y', 'Y', 'N']
swell = ['Y', 'N', 'Y', 'N', 'Y', 'N', 'N', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'N', 'N', 'Y', 'Y']
headache = ['N', 'N', 'Y', 'Y', 'N', 'Y', 'Y', 'N', 'Y', 'N', 'Y', 'Y', 'N', 'N', 'Y', 'N', 'Y', 'N', 'N', 'Y', 'Y', 'Y', 'N', 'Y', 'N', 'N', 'Y', 'Y', 'Y', 'N', 'Y', 'Y']
flu = ['Y', 'N', 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'Y']

#ImportLabelEncoder
from sklearn import preprocessing
#createlabelEncoder
le=preprocessing.LabelEncoder()
#Convertstringlabelsintonumbers.

fever_encoded=le.fit_transform(fever)
sinus_encoded=le.fit_transform(sinus)
ache_encoded=le.fit_transform(ache)
swell_encoded=le.fit_transform(swell)
headache_encoded=le.fit_transform(headache)

print(fever_encoded)
print(sinus_encoded)
print(ache_encoded)
print(swell_encoded)
print(headache_encoded)

label=le.fit_transform(flu)

features= list(zip(fever_encoded, sinus_encoded, ache_encoded, swell_encoded, headache_encoded))
print(features)


#ImportGaussianNaiveBayesmodel
from sklearn.naive_bayes import GaussianNB
#CreateaGaussianClassifier
model=GaussianNB()
#Trainthemodelusingthetrainingsets
model.fit(features, label)
#PredictOutput
predicted=model.predict([[2, 1, 0, 0, 0]])
print("PredictedValue:", predicted)