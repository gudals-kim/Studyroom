# 탐색 문제풀이

## 문제풀이 

> 메모리 검사 코드 

```py
import psutil
def memory_usage(message: str = 'debug'):
    # current process RAM usage
    p = psutil.Process()
    rss = p.memory_info().rss / 2 ** 20 # Bytes to MB
    print(f"[{message}] memory usage: {rss: 10.5f} MB")

memory_usage("#1")
```

> 문제를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.

<details>
<summary>backjoon_1920</summary>

* [문제링크](https://www.acmicpc.net/problem/1920)

## 백준 1920번 수찾기

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|1초|128MB|29%|첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.|M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.|

<br>

### 문제

```
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|5|1|
|4 1 5 2 3|1|
|5|0|
|1 3 7 9 5|0|
||0|

<br>

### 문제풀이 전략

* 자원(시간, 메모리) 조건을 맞추기 까다로운 문제이다.

1. 입력을 받을때 이분탐색을 이용하기 때문에 정렬을 한다.

```python

Anum = int(stdin.readline())
Alist = sorted(list(map(int,stdin.readline().split())))
Bnum = stdin.readline()
Blist = list(map(int,stdin.readline().split()))

```

2. 함수를 정의한다.
    - 시작값, 찾을값, 끝값을 받는다.
    - 시작값과 끝값의 중간값을 찾는다.
    - 찾는 값이 중간값보다 작다면 끝값을 중간값으로 바꾸어준다.
    - 찾는 값이 중간값보다 크다면 시작값을 중간값으로 바꾸어준다.
    - 찾는 값과 중간값이 같다면 찾은것이다.
    - 시작값이 끝값보다 커지는 경우는 실패로 처리한다.

```python
def search(start, value ,end): #시작값, 찾을값, 끝값을 받는다.
    if  start > end: #시작값이 끝값보다 커지는 경우는 실패로 처리한다.
        return False
    pivot = (start+end)//2 #시작값과 끝값의 중간값을 찾는다.
    if Alist[pivot] > value: #찾는 값이 중간값보다 작다면 끝값을 중간값으로 바꾸어준다.
        return search(start, value, pivot-1)
    elif Alist[pivot] < value: #찾는 값이 중간값보다 크다면 시작값을 중간값으로 바꾸어준다.
        return search(pivot+1, value, end)
    else:  #찾는 값과 중간값이 같다면 찾은것이다.
        return True
```

3. 조건에 맞게 값을 출력한다.

```python
for i in Blist:
    if search(0,i,Anum-1):
        print(1)
    else:
        print(0)

```

### 답안 전체코드

```python

from sys import stdin, stdout

Anum = int(stdin.readline())
Alist = sorted(list(map(int,stdin.readline().split())))
Bnum = stdin.readline()
Blist = list(map(int,stdin.readline().split()))

def search(start, value ,end):
    if  start > end:
        return False
    pivot = (start+end)//2
    if Alist[pivot] > value:
        return search(start, value, pivot-1)
    elif Alist[pivot] < value:
        return search(pivot+1, value, end)
    else: 
        return True

for i in Blist:
    if search(0,i,Anum-1):
        print(1)
    else:
        print(0)

```

</details>