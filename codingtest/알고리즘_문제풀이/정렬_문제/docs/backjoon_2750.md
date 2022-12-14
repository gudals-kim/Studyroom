
# [백준 2750번 수 정렬 하기](https://www.acmicpc.net/problem/2750)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/bronze_2.svg" width="20">  백준 2750번 수 정렬하기


| 시간제한 |메모리제한| 정답비율 | 난이도  | 
|:----:|:---:|:----:|:----:|
|  1초  |128MB| 58%  | 브론즈2 |

<br>

### 문제

```
[문제]
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

[입력]
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 
이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.


```


<br>

| 예제입력1 | 예제출력1 |
|:-----:|:-----:|
|   5   |   1   |
|   5   |   2   |
|   2   |   3   |
|   3   |   4   |
|   4   |   5   |
|   1   |   -   |




<br>

### 문제풀이 전략
- 문제 유형
  - 정렬

#### 매우 기본적인 정렬 문제이다.

***풀이 방법 3가지*** 
1. 직접 정렬을 구현해서 풀이하기
2. 파이썬 내장함수 sort 함수를 사용하기
3. heap 자료형을 사용하여 풀기

### 답안 전체코드

```py
import heapq
n = int(input())
queue = list()
for i in range(n):
    num = int(input())
    heapq.heappush(queue,num)

for i in range(n):
    print(heapq.heappop(queue))
```
