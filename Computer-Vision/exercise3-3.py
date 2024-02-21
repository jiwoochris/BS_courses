import cv2 as cv
import sys
import matplotlib.pyplot as plt

img = cv.imread('bus.jpg')

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

histogram = cv.calcHist([gray], [0], None, [256], [0, 256])

plt.plot(histogram, color='b', linewidth=3)

plt.show()