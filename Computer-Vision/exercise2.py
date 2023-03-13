import cv2 as cv
import sys
import matplotlib.pyplot as plt

img = cv.imread('bus.jpg')

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

cv.imwrite('bus_gray.jpg', gray)

cv.imshow('Binary Image', img)
cv.imshow('Gray Image', gray)

cv.waitKey()
cv.destroyAllWindows()