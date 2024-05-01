from PyQt5.QtWidgets import *
from PyQt5 import uic
import pyupbit

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("16-2.ui", self)

        self.login.clicked.connect(self.click_login)

    def click_login(self):
        access = self.access_key.text()
        secret = self.secret_key.text()
        upbit = pyupbit.Upbit(access, secret)
        krw = upbit.get_balances("KRW")
        self.balance.setText(str(krw))
            


app = QApplication( [] )
label = MyWindow()
label.show()
app.exec_()