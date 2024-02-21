import cv2 as cv
import sys
import matplotlib.pyplot as plt

img = cv.imread('bus.jpg')

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

(thresh, binary_img) = cv.threshold(gray, 50, 255, cv.THRESH_BINARY)

cv.imwrite('bus_bin.jpg', binary_img)

cv.imshow('Color Image', img)
cv.imshow('Gray Image', gray)
cv.imshow('Binary Image', binary_img)

cv.waitKey()
cv.destroyAllWindows()