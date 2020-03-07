import numpy as np
from skimage import io

imagini = []
img_dec = []
#a
for i in range(9):
    imagini.append([])
    imagini[i] = np.load('car_' + str(i) + '.npy')
#b
print( np.sum(imagini) )
#c
for i in range(9):
    print(np.sum(imagini[i]))
#d
max = 0
index = -1
for i in range(9):
    sum = np.sum(imagini[i])
    if(max < sum):
        index = i
        max = sum
print(index)
#e
pozaMed = np.full((400, 600),0)
for i in range(9):
    pozaMed = np.add(pozaMed, imagini[i])
pozaMed = pozaMed / 9
io.imshow(pozaMed.astype(np.uint8))
io.show()
#f
for i in range(9):
    poza = np.full((400, 600), 0)
    poza = np.add(poza, imagini[i]-pozaMed)
    io.imshow(poza.astype(np.uint8))
    io.show()
#g
for i in range(9):
    io.imshow(imagini[i][200:300, 280:400].astype(np.uint8))
    io.show()