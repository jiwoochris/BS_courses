import cv2 as cv
import numpy as np
from matplotlib import pyplot as plt

img = cv.imread('house.jpg')
gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

orb = cv.ORB_create()

keypoints, descriptor = orb.detectAndCompute(img, None)

img_draw = cv.drawKeypoints(img, keypoints, None, \
                            flags=cv.DRAW_MATCHES_FLAGS_DRAW_RICH_KEYPOINTS)

img_draw2 = cv.drawKeypoints(img, keypoints, None, color=(0,255,0), flags=0)

cv.imshow('img_draw', img_draw)
cv.imshow('img_draw2', img_draw2)

cv.waitKey()
cv.destroyAllWindows()