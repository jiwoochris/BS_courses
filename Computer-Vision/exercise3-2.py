import cv2 as cv
import sys
import matplotlib.pyplot as plt

img = cv.imread('bus.jpg')

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

(thresh, binary_otsu_img) = cv.threshold(gray, 0, 255, cv.THRESH_BINARY + cv.THRESH_OTSU)

print('The best Threshold Value obtained by Otsu = ', thresh)

cv.imwrite('bus_bin_otsu.jpg', binary_otsu_img)

cv.imshow('Gray Image', gray)
cv.imshow('Binary Otsu Image', binary_otsu_img)

cv.waitKey()
cv.destroyAllWindows()