from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from PyQt5 import uic
import pyupbit

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("17-1.ui", self)

        timer = QTimer(self)
        timer.start(1000)
        timer.timeout.connect(self.current)

    def current(self):
        price = pyupbit.get_current_price("KRW-BTC")
        self.KRW_BTC.setText(str(price))

app = QApplication( [] )
label = MyWindow()
label.show()
app.exec_()