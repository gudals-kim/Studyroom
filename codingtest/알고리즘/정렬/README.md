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
for index in ragne(1,len(datalist)):
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
    #입력 받은 리스트 갯수가 한개보다 작으면 그대로 반환한다.
    if len(data) <= 1 :
        return data
    #left,right 리스트 생성
    left = list()
    right = list()
    # 기준점 설정
    pivot = data[0]

    #data 각 index 접근
    for index in range(1,len(data)):
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
  - 단, ***최악의 경우 O($n^2$)***
    - 맨 처음 pivot이 가장 크거나, 가장 작으면
    - 모든 데이터를 비교하는 상황이 나옴
<img src="https://www.fun-coding.org/00_Images/quicksortworks.jpg" />

<br>

## 5. 병합 정렬 (merge sort)

### 5.1 병합정렬 이란?

* 재귀 용법을 활용한 정렬 알고리즘
    1. 리스트를 절반으로 잘라 비슷한 크기의 두 부분의 리스트로 나눈다.
    2. 각 부분 리스트를 재귀적으로 합병 정렬를 이용행 정렬한다.
    3. 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.
* 직접 눈으로 보면 더 이해가 쉽다: https://visualgo.net/en/sorting

<img src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif" width=500/>

출처: [위키피디아](https://ko.wikipedia.org/wiki/%ED%95%A9%EB%B3%91_%EC%A0%95%EB%A0%AC)

### 5.2 알고리즘 이해

* 데이터가 네 개 일때 생각해보기
    - 예 : data_list = [1,9,3,2]
        * 먼저 [1,9],[3,2]로 나누고
        * 다시 앞 부분은 [1],[9]로 나누고
        * 다시 정렬 해서 합친다. [1,9]
        * 다음 [3,2]는 [3], [2]로 나누고
        * 다시 정렬 해서 합친다 [2,3]
        * 이제 [1,9],[2,3] 을 합친다
            * 1 < 2 이니 [1]
            * 9 > 2 이니 [1,2]
            * 9 > 3 이니 [1,2,3]
            * 9 만 남았으니 [1,2,3,9]


* 어떤 데이터리스트가 있 을때 리스트를 앞 뒤로 짜르는 코드를 작성하기

```python
data = [1,5,7,2]
def split_func(data):
    # data의 길이의 중간 인덱스를 저장
    medium = int(len(data)/2) # 7 
    left = data[:medium]  #[1,5]
    right = data[medium:] #[7,2]
```


### 5.3 알고리즘 구현

* mergesplit 함수 만들기
    - 만약 리스트 갯수가 한개이면 해당 값을 리턴한다.
    - 그렇지 않으면, 리스트를 앞뒤, 두 개로 나눈다.
    - left = mergesplit(앞)
    - right = mergesplit(뒤)
    - merge(left,right)

* merge 함수 만들기
    - 리스트 변수 하나 만들기 (sorted)
    - left_index, right_index = 0
    - while left_index < len(left) or right_index < len(right)
        * 만약 left_index 나 right_index가 이미 left 또는 right 리스트를 다 순회 했다면, 그 반대쪽 데이터를 그대로 넣고, 해당 인덱스 1 증가

            ```python
            if left[left_index] < right[right_index]:
                sorted.append(left[left_index])
                left_index += 1
            else:
                sorted.append(right[right_index])
                right_index += 1
            ```

* mergesplit 함수 구현

```python
def mergesplit(data):
    if len(data) <= 1:
        return data
    pivot = int(len(data)/2)
    left = mergesplit(data[:pivot])
    right = mergesplit(data[pivot:])
    return merge(left,right)
```

* merge 함수 구현

```python
def merge(left,right):
    sorted = list()
    left_point, right_point = 0, 0

    # case1 - left/right 둘다 있을때
    while len(left) > left_point and len(right) > right_point:
        # left[0] 보다 rignt[0]이 클때
        if left[left_point] > right[right_point]:
            sorted.append(right[reight_point])
            right_point += 1
        # left[0] 보다 rignt[0]이 클때
        else:
            sorted.append(left[left_point])
            left_point += 1
    
    # case2 - right 데이터가 없을때
    while len(left) > left_point:
        sorted.append(left[left_point])
        left_point += 1
    
    # case3 - left 데이터가 없을때
    while len(right) > right_point:
        sorted.append(right[right_point])
        right_point += 1
    
    return sorted

```

### 5.4 병합 정렬 시간 복잡도

* 알고리즘 분석은 쉽지 않음, <font color='#BF360C'>이 부분은 참고로만 알아두자.</font>
  - 다음을 보고 이해해보자
    - 몇 단계 깊이까지 만들어지는지를 depth 라고 하고 i로 놓자. 맨 위 단계는 0으로 놓자.
      - 다음 그림에서 n/$2^2$ 는 2단계 깊이라고 해보자.
      - 각 단계에 있는 하나의 노드 안의 리스트 길이는 n/$2^2$ 가 된다.
      - 각 단계에는 $2^i$ 개의 노드가 있다.
    - 따라서, 각 단계는 항상 <font size=4em>$2^i * \frac { n }{ 2^i } = O(n)$</font>
    - 단계는 항상 $log_2 n$ 개 만큼 만들어짐, 시간 복잡도는 결국 O(log n), 2는 역시 상수이므로 삭제
    - 따라서, 단계별 시간 복잡도 O(n) * O(log n) = O(n log n)

<img src="https://www.fun-coding.org/00_Images/mergesortcomplexity.png" />
