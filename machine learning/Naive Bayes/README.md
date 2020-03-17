1. Se dă mulțimea de antrenare, reprezentând înălțimea în cm a unei persoane
   și eticheta corespunzătoare:
   [(160, F), (165, F), (155, F), (172, F), (175, B), (180, B), (177, B), (190, B)].
   Împărțind valorile continue (înălțimea) în 4 intervale (150-160, 161-170, 171-
   180, 181-190), calculați probabilitatea ca o persoană având 178 cm, să fie
   fată sau să fie băiat, folosind regula lui Bayes.
   
2. Știind că valoarea minimă a unui pixel este 0, iar valoarea maximă este 255,
   calculați capetele a num_bins intervale (utilizați funcția linspace). Definiți
   metoda values_to_bins care primește o matrice de dimensiune (n_samples,
   n_features) și capetele intervalelor calculate anterior, iar pentru fiecare 
   exemplu și fiecare atribut calculează indexul intervalului corespunzător
   (utilizați funcția np.digitize).
   Folosiți funcția definită pentru a discretiza mulțimea de antrenare și cea de
   testare.
   
3. Calculați acuratețea pe mulțimea de testare a clasificatorul Multinomial Naive
   Bayes, împărținând intervalul pixelilor în 5 sub-intervale.
   OBS. Acuratețea pe care trebuie să o obțineți pentru num_bins = 5
   este de 83.6%.
   
4. Testați clasificatorul Multinomial Naive Bayes pe subsetul MNIST
   folosind𝑛𝑢𝑚_𝑏𝑖𝑛𝑠 ∈ {3, 5, 7, 9, 11}.
   
5. Folosind numărul de sub-intervale care obține cea mai bună acuratețe la
   exercițiul anterior, afișați cel puțin 10 exemple misclasate.
 
6. Definiți metoda confusion_matrix(y_true, y_pred) care calculează matricea de
   confuzie. Calculați matricea de confuzie folosind predicțiile clasificatorului
   anterior.
