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