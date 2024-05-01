from PyQt5.QtWidgets import *
import pyupbit

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        tw = QTableWidget(self)
        tw.setColumnCount(2)
        tw.setRowCount(5)

        tw.setHorizontalHeaderLabels( ["가격", "잔량"] )

        data = pyupbit.get_orderbook("KRW-BTC")
        for item in data[0]['orderbook_units']:
            print(item)

        for i in range(0, 5):
            d = QTableWidgetItem(str(data[0]['orderbook_units'][4-i]['ask_price']))
            tw.setItem(i, 0, d)
            d = QTableWidgetItem(str(data[0]['orderbook_units'][4-i]['ask_size']))
            tw.setItem(i, 1, d)

        tw.resize(300, 250)
        self.resize(300, 250)

if __name__ == "__main__":
    app = QApplication( [] )
    label = MyWindow()
    label.show()
    app.exec_()