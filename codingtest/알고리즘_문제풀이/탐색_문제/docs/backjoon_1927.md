
# [백준 1927번 최소 힙](https://www.acmicpc.net/problem/1927)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_2.svg" width="20">  백준 1927번 최소 힙   


|  시간제한  | 메모리제한  | 정답비율  |  난이도   | 
|:------:|:------:|:-----:|:------:|
|   1초    | 128MB  |  48%  |  실버2   |

---

### 문제

<br> 널리 잘 알려진 자료구조 중 최소 힙이 있다.
<br> 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.

1. 배열에 자연수 x를 넣는다.
2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.

<br> 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
<br> 


### 예제 입출력

#### 입력 조건
> 첫째 줄에 연산의 개수 N(1<=N<=100,000)이 주어진다.<br> 
> 다음 N개의 줄에는 연산에 대한 정보를 나태는 정수 x가 주어진다. <br>
> 만약 x가 자연수라면 배열에 x라는 값을 넣는 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거한다. <br>
> x는 2의 31승 보다 작은 자연수 또는 0 이고, 음의 정수는 입력으로 주어지지 않는다. <br>
>  <br>
#### 출력 조건
> 입력에서 0이 주어진 횟수만큼 답을 출력한다. <br>
> 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다. <br>
---
#### 예제 입력 1
```
9
0
12345678
1
2
0
0
0
0
32
```
#### 예제 출력 1
```
0
1
2
12345678
0
```
---



<br>

### 문제풀이 전략
- 문제 유형
  - 최소 힙

#### 문제풀이 핵심 아이디어
- 힙을 구현할 수 있는지 물어보는 문제
- 파이썬 라이브러리 heapq를 활용한다.


### 답안 전체코드

```py
import heapq
import sys
input = sys.stdin.readline
n = int(input())
numbers = []
for _ in range(n):
    number = int(input())
    if number == 0:
        if len(numbers)==0:
            print(0)
        else:
            print(heapq.heappop(numbers))
    else:
        heapq.heappush(numbers,number)
```
