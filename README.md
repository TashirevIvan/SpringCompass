# SpringCompass
Программа расчитывает положение сторон света на компасе, исходя ТОЛЬКО из левого СНЕВЕРНОГО угла. И игнорирует любые другие входные данные. Таким образом, для построения компаса можно передавать только северную сторону
# cURL:
reset
```
curl --location 'http://localhost:8090/reset' \
--header 'Content-Type: application/json' \
--data '{
    "North": "341-25"
}'
```
measure
```
curl --location --request GET 'http://localhost:8090/measure' \
--header 'Content-Type: application/json' \
--data '{
    "Degree": 359
}'
```
