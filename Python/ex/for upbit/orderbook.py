from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from PyQt5 import uic
import pyupbit
import time

class OrderbookWorker(QThread):
    dataReceive = pyqtSignal(list)

    def run(self):
        while True:
            data = pyupbit.get_orderbook("KRW-BTC")
            self.dataReceive.emit(data)

            time.sleep(5)



class OrderbookWidget(QWidget):
    def __init__(self):
        super().__init__()
        uic.loadUi("orderbook.ui", self)

        self.ow = OrderbookWorker()
        self.ow.dataReceive.connect(self.updateOrderbook)
        self.ow.start()

    def updateOrderbook(self, param):
        for i in range(10):
            item = param[0]['orderbook_units'][9-i]
            value = item['ask_price'] * item['ask_size']

            d = QTableWidgetItem(str(item['ask_price']))
            self.askTable.setItem(i, 0, d)

            d = QTableWidgetItem(str(item['ask_size']))
            self.askTable.setItem(i, 1, d)

            d = QTableWidgetItem(str(value))
            self.askTable.setItem(i, 2, d)

            item = param[0]['orderbook_units'][i]
            value = item['bid_price'] * item['bid_size']

            d = QTableWidgetItem(str(item['bid_price']))
            self.bidTable.setItem(i, 0, d)

            d = QTableWidgetItem(str(item['bid_size']))
            self.bidTable.setItem(i, 1, d)

            d = QTableWidgetItem(str(value))
            self.bidTable.setItem(i, 2, d)


if __name__ == "__main__":
    app = QApplication( [] )
    ow = OrderbookWidget()
    ow.show()
    app.exec_()