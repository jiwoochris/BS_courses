import re
import pandas as pd

pattern = r"(\d{2}:\d{2}:\d{2}\.\d{3}) -> (.*): (-?\d+\.?\d*)"




# 정상 걸음

file_name = "오른발.xlsx"

# read an excel and convert it into a dataframe
normal_data_frame = pd.read_excel(file_name)

# Create a DataFrame
normal_df = pd.DataFrame(columns=['Time', 'Sensor Name', 'Value'])

for index, row in normal_data_frame.iterrows():

    matches = re.match(pattern, row['오른발 정상걸음'])

    if matches:
        time = matches.group(1)
        sensor_name = matches.group(2)
        value = matches.group(3)

        # An example of data to append
        data_dict = {'Time': time, 'Sensor Name': sensor_name, 'Value': value}

        # Convert the dictionary to a DataFrame
        data_df = pd.DataFrame([data_dict])

        # Append row to the dataframe
        normal_df = pd.concat([normal_df, data_df], ignore_index=True)

        print(f"Time: {time}, Sensor Name: {sensor_name}, Value: {value}")



# Filter the DataFrame
Gyro = normal_df[normal_df['Sensor Name'] == 'Gyro sensor ']
Force_1 = normal_df[normal_df['Sensor Name'] == 'Force sensor 1 ']
Force_2 = normal_df[normal_df['Sensor Name'] == 'Force sensor 2 ']
Force_3 = normal_df[normal_df['Sensor Name'] == 'Force sensor 3 ']
Force_4 = normal_df[normal_df['Sensor Name'] == 'Force sensor 4 ']







# 안장 걸음

file_name = "오른발 안장걸음.xlsx"

# read an excel and convert it into a dataframe
in_data_frame = pd.read_excel(file_name)

# Create a DataFrame
in_df = pd.DataFrame(columns=['Time', 'Sensor Name', 'Value'])

for index, row in in_data_frame.iterrows():

    matches = re.match(pattern, row['오른발 안장걸음'])

    if matches:
        time = matches.group(1)
        sensor_name = matches.group(2)
        value = matches.group(3)

        # An example of data to append
        data_dict = {'Time': time, 'Sensor Name': sensor_name, 'Value': value}

        # Convert the dictionary to a DataFrame
        data_df = pd.DataFrame([data_dict])

        # Append row to the dataframe
        in_df = pd.concat([in_df, data_df], ignore_index=True)

        print(f"Time: {time}, Sensor Name: {sensor_name}, Value: {value}")



# Filter the DataFrame
in_Gyro = in_df[in_df['Sensor Name'] == 'Gyro sensor ']
in_Force_1 = in_df[in_df['Sensor Name'] == 'Force sensor 1 ']
in_Force_2 = in_df[in_df['Sensor Name'] == 'Force sensor 2 ']
in_Force_3 = in_df[in_df['Sensor Name'] == 'Force sensor 3 ']
in_Force_4 = in_df[in_df['Sensor Name'] == 'Force sensor 4 ']













# 팔자 걸음


file_name = "오른발 팔자걸음.xlsx"

# read an excel and convert it into a dataframe
out_data_frame = pd.read_excel(file_name)

# Create a DataFrame
out_df = pd.DataFrame(columns=['Time', 'Sensor Name', 'Value'])

for index, row in out_data_frame.iterrows():

    matches = re.match(pattern, row['오른발 팔자걸음'])

    if matches:
        time = matches.group(1)
        sensor_name = matches.group(2)
        value = matches.group(3)

        # An example of data to append
        data_dict = {'Time': time, 'Sensor Name': sensor_name, 'Value': value}

        # Convert the dictionary to a DataFrame
        data_df = pd.DataFrame([data_dict])

        # Append row to the dataframe
        out_df = pd.concat([out_df, data_df], ignore_index=True)

        print(f"Time: {time}, Sensor Name: {sensor_name}, Value: {value}")



# Filter the DataFrame
out_Gyro = out_df[out_df['Sensor Name'] == 'Gyro sensor ']
out_Force_1 = out_df[out_df['Sensor Name'] == 'Force sensor 1 ']
out_Force_2 = out_df[out_df['Sensor Name'] == 'Force sensor 2 ']
out_Force_3 = out_df[out_df['Sensor Name'] == 'Force sensor 3 ']
out_Force_4 = out_df[out_df['Sensor Name'] == 'Force sensor 4 ']



import matplotlib.pyplot as plt

# # Plot the data
# # plt.plot(pd.to_datetime(Gyro['Time']), pd.to_numeric(Gyro['Value']))
# # plt.plot(pd.to_datetime(in_Gyro['Time']), pd.to_numeric(in_Gyro['Value']))
# # plt.plot(pd.to_datetime(out_Gyro['Time']), pd.to_numeric(out_Gyro['Value']))


# plt.plot(pd.to_datetime(Force_1['Time']), pd.to_numeric(Force_1['Value']), label="f1")
# plt.plot(pd.to_datetime(Force_2['Time']), pd.to_numeric(Force_2['Value']), label="f2")
# plt.plot(pd.to_datetime(Force_3['Time']), pd.to_numeric(Force_3['Value']), label="f3")
# plt.plot(pd.to_datetime(Force_4['Time']), pd.to_numeric(Force_4['Value']), label="f4")
# plt.xlabel('Time')
# plt.ylabel('Value')
# plt.title('Value over Time')

# # Create a legend
# plt.legend()

# plt.show()






import numpy as np

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


def adjust_Kalman_Filter(data):

    dt = 1.0/60
    F = np.array([[1, dt, 0], [0, 1, dt], [0, 0, 1]])
    H = np.array([1, 0, 0]).reshape(1, 3)
    Q = np.array([[0.05, 0.05, 0.0], [0.05, 0.05, 0.0], [0.0, 0.0, 0.0]])
    R = np.array([0.5]).reshape(1, 1)

    measurements = pd.to_numeric(data)

    kf = KalmanFilter(F = F, H = H, Q = Q, R = R)
    predictions = []

    for z in measurements:
        predictions.append(np.dot(H,  kf.predict())[0])
        kf.update(z)

    # print(kf)
    # print(predictions)

    return predictions

# predictions = adjust_Kalman_Filter(out_Gyro['Value'])

f1 = adjust_Kalman_Filter(Force_1['Value'])
f2 = adjust_Kalman_Filter(Force_2['Value'])
f3 = adjust_Kalman_Filter(Force_3['Value'])
f4 = adjust_Kalman_Filter(Force_4['Value'])


plt.plot(f1, label="f1")
plt.plot(f2, label="f2")
plt.plot(f3, label="f3")
plt.plot(f4, label="f4")

plt.xlabel('Time')
plt.ylabel('Value')
# plt.title('Original data vs Kalman Filter')

plt.legend()

plt.show()
