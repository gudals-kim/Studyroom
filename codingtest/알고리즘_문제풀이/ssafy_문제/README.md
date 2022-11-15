# SW expert Academy 문제

## 문제풀이 

> 문제를 클릭하면 자세한 설명이 나온다. 

<details>
<summary>2072_홀수만 더하기 노트정리</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq)

## 삼성 기출문제 2072 홀수만 더하기

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|71%|첫 줄에 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다. 각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.(모든 수는 0이상 10000이하의 정수)|출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.(t는 테스트케이스의 번호이며 1부터 시작한다.)

<br>

### 문제

```
10개의 수를 입력 받아, 그 중에서 홀수만 더한 값을 출력하는 프로그램을 작성하라
```

<br>

|예제입력|예제출력|
|:---:|:---:|
|3||
|3 17 1 39 8 41 2 32 99 2|#1 200|
|22 8 5 123 7 2 63 7 3 46|#2 208|
|6 63 2 3 58 76 21 33 8 1|#3 121|

<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - 홀수만 더하는 함수

2. 입력 처리
    -  input 받은뒤 그 수만큼 반복하여 testcase를 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.


### 답안 전체코드

```python
def oddsum(tcase):
    result = 0
    for j in tcase:
        if j%2==1:
            result+=j
    return result
def 입력():
    n = int(input())
    i=0
    testcase = list()
    while i < n:
        inputNums=list(map(int,input().split()))
        testcase.append(inputNums)
        i += 1
    return testcase

def 출력(testcase):
    num=1
    for tcase in testcase:
        result=oddsum(tcase)
        print('#%d %d'%(num,result))
        num+=1

출력(입력())
```

</details>


<details>
<summary>2071_평균값 구하기 노트정리</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QRnJqA5cDFAUq&categoryId=AV5QRnJqA5cDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=1&pageSize=10&pageIndex=1)

## SW Expert Academy 2071번 평균값 구하기

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|68%|가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.|출력의 각줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

<br>

### 문제

```
10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.

(소수점 첫째 자리에서 반올림한 정수를 출력한다.)
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|3|예제출력2|
|3 17 1 39 8 41 2 32 99 2|#1 24|
|22 8 5 123 7 2 63 7 3 46|#2 29|
|6 63 2 3 58 76 21 33 8 1|#3 27|

<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - 모두 더한뒤 10으로 나누고 round 함수를 이용하여 반올림한다.

2. 입력 처리
    -  input 받은뒤 그 수만큼 반복하여 testcase를 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.


### 답안 전체코드

```py
def 평균(tcase):
    return round(sum(tcase)/10)
def 입력():
    n = int(input())
    i=0
    testcase = list()
    while i < n:
        inputNums=list(map(int,input().split()))
        testcase.append(inputNums)
        i += 1
    return testcase

def 출력(testcase):
    num=1
    for tcase in testcase:
        result=평균(tcase)
        print('#%d %d'%(num,result))
        num+=1

출력(입력())
```


</details>

<details>
<summary>backjoon_문제번호 노트정리</summary>

* [문제링크](문제링크)

## SW Expert Academy 2071번 평균값 구하기

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