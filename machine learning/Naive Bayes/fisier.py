# EX 1
antrenare = [(160, 'F'), (165, 'F'), (155, 'F'), (172, 'F'), (175, 'B'), (180, 'B'), (177, 'B'), (190, 'B')]
barbatiInterval = 0
femeiInterval = 0
barbatiTotal = 0
femeiTotal = 0
interval = 0
for i in antrenare:
    if i[1] == 'F':
        femeiTotal = femeiTotal + 1
    else:
        barbtiTotal = barbatiTotal + 1
    if i[0] > 171 and i[0] < 180:
        interval = interval + 1
        if i[1] == 'F':
            femeiInterval = femeiInterval + 1
        else:
            barbatiInterval = barbatiInterval + 1
Pc = femeiTotal / (femeiTotal + barbatiTotal)
Pxc = femeiInterval / (femeiInterval + barbatiInterval)
print('P(femeie|178) = ', Pc * Pxc * interval / (femeiTotal + barbatiTotal))


#EX 2 --liniarizarea datelor

import numpy as np
import matplotlib.pyplot as plt

train_images = np.loadtxt('train_images.txt')
train_labels = np.loadtxt('train_labels.txt', 'int')
test_images = np.loadtxt('test_images.txt')
test_lables = np.loadtxt('test_labels.txt', 'int')

PIXEL_MIN_VALUE = 0
PIXEL_MAX_VALUE = 255
def values_to_bins (data_matrix, num_bins ):
    bins = np.linspace(start = PIXEL_MIN_VALUE, stop = PIXEL_MAX_VALUE, num = num_bins)
    data_to_bins = np.digitize(data_matrix, bins)
    return data_to_bins - 1

x_train = values_to_bins(train_images, 5)
x_test = values_to_bins(test_images, 5)

#Ex 3

from sklearn.naive_bayes import MultinomialNB
naive_bayes_model = MultinomialNB()
naive_bayes_model.fit(x_train, train_labels)
print (naive_bayes_model.score(x_test,test_lables))

#Ex 4

max = 0
indice = -1
for i in [3, 5, 7, 9, 11]:
    y_train = values_to_bins(train_images, i)
    y_test = values_to_bins(test_images, i)
    new_naive_bayes_model = MultinomialNB()
    new_naive_bayes_model.fit(y_train, train_labels)
    print(new_naive_bayes_model.score(y_test, test_lables))
    if max <= new_naive_bayes_model.score(y_test, test_lables):
        max = new_naive_bayes_model.score(y_test, test_lables)
        indice = i
print(indice, max)

#Ex 5

predict = new_naive_bayes_model.predict(values_to_bins(test_images, indice))
miss = []
miss.append(np.where(predict != test_lables))
for i in range(1,10):
    image = np.reshape(x_test[i], (28, 28))
    plt.imshow(image.astype(np.uint8), cmap='gray')
    plt.show()

#Ex 6

def confusion_matrix(y_true, y_pred):
    from sklearn.metrics import confusion_matrix
    my_matrix = confusion_matrix(y_true, y_pred)
    print(my_matrix)

confusion_matrix(test_lables, new_naive_bayes_model.predict(values_to_bins(test_images, indice)))