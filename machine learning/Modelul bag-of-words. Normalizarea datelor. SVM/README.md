## Build the vocabulary and print vocabulary size
bow_model = BagOfWords()
bow_model.build_vocabulary(training_data)

## Transforming text into numerical features
training_features = bow_model.get_features(training_data)
testing_features = bow_model.get_features(test_data)

## Normalizing numerical features before feeding into the classification model
norm_train, norm_test = normalize_data(training_features, testing_features, type='l2')

## SVM model training
model = svm.SVC(C=1.0, kernel='linear')

model.fit(norm_train, training_labels)

## Getting predictions
test_preds = model.predict(norm_test)

## Printing accuracy
accuracy_score(test_labels, test_preds)

# Printing F1-Score
f1_score(test_labels, test_preds)

## Print report
print(classification_report(test_labels, test_preds))


## Printing the most important features (negative and positive)
print(model.coef_.shape)
weights = np.squeeze(model.coef_)
print(weights)

idxes = np.argsort(weights)
words = np.array(bow_model.words)
print('Negative', words[idxes[:10]])
print('Positive', words[idxes[-10:]])
