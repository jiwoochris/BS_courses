class account:
    def __init__(self, name, balance):
        self.name = name
        self.balance = balance

    def print(self):
        print("이름: ", self.name)
        print("잔고: ", self.balance)

계좌1 = account("김철수", 5000)
계좌1.print()