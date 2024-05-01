from PyQt5.QtWidgets import *
from PyQt5 import uic

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("first_ui.ui", self)

        self.edit.setText("My first UI")

        self.button.clicked.connect(self.click)
        self.clickFlag = True

    def click(self):
        if self.clickFlag == True:
            self.button.setText("button clicked")
            self.clickFlag = False
        else:
            self.button.setText("button")
            self.clickFlag = True


app = QApplication( [] )
label = MyWindow()
label.show()
app.exec_()