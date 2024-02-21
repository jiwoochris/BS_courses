
import cv2 as cv
import sys
import matplotlib.pyplot as plt

img = cv.imread('bus.jpg')

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

colors = ['b', 'g', 'r']
bgr_planes = cv.split(img)

for (p, c) in zip(bgr_planes, colors):
    histogram = cv.calcHist([p], [0], None, [256], [0, 256])
    plt.plot(histogram, color=c, linewidth=3)

plt.show()

