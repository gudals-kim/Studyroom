# 정렬(sort)

## 0. 대표적인 정렬 알고리즘 

1. 버블정렬 
2. 삽입정렬 
3. 선택정렬 
4. 퀵정렬 
5. 병합정렬 

<br>

## 1. 버블정렬(bubble sort)
* 버블 정렬이란?
    - 두 인접한 데이터를 비교해서, 앞에 있는 데이터가 뒤에 있는 데이터보다 크면, 자리를 바꾸는 정렬 알고리즘
    - 직접 눈으로 보면 더 이해가 쉽다: https://visualgo.net/en/sorting

    <img src="https://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif" width=600/>

> 출처: https://en.wikipedia.org/wiki/Bubble_sort

### 1.1 구현 방법
* **특이점 찾아보기**
  - n개의 리스트가 있는 경우 최대 n-1번의 로직을 적용한다.
  - 로직을 1번 적용할 때마다 가장 큰 숫자가 뒤에서부터 1개씩 결정된다.
  - 로직이 경우에 따라 일찍 끝날 수도 있다. 따라서 로직을 적용할 때 한 번도 데이터가 교환된 적이 없다면 이미 정렬된 상태이므로 더 이상 로직을 반복 적용할 필요가 없다.
<img src="https://www.fun-coding.org/00_Images/bubblealgo.png" />

1. for num in range(len(data_list)) 반복
2. swap = 0 (교환이 되었는지를 확인하는 변수를 두자)
2. 반복문 안에서, for index in range(len(data_list) - num - 1) n - 1번 반복해야 하므로
3. 반복문안의 반복문 안에서, if data_list[index] > data_list[index + 1] 이면
4. ```data_list[index], data_list[index + 1] = data_list[index + 1], data_list[index]```
5. ```swap += 1```
6. 반복문 안에서, if swap == 0 이면, break 끝

### 1.2 bubble sort 구현
```python
#입력
def bubblesort(data):
    for index in range(len(data) - 1):
        swap = False
        for index2 in range(len(data) - index - 1):
            if data[index2] > data[index2 + 1]:
                data[index2], data[index2 + 1] = data[index2 + 1], data[index2]
                swap = True
        
        if swap == False:
            break
    return data

#test code
import random

data_list = random.sample(range(100), 50)
print (bubblesort(data_list))
```

### 1.3 버블 정렬 시간 복잡도

* 반복문이 두 개 O($n^2$)
  - 최악의 경우, <font size=5em>$\frac { n * (n - 1)}{ 2 }$</font>
* 완전 정렬이 되어 있는 상태라면 최선은 O(n)

<br>

## 2. 삽입 정렬(insertion sort)
* 삽입 정렬이란?
    - 삽입 정렬은 두 번째 인덱스부터 시작
    - 해당 인덱스(key 값) 앞에 있는 데이터(B)부터 비교해서 Key 값이 더 작으면, B값을 뒤 인덱스로 복사한다.
    - 이를 key 값이 더 큰 데이터를 만날때까지 반복, 그리고 큰 데이터를 만난 위치 바로 뒤에 key 값을 이동
    - 직접 눈으로 보면 더 이해가 쉽다: https://visualgo.net/en/sorting
    <img src="https://upload.wikimedia.org/wikipedia/commons/9/9c/Insertion-sort-example.gif" />

> 출처: https://commons.wikimedia.org/wiki/File:Insertion-sort-example.gif

### 2.1 구현 방법
* 실행 프로세스
    1. 두번째 인덱스부터 시작한다.
    2. 두번째 인덱스와 첫번째 인덱스를 비교하여 두번째 인덱스가 더 작다면 첫번째 인덱스와 자리를 바꾼다.
    3. 세번째 인덱스에서 시작한다.
    4. 세번째 인덱스와 두번째, 첫번째 인덱스를 비교한다.
    5. 이후 세번째 인덱스보다 작은값인 인덱스를 만나면 그 인덱스 바로 뒤에 삽입한다.
    6. 이후 반복

### 2.2 파이썬 구현

```python
#입력
def insertion_sort(data):
    for index in range(len(data) - 1):
        for index2 in range(index + 1, 0, -1):
            if data[index2] < data[index2 - 1]:
                data[index2], data[index2 - 1] = data[index2 - 1], data[index2]
            else:
                break
    return data


#test code
import random

data_list = random.sample(range(100), 50)
print (insertion_sort(data_list))
```

### 2.3 삽입정렬의 시간복잡도
* 반복문이 두 개 O($n^2$)
  - 최악의 경우, <font size=5em>$\frac { n * (n - 1)}{ 2 }$</font>
* 완전 정렬이 되어 있는 상태라면 최선은 O(n)

<br>

## 3.선택 정렬(selection sort)

* 선택 정렬이란?
    - 다음과 같은 순서를 반복하며 정렬하는 알고리즘
        1. 주어진 데이터 중, 최소값을 찾음
        2. 해당 최소값을 데이터 맨 앞에 위치한 값과 교체함
        3. 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복함
    - 직접 눈으로 보면 더 이해가 쉽다: https://visualgo.net/en/sorting

<img src="https://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif" width=100  >

출처: https://en.wikipedia.org/wiki/Selection_sort

### 3.1 구현 방법

* 데이터가 두 개 일때
  - 예: dataList = [9, 1]
    - data_list[0] > data_list[1] 이므로 data_list[0] 값과 data_ list[1] 값을 교환
* 데이터가 세 개 일때
  - 예: data_list = [9, 1, 7]
    - 처음 한번 실행하면, 1, 9, 7 이 됨
    - 두 번째 실행하면, 1, 7, 9 가 됨
* 데이터가 네 개 일때
  - 예: data_list = [9, 3, 2, 1]
    - 처음 한번 실행하면, 1, 3, 2, 9 가 됨
    - 두 번째 실행하면, 1, 2, 3, 9 가 됨
    - 세 번째 실행하면, 변화 없음

### 3.2 파이썬 구현

```python
#입력
def selection_sort(data):
    for stand in range(len(data) - 1):
        lowest = stand
        for index in range(stand + 1, len(data)):
            if data[lowest] > data[index]:
                lowest = index
        data[lowest], data[stand] = data[stand], data[lowest]
    return data

#test code
import random

data_list = random.sample(range(100), 10)
selection_sort(data_list)
```

### 3.3 선택정렬 시간복잡도
* 반복문이 두 개 O($n^2$)
  - 실제로 상세하게 계산하면, <font size=5em>$\frac { n * (n - 1)}{ 2 }$</font>
  
<br>

## 4. 퀵 정렬(quick sort)

### 4.1 퀵 정렬 이란?
* 정렬 알고리즘의 꽃
* 기준점(pivot)을 정해서, pivot보다 작은 데이터는 왼쪽(left), 큰 데이터는 오른쪽(right)으로 모으는 함수를 작성한다.
* 각 왼쪽, 오른쪽은 재귀 용법을 사용해서 다시 동일 함수를 호출하여 위 작업을 반복한다.
* 함수는 왼쪽(left) + 기준점(pivot) + 오른쪽(right)를 리턴한다.

### 4.2 파이썬으로 구현하기

* 리스트 슬라이싱 사용하기

```python
data_list = [1,2,3,4,5]

left = data_list[:2] #[1,2]
pivot = data_list[2] #[3]
right = data_list[3:] #[4,5]
```

* data_list가 임의 길이일때, 리스트를 맨 앞 데이터를 pivot으로 지정하고 pivot 보다 작은데이터는 left에 큰 함수를 right에 저장하기

```python
import random
data_list = random.sample(range(100), 10)
left = list()
right = list()
pivot = data_list[0]

#data_list 의 인덱스 접근
for index in ragne(1,len(datalist)+1):
    # 각 datalist[index]가 pivot보다 작을때
    if datalist[index] < pivot:
        #left 리스트에 추가
        left.append(datalist[index])
    # 각 datalist[index]가 pivot보다 크거나 같을때
    else:
        right.append(data_list[index])
result = left + list(pivot) + right

```

* 알고리즘 구현하기

    - quicksort 함수 만들기
        * 만약 리스트 갯수가 한개이면 해당 리스트를 리턴
        * 그렇지 않으면, 리스트 맨 앞의 데이터를 기준으로 놓는다.
        * left,right 리스트를 만들고
        * 맨 앞의 데이터를 뺀 나머지 데이터를 기준점과 비교한다.
        * 기준점보다 작으면 left, 크거나 같으면 right에 넣는다.
        * return quicksort(left) + [pivot] + quicksort(right)로 재귀호출한다.

```python
def quicksort(data):
    #입력 받은 리스트 갯수가 한개이면 그대로 반환한다.
    if len(data) == 1 :
        return data
    #left,right 리스트 생성
    left = list()
    right = list()
    # 기준점 설정
    pivot = data[0]

    #data 각 index 접근
    for index in range(1:len(data)+1):
        if data[index] < pivot:
            left.append(data[index])
        else:
            right.append(data[index])
    
    return quicksort(left) + [pivot] + quicksort(right)

```

* list comprehension 사용하여 코드 길이 줄이기

```python
def qsort(data):
    if len(data) <= 1:
        return data
    
    pivot = data[0]

    left = [ item for item in data[1:] if pivot > item ]
    right = [ item for item in data[1:] if pivot <= item ]
    
    return qsort(left) + [pivot] + qsort(right)
```

### 4.3 퀵정렬의 시간복잡도
* 병합정렬과 유사, ```시간복잡도는 O(n log n)```
  - 단, ***최악의 경우*** ```O($n^2$)```
    - 맨 처음 pivot이 가장 크거나, 가장 작으면
    - 모든 데이터를 비교하는 상황이 나옴
<img src="https://www.fun-coding.org/00_Images/quicksortworks.jpg" />