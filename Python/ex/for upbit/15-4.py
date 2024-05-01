from PyQt5.QtWidgets import *
from PyQt5.QtGui import QIcon

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.resize(260, 120)
        self.move(0, 0)

        btn1 = QPushButton("1", self)
        btn1.move(30, 30)
        btn1.resize(100, 30)
        btn1.clicked.connect(self.click)

        btn2 = QPushButton("2", self)
        btn2.move(130, 30)
        btn2.resize(100, 30)
        btn2.clicked.connect(self.click)

        btn3 = QPushButton("3", self)
        btn3.move(30, 60)
        btn3.resize(100, 30)
        btn3.clicked.connect(self.click)

        btn4 = QPushButton("4", self)
        btn4.move(130, 60)
        btn4.resize(100, 30)
        btn4.clicked.connect(self.click)

    def click(self):
        b = self.sender()
        print("Hi", b.text())

if __name__ == "__main__":
    app = QApplication( [] )
    label = MyWindow()
    label.show()
    app.exec_()