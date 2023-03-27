import cv2 as cv
import sys
import matplotlib.pyplot as plt

img = cv.imread('soccer.jpg')
img = cv.resize(img, (512, 512))

if img is None:
    sys.exit('파일을 찾을 수 없습니다.')

print('Image Size = ', img.shape)
h, w, c = img.shape

print('Pixel Intenity Value = ', img[100, 70])

gray = cv.cvtColor(img,cv.COLOR_BGR2GRAY)
roi = img[50:300, 0:250]   # image cropping (ROI extraction by slicing)
# 이게 왼쪽 위가 (0, 0)이고 [y:y+h, x:x+w]

cv.imshow('Color Image', img)
cv.imshow('Gray Image', gray)
cv.imshow('Cropped Image', roi)

RGB_img  =  cv.cvtColor(img,  cv.COLOR_BGR2RGB) #  convert  color  space  from  BGR  to  RGB RGB_roi = RGB_img[50:300, 30:280]
RGB_roi = RGB_img[50:300, 30:280]   # image cropping (ROI extraction by slicing) pit.ims how(RGB_roi)

plt.imshow(RGB_roi)
plt.show()

cv.waitKey()
cv.destroyAllWindows()