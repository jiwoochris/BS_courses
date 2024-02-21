import cv2 as cv
import numpy as np
from matplotlib import pyplot as plt

img1 = cv.imread('taekwonv1.jpg')
img2 = cv.imread('taekwonv2.jpg')
gray1 = cv.cvtColor(img1, cv.COLOR_BGR2GRAY)
gray2 = cv.cvtColor(img2, cv.COLOR_BGR2GRAY)

detector = cv.ORB_create()

kp1, desc1 = detector.detectAndCompute(gray1, None)
kp2, desc2 = detector.detectAndCompute(gray2, None)

matcher = cv.BFMatcher(cv.NORM_HAMMING, crossCheck = True)

matches = matcher.match(desc1, desc2)

res = cv.drawMatches(img1, kp1, img2, kp2, matches, None, \
                     flags=cv.DRAW_MATCHES_FLAGS_NOT_DRAW_SINGLE_POINTS)

cv.imshow('img_draw', res)

cv.waitKey()
cv.destroyAllWindows()