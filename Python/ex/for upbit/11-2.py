import pandas as pd

input = "2021-01-01"

output = pd.to_datetime(input) + pd.Timedelta(days = 1000)

print(output)