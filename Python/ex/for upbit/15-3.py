from PyQt5.QtWidgets import *
from PyQt5.QtGui import QIcon

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.resize(400, 300)
        self.move(0, 0)
        self.setWindowTitle("Bitcoin Auto Trading")
        self.setWindowIcon(QIcon("coin_icon.png"))

        btn = QPushButton("버튼", self)
        btn.move(100, 100)
        btn.resize(100, 100)
        btn.clicked.connect(self.click)

    def click(self):
        print("Hi")


if __name__ == "__main__":
    app = QApplication( [] )
    label = MyWindow()
    label.show()
    app.exec_()