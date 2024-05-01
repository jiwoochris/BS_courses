from PyQt5.QtWidgets import *

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.resize(320, 60)

        id = QLabel("ID", self)
        id.setGeometry(10, 10, 30, 40)

        te = QLineEdit(self)
        te.setGeometry(50, 10, 250, 40)    

if __name__ == "__main__":
    app = QApplication( [] )
    label = MyWindow()
    label.show()
    app.exec_()