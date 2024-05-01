class 비행기:
    def __init__(self, name):
        self.name = name

    def fly(self):
        print(self.name, " 이륙합니다.")

비행기_1 = 비행기("보잉787")
비행기_2 = 비행기("에어버스 A330")

비행기_1.fly()
비행기_2.fly()