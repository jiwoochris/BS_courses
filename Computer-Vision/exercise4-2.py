import cv2 as cv
import sys
import matplotlib.pyplot as plt

img = cv.imread('bus.jpg')

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

hist1 = cv.calcHist([img], [0], None, [256], [0, 256]) #B
hist2 = cv.calcHist([img], [1], None, [256], [0, 256]) #G
hist3 = cv.calcHist([img], [2], None, [256], [0, 256]) #R

plt.subplot(221),plt.plot(hist1, color='b')
plt.subplot(222),plt.plot(hist1, color='g')
plt.subplot(223),plt.plot(hist1, color='r')

plt.xlim([0, 256])

plt.show()