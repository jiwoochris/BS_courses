import pyupbit

with open("upbit_key.txt", "r") as f:
    access = f.readline().strip()
    secret = f.readline().strip()

upbit = pyupbit.Upbit(access, secret)

print(upbit.get_balances())