import cv2 as cv
import sys
import matplotlib.pyplot as plt
import numpy as np

img = cv.imread('my_picture.jpg')
gray = cv.imread('Lena_gray.png')
img = cv.resize(img, (512, 512))

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

kernel = np.ones((3, 3), np.float32) / 9
dst = cv.filter2D(img, -1, kernel)
dst_gray = cv.filter2D(gray, -1, kernel)

cv.imshow('Original Image', img)
cv.imshow('Averaging Image', dst)
cv.imshow('Original Image Gray', gray)
cv.imshow('Averaging Image Gray', dst_gray)

cv.waitKey()
cv.destroyAllWindows()