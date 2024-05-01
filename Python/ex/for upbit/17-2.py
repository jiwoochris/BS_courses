from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
import time
import pyupbit

class current(QThread):
    def run(self):
        while True:
            BTC = pyupbit.get_current_price("KRW-BTC")
            LTC = pyupbit.get_current_price("KRW-LTC")
            time.sleep(1)
            print("BTC : %d\nLTC : %d"%(BTC, LTC))


class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.c = current()
        self.c.start()


app = QApplication( [] )
label = MyWindow()
label.show()
app.exec_()