from PyQt5.QtWidgets import *

class MyWidget(QLabel):
    def __init__(self, string):
        super().__init__(string)

app = QApplication( [] )

label = MyWidget("Hello World")
label.show()

app.exec_()