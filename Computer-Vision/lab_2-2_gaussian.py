import cv2 as cv
import sys
import matplotlib.pyplot as plt
import numpy as np

img = cv.imread('Lena_color.png')
gray = cv.imread('Lena_gray.png')
# img = cv.resize(img, (512, 512))

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

dst = cv.GaussianBlur(gray, (5,5), 1)
dst2 = cv.GaussianBlur(gray, (5,5), 3)
dst3 = cv.GaussianBlur(gray, (0,0), 7)

cv.imshow('Original Image', gray)
cv.imshow('Gaussian Image sigma = 1 with 5x5', dst)
cv.imshow('Gaussian Image sigma = 3 with 5x5', dst2)
cv.imshow('Gaussian Image sigma = 7', dst3)

cv.waitKey()
cv.destroyAllWindows()