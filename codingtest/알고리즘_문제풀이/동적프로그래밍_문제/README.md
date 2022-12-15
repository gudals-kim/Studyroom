# 동적 프로그래밍 문제풀이

## 문제풀이 

> 프로그램 테스트 케이스와 실행 시간 및 사용 메모리 확인 코드가 들어가 있다.
```python
import time
import datetime
import psutil
import sys
inputData = "예제 입력 데이터 경로를 입력하세요."

p = psutil.Process()
rss = p.memory_info().rss / 2 ** 20 # Bytes to MB

sys.stdin = open(inputData,"r")
startTime = time.time()
print("--------여기부터 답안 출력입니다.--------")
# ======== 답안지 작성을 합니다 =========



# ==================================
print("--------여기까지 답안 출력입니다.--------")
endTime = time.time()

print(f"code memory usage  {rss: 10.5f} MB")
print(f"code execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
```

> 문제를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.

## 실전 코딩테스트 - 동적계획법

> 일반적인 동적 계획법 문제는 통상 코드 자체는 간결하다 <br> **가장 적은 경우의 수부터 계산을 해본 후 패턴을 찾아 점화식** 을 세우는 것이 핵심이다.

<details>
<summary>backjoon_11726 노트정리</summary>

* [문제링크](https://www.acmicpc.net/problem/11726)

## 백준 11726번 2 x N 타일링

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|1초|256MB|35%|첫째 줄에 n이 주어진다.(1 ≤ n ≤ 1,000)|첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

<br>

### 문제

```
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
```

<img src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11726/1.png" width=400>

<br>

|예제입력|예제출력|
|:---:|:---:|
|2|2|
|9|55|

<br>

### 문제풀이 전략

* 1. 점화식 찾기
        - n = 1 -> 1
        - n = 2 -> 2
        - n = 3 -> 3
        - n = 4 -> 5
        - n = 5 -> 8
        - 이런식의 진행이였기 때문에 ```f(n) = f(n-1) + f(n-2)```라고 생각했다.

* 2. 초기값 설정

    ```python
    n = int(input()) #입력값을 받는다.
    cache = [0 for i in range(n+1)] #입력 n까지의 리스트를 만든다.
    cache[0] = 0 # 조건이 n이 0이 나올 순 없지만 0으로 잡아주었다.
    cache[1] = 1 # n 이 1일땐 1이다.
    cache[2] = 2 # n 이 2일땐 2이다.
    ```

* 3. 점화식 코드 적용 
    
    ```python
    for index in range(3,n+1): #입력 n 일때 3부터 n+1은 점화식조건을 따른다.
        cache[index] = cache[index-1] + cache[index-2]
    ```

* 4. 문제 조건 검토
    
    ```python
    if n < 3: #n이 1과 2일땐 점화식에 적용받지 않음으로 계산하지 않도록 바로 그 값을 return한다.
        print(n)
    else:
        #이후 점화식 코드 및 저장공간 코드(cache)
        
        print(cache[n]%10007) #마지막엔 문제조건에 맞게 cache[n]을 제출한다.
    ```

### 답안 전체코드

```python
n = int(input())
if n < 3:
    print(n)
else:
    cache = [0 for i in range(n+1)]
    cache[0] = 0
    cache[1] = 1
    cache[2] = 2
    for index in range(3,n+1):
        cache[index] = cache[index-1] + cache[index-2]
    print(cache[n]%10007)
```

</details>

<details>
<summary>backjoon_1904 노트정리</summary>

* [문제링크](https://www.acmicpc.net/problem/1904)

## 백준 1904번 01타일

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|0.75 초 (추가 시간 없음)|256MB|32%|첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000)|첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.

<br>

### 문제

```
지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.

어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다. 결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.

그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.

우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로 가정하자.
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|4|5|


<br>

### 문제풀이 전략

1. 점화식찾기
    - n=1 -> 1
    - n=2 -> 2 
    - n=3 -> 3
    - n=4 -> 5
    - n=5 -> 8
    - 따라서 n = n-1 + n+2

2. 초기값 설정

```python
import sys
n = int(sys.stdin.readline()) #input() 함수보다 빠른 입력 받는 함수

numbers = [0] * 1000001 # n의 최대값까지 리스트를 만들어준다. ([0 for i in range(n+1)]하면 인덱싱 에러가 난다 이유를 찾아 공부해야한다.)
numbers[1] = 1 # 1 - > 1 처리
numbers[2] = 2 # 2 - > 2 처리
```

3. 점화식 코드 작성

```python
if n > 2:
    for index in range(3,n+1):
        numbers[index] = (numbers[index-1] + numbers[index-2])
```

4. 문제 조건 검토

```python
    for index in range(3,n+1):
        numbers[index] = (numbers[index-1] + numbers[index-2])% 15746
print(numbers[n])
```


### 답안 전체코드

```python
import sys
n = int(sys.stdin.readline())

numbers = [0] * 1000001
numbers[1] = 1
numbers[2] = 2
if n > 2:
    for index in range(3,n+1):
        numbers[index] = (numbers[index-1] + numbers[index-2])% 15746
print(numbers[n])
```


</details>




<details>
<summary>backjoon_문제번호 노트정리</summary>

* [문제링크](문제링크)

## 백준 (문제번호)번 (문제이름)

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|1초|256MB|35%|입력조건|출력조건

<br>

### 문제

```
문제 내용
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|예제입력1|예제출력2|
|예제입력2|예제출력2|

<br>

### 문제풀이 전략



### 답안 전체코드



</details>