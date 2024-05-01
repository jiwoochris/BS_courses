class 사람:
    def __init__(self, 이름, 생년월일, 성별):
        self.이름 = 이름
        self.생년월일 = 생년월일
        self.성별 = 성별

    def 정보출력(self):
        print(self.생년월일, " 출생")
        print("(",self.성별,") ", self.이름)

사람1 = 사람("유종훈", "19860302", "남")
사람1.정보출력()