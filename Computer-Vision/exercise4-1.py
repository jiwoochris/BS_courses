import cv2 as cv
import sys
import matplotlib.pyplot as plt

img = cv.imread('bus.jpg')

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

image_red = img.copy()
image_red[:, :, 1] = 0
image_red[:, :, 0] = 0

image_green = img.copy()
image_green[:, :, 2] = 0
image_green[:, :, 0] = 0

image_blue = img.copy()
image_blue[:, :, 2] = 0
image_blue[:, :, 1] = 0

cv.imshow('Color Image', img)

cv.imshow('Red Channel', image_red)
cv.imshow('Green Channel', image_green)
cv.imshow('Blue Channel', image_blue)

cv.waitKey()
cv.destroyAllWindows()