from PyQt5.QtWidgets import *

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        tw = QTableWidget(self)
        tw.setColumnCount(2)
        tw.setRowCount(5)

        tw.setHorizontalHeaderLabels( ["금액", "잔고"] )
        tw.setVerticalHeaderLabels( ["a", "b", "c", "d", "e"] )

        d = QTableWidgetItem("안녕")
        tw.setItem(0, 0, d)
        d = QTableWidgetItem("Hi")
        tw.setItem(0, 1, d)

        tw.resize(300, 250)
        self.resize(300, 250)

if __name__ == "__main__":
    app = QApplication( [] )
    label = MyWindow()
    label.show()
    app.exec_()