from PyQt5.QtWidgets import *

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.resize(320, 220)

        te = QTextEdit(self)
        te.setText("안녕하세요")

        # te.move(10, 10)
        # te.resize(300, 200)

        te.setGeometry(10, 10, 300, 200)    

if __name__ == "__main__":
    app = QApplication( [] )
    label = MyWindow()
    label.show()
    app.exec_()