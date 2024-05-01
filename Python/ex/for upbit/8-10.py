class account:
    def __init__(self, name, balance):
        self.name = name
        self.balance = balance

    def 입금(self, 얼마):
        self.balance += 얼마

    def 출금(self, 얼마):
        if 얼마 > self.balance:
            print("잔고 부족")
        else:
            self.balance -= 얼마

    def print(self):
        print("이름: ", self.name)
        print("잔고: ", self.balance)

class minus_account(account):
    def 출금(self, 얼마):
        self.balance -= 얼마

계좌1 = minus_account("김철수", 5000)
계좌1.print()
계좌1.입금(6000)
계좌1.print()
계좌1.출금(10000000)
계좌1.print()