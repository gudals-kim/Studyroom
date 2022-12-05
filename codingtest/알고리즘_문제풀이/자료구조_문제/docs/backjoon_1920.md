
# [백준 1920번 수 찾기](https://www.acmicpc.net/problem/1920)

## 1920번 수 찾기

| 시간제한 |메모리제한|정답비율|입력조건|출력조건|
|:----:|:---:|:---:|:---:|:---:|
|  1초  |128MB|29%|문제에표기|문제에표기|

<br>

### 문제

```
[문제]
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

[입력]
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

[출력]
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
```


<br>

|   예제입력    | 예제출력 |
|:---------:|:----:|
|     5     |  1   |
| 4 1 5 2 3 |  1   |
|     5     |  0   |
| 1 3 7 9 5 |  0   |
|     -     |  1   |



<br>

### 문제풀이 전략


- 매우 자료를 받아서 그 자료가 있는지 판단하는 쉬운 문제이기 때문에 전략보다
- 탐색으로도 풀 수 있기 때문에 탐색을 최대한 활용해 풀어보았다.

### 답안 전체코드

```py
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
