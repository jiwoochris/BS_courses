from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
import time
import pyupbit

class current(QThread):
    curr = pyqtSignal(float)
    diff = pyqtSignal(str)

    def run(self):
        prev = None
        while True:
            price = pyupbit.get_current_price("KRW-BTC")
            self.curr.emit(price)

            if prev != None:
                if prev < price :
                    self.diff.emit("Up")
                elif prev == price:
                    self.diff.emit("Same")
                else:
                    self.diff.emit("Down")
            
            prev = price
            time.sleep(1)

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.label1 = QLabel("up? down?", self)
        self.label2 = QLabel("1000", self)
        self.label2.move(0, 40)

        self.c = current()
        self.c.start()
        self.c.curr.connect(self.curr)
        self.c.diff.connect(self.diff)

    def diff(self, value):
        self.label1.setText(value)

    def curr(self):
        price = pyupbit.get_current_price("KRW-BTC")
        self.label2.setText(str(price))

app = QApplication( [] )
label = MyWindow()
label.show()
app.exec_()