from pyupbit import WebSocketManager
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *

class Worker(QThread):
    receiveData = pyqtSignal(dict)

    def run(self):
        wm = WebSocketManager("ticker", ["KRW-BTC"])
        self.alive = True

        while self.alive:
            data = wm.get()
            self.receiveData.emit(data)
        wm.terminate()

    def end(self):
        self.alive = False


class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.w = Worker()
        self.w.receiveData.connect(self.processData)
        self.w.start()

    def closeEvent(self, event):
        self.w.end()

    def processData(self, data):
        print(data)

if __name__ == "__main__":
    app = QApplication( [] )
    m = MyWindow()
    m.show()
    app.exec_()