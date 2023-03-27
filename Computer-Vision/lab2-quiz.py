import cv2 as cv
import sys

img = cv.imread('noise_quiz3.png')

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

medianBlur = cv.medianBlur(img, 3, 1)

dst = cv.GaussianBlur(img, (5,5), 1)
dst2 = cv.GaussianBlur(img, (5,5), 3)
dst3 = cv.GaussianBlur(img, (0,0), 7)

cv.imshow('medianBlur Image', medianBlur)
cv.imshow('Gaussian Image sigma = 1 with 5x5', dst)
cv.imshow('Gaussian Image sigma = 3 with 5x5', dst2)
cv.imshow('Gaussian Image sigma = 7', dst3)

cv.waitKey()
cv.destroyAllWindows()