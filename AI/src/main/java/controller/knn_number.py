import numpy as np
import cv2
from matplotlib import pyplot as plt

img = cv2.imread('digits.png', 0)
# # show ảnh chính
# cv2.imshow('dd', img)
# cv2.waitKey(0)
# cv2.destroyAllWindows()
imgnhandang = cv2.imread('anhso3.jpg', 0)

cells = [np.hsplit(row, 50) for row in np.vsplit(img, 50)]

# # show số theo tọa độ qua img
# cv2.imwrite('anhso1531.jpg', cells[15][31])
# print(cells[15][31])

x = np.array(cells)
x2 = np.array(imgnhandang)

# #nén ảnh 2 chiều thành 1 chiều
# xx = x[0][0].reshape(-1, 400)
# cv2.imwrite('anh1.jpg', xx)

# tạo dữ liệu training và dữ liệu test
train = x[:,:50].reshape(-1,400).astype(np.float32)
test = imgnhandang.reshape(-1, 400).astype(np.float32)



# gán nhãn cho dữ liệu train
k = np.arange(10)
train_label = np.repeat(k, 250) [:, np.newaxis]


# nhận dạng
knn = cv2.ml.KNearest_create()
knn.train(train, 0 ,train_label)

kq1, kq2, kq3, kq4 = knn.findNearest(test, 5)
print(kq1)
print(kq2)
print(kq3)
print(kq4)