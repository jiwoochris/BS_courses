import cv2 as cv

src = cv.imread('my_picture.jpg', cv.IMREAD_COLOR)
src = cv.resize(src, (512, 512))

height, width, channel = src.shape

dst = cv.pyrDown(src)
dst2 = cv.pyrUp(src, dstsize = (width * 2, height * 2), borderType = cv.BORDER_DEFAULT)



cv.imshow('src', src)
cv.imshow('pyrDown', dst)
cv.imshow('pyrUp', dst2)

cv.waitKey()
cv.destroyAllWindows()