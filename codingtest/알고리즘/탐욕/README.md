# 탐욕(Greedy)

## 1. 탐욕 알고리즘이란?

* 최적의 해에 가까운 값을 구하기 위해 사용됨
* 여러 경우 하나를 결정해야할 때마다, 매순간 최적이라고 생각되는 경우를 선택하는 방식으로 진행하여 최종적인 값을 구하는 방식이다.
* _매순간 가장 좋은것을 가져가기 때문에 탐욕이라고 생각하면 외우기 쉽다_

<br>

## 2. 탐욕 알고리즘 예

### 2.1 문제 1: 동전문제

* 지불해야 하는 값이 4720원 일 때 1원 50원 100원, 500원 동전으로 동전의 수가 가장 적게 지불하시오.
* 풀이 방법
    - 동전의 수를 줄이기 위해선 가장 가격이 높은 동전부터 빼야함
    - 탐욕 알고리즘으로 매순간 가장 높은 가격이라고 생각되는 경우를 선택하면 됨

```py
#입력

def min_coin_count(price, coin_list):
    total_coin_count = 0
    details = list()
    coin_list.sort(reverse=True) #가격이 높은것부터 정렬
    for coin in coin_list:
        coin_num = price//coin #가격을 동전으로 나눈다.
        total_coin_count += coin_num #사용된 동전의 개수를 추가
        price -= coin*coin_num #가격에서 사용된 동전의 가격만큼 뺀다
        details.append([coin, coin_num])#사용된 동전가격과 동전수를 저장
    return total_coin_count, details
```
```py
#출력

coin_list = [1, 100, 50, 500]

print(min_coin_count(4720, coin_list))

출력 > (31, [[500, 9], [100, 2], [50, 0], [1, 20]])
```

### 2.2 문제 2: 부분 배낭 문제 (Fractional Knapsack Problem)

* 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
* 풀이 방법
    - 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
    - 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음, 그래서 Fractional Knapsack Problem 으로 부름
    - Fractional Knapsack Problem 의 반대로 물건을 쪼개서 넣을 수 없는 배낭 문제도 존재함 (0/1 Knapsack Problem 으로 부름)
    <img src="https://www.fun-coding.org/00_Images/knapsack.png">

> 쪼갤수 있는 물건인 경우 (Fractional Knapsack Problem)
```py
#입력
def get_max_value(data_list, bag_size):
    #가치/무게의 내림차순으로 정렬
    data_list = sorted(data_list, key=lambda x: x[1]/x[0], reverse=True)
    total_value = 0
    details = list()

    for data in data_list:
        if bag_size - data[0] >= 0 :#가방사이즈에 물건이 들어갈 여유가 있다면
            bag_size -= data[0] #그 만큼 가방사이즈를 줄이고
            total_value += data[1] # 물건의 가치를 추가한다
            details.append([data[0], data[1], 1]) 
            #세부정보를 보기 위한 details에 저장
        else:#남은 가방사이즈보다 물건이 클때
            percentage = bag_size / data[0] #가방사이즈/물건크기 나눈다.
            total_value += data[1] * percentage #물건의 가치를 남은 가방크기의 퍼센트만큼 곱해 가치를 더한다
            details.append([data[0],data[1],percentage])#세부정보를 보기 위한 details에 저장
            break
    return total_value, details
```
```py
#출력
data_list =[(10, 10), (15, 12), (20, 10), (25, 8), (30, 5)]
print(get_max_value(data_list, 30))

출력 > (24.5, [[10, 10, 1], [15, 12, 1], [20, 10, 0.25]])
```

>쪼갤수 없는 물건일 경우 (0/1 Knapsack Problem 으로 부름)
```py
def get_max_value(data_list, bag_size):
    #가치/무게의 내림차순으로 정렬
    data_list = sorted(data_list, key=lambda x: x[1]/x[0], reverse=True)
    total_value = 0
    details = list()

    for data in data_list:
        if bag_size - data[0] >= 0 :#가방사이즈에 물건이 들어갈 여유가 있다면
            bag_size -= data[0] #그 만큼 가방사이즈를 줄이고
            total_value += data[1] # 물건의 가치를 추가한다
            details.append([data[0], data[1], 1]) 
            #세부정보를 보기 위한 details에 저장
    return total_value, details
```


## 3. 탐욕 알고리즘의 한계

* 탐욕 알고리즘은 근사치 추정에 활용
* 반드시 최적의 해를 구할 수 있는 것은 아니기 때문
* 최적의 해에 가까운 값을 구하는 방법 중의 하나임

### 예

<img src="https://www.fun-coding.org/00_Images/greedy.png" width=300>

* '시작' 노드에서 시작해서 가장 작은 값을 찾아 leaf node 까지 가는 경로를 찾을 시에
    - Greedy 알고리즘 적용시 시작 -> 7 -> 12 를 선택하게 되므로 7 + 12 = 19 가 됨 
    - 하지만 실제 가장 작은 값은 시작 -> 10 -> 5 이며, 10 + 5 = 15 가 답

