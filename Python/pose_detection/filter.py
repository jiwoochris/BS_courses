import numpy as np
import matplotlib.pyplot as plt

num_samples = 180
desired_mean = 14
desired_std_dev = 8.0

samples = np.random.normal(loc=desired_mean, scale=desired_std_dev, size=num_samples)

print(samples)

x = np.arange(0, num_samples)
y = samples

# before filtering
plt.plot(x, y)
plt.show()



# kalman filter
class KalmanFilter(object):
    def __init__(self, F = None, B = None, H = None, Q = None, R = None, P = None, x0 = None):

        if(F is None or H is None):
            raise ValueError("Set proper system dynamics.")

        self.n = F.shape[1]
        self.m = H.shape[1]

        self.F = F
        self.H = H
        self.B = 0 if B is None else B
        self.Q = np.eye(self.n) if Q is None else Q
        self.R = np.eye(self.n) if R is None else R
        self.P = np.eye(self.n) if P is None else P
        self.x = np.zeros((self.n, 1)) if x0 is None else x0

    def predict(self, u = 0):
        self.x = np.dot(self.F, self.x) + np.dot(self.B, u)
        self.P = np.dot(np.dot(self.F, self.P), self.F.T) + self.Q
        return self.x

    def update(self, z):
        y = z - np.dot(self.H, self.x)
        S = self.R + np.dot(self.H, np.dot(self.P, self.H.T))
        K = np.dot(np.dot(self.P, self.H.T), np.linalg.inv(S))
        self.x = self.x + np.dot(K, y)
        I = np.eye(self.n)
        self.P = np.dot(np.dot(I - np.dot(K, self.H), self.P), 
        	(I - np.dot(K, self.H)).T) + np.dot(np.dot(K, self.R), K.T)




dt = 1.0/60
F = np.array([[1, dt, 0], [0, 1, dt], [0, 0, 1]])
H = np.array([1, 0, 0]).reshape(1, 3)
Q = np.array([[0.05, 0.05, 0.0], [0.05, 0.05, 0.0], [0.0, 0.0, 0.0]])
R = np.array([0.5]).reshape(1, 1)

x = np.arange(0, num_samples)
measurements = samples

kf = KalmanFilter(F = F, H = H, Q = Q, R = R)
predictions = []

for z in measurements:
    predictions.append(np.dot(H,  kf.predict())[0])
    kf.update(z)

plt.plot(range(len(measurements)), measurements, label = 'Measurements')
plt.plot(range(len(predictions)), np.array(predictions), label = 'Kalman Filter Prediction')

plt.axhline(y=-26.1, color='r', linewidth=0.5)
plt.axhline(y=-13.7, color='r', linewidth=0.5)
plt.axhline(y=2.6, color='b', linewidth=0.5)
plt.axhline(y=11.2, color='b', linewidth=0.5)
plt.axhline(y=22.7, color='r', linewidth=0.5)
plt.axhline(y=41.1, color='r', linewidth=0.5)

plt.axvline(x=x[-60], color='r', linestyle=':', linewidth=1)

plt.legend()
plt.show()




def judgement(sample):
    # get last 60 seconds data
    recent_1min = sample[-60:]

    # get mean from data
    x = np.mean(recent_1min)

    if x > 26.1:
        return "심한 안짱걸음"
    elif -26.1 <= x <= -13.7:
        return "안짱걸음"
    elif -13.7 <= x <= 2.6:
        return "약한 안짱걸음"
    elif 2.6 <= x <= 11.2:
        return "정상 걸음"
    elif 11.2 <= x <= 22.7:
        return "약한 팔자걸음"
    elif 22.7 <= x <= 41.1:
        return "팔자걸음"
    elif 41.1 <= x:
        return "강한 팔자걸음"

print("Your gait : ", judgement(predictions))
