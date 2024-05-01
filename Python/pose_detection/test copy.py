import re
import pandas as pd

file_name = "오른발 팔자걸음.xlsx"

# read an excel and convert it into a dataframe
data_frame = pd.read_excel(file_name)


pattern = r"(\d{2}:\d{2}:\d{2}\.\d{3}) -> (.*): (-?\d+\.?\d*)"




# Create a DataFrame
df = pd.DataFrame(columns=['Time', 'Sensor Name', 'Value'])





for index, row in data_frame.iterrows():

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
        df = pd.concat([df, data_df], ignore_index=True)

        print(f"Time: {time}, Sensor Name: {sensor_name}, Value: {value}")





# Filter the DataFrame
Gyro = df[df['Sensor Name'] == 'Gyro sensor ']
Force_1 = df[df['Sensor Name'] == 'Force sensor 1 ']
Force_2 = df[df['Sensor Name'] == 'Force sensor 2 ']
Force_3 = df[df['Sensor Name'] == 'Force sensor 3 ']
Force_4 = df[df['Sensor Name'] == 'Force sensor 4 ']



print(Gyro)


import matplotlib.pyplot as plt

# Plot the data
plt.plot(pd.to_datetime(Gyro['Time']), pd.to_numeric(Gyro['Value']))
# plt.plot(pd.to_datetime(Force_1['Time']), pd.to_numeric(Force_1['Value']))
# plt.plot(pd.to_datetime(Force_2['Time']), pd.to_numeric(Force_2['Value']))
# plt.plot(pd.to_datetime(Force_3['Time']), pd.to_numeric(Force_3['Value']))
# plt.plot(pd.to_datetime(Force_4['Time']), pd.to_numeric(Force_4['Value']))
plt.xlabel('Time')
plt.ylabel('Value')
plt.title('Value over Time')
plt.show()