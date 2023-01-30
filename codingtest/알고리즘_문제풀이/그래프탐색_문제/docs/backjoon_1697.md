
# [백준 1697번 숨바꼭질](https://www.acmicpc.net/problem/1697)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_1.svg" width="20">  백준 1697번 숨바꼭질  


| 시간제한 | 메모리제한 | 정답비율 | 난이도  | 
|:----:|:-----:|:----:|:----:|
|  2초  | 128MB | 25%  | 실버1  |

---

### 문제

<br> 수빈이는 동생과 숨바꼭질을 하고 있다.
<br> 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
<br> 수빈이는 걷거나 순간이동을 할 수 있다.
<br> 
<br> 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
<br> 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
<br> 
<br> 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.


### 예제 입출력

#### 입력 조건
> 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.<br>
#### 출력 조건
> 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다. <br>
---
#### 예제 입력 1
```
5 17
```
#### 예제 출력 1
```
4
```

---


<br>

### 문제풀이 전략
- 문제 유형
  - 그래프, 그래프 탐색, 너비 우선 탐색
- 수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.

#### 문제풀이 핵심 아이디어

- 특정 위치까지 이동하는 최단 시간을 계산해야 하는 문제이다.
- 이동 시간이 모두 1초로 동일하므로, 간단히 BFS를 이용하여 해결할 수 있습니다.
- 큐(Queue) 구현을 위해 collections 라이브러리의 deque를 이용한다.

> 5에서 12로 가는 최단 시간은 다음과 같이 계산할 수 있다. 이때의 간선의 가중치는 1 (1초가 걸리기 때문)
- 5
  - 5 - 1 (4)
    - 4 - 1 (3)
    - 4 + 1 (5) 이미 다녀온 정점
    - 4 * 2 (8)
  - 5 + 1 (6)
    - 6 - 1 (5) 이미 다녀온 정점
    - 6 + 1 (7)
    - 6 * 2 (12) 
      - 12를 찾았기 때문에 루트 노드와의 거리(depth*1)를 구하면 된다.
  - 5 * 2 (10)
    - 10 - 1 (9)
    - 10 + 1 (11)
    - 10 * 2 (20)



### 답안 전체코드

```py
from collections import deque

MAX = 100001
n, k = map(int, input().split())
result = [0] * MAX

def bfs(n,k):
    visited = deque([n])
    while visited:
        node = visited.popleft()
        if node == k:
            return result[node]
        for nextNode in (node-1, node+1, node * 2):
            if 0<= nextNode < MAX and not result[nextNode]:
                # 다음 노드로 넘어갈 경우 현재 노드의 값에 1을 더한다 (그래프의 depth와 같음)
                result[nextNode] = result[node] + 1
                visited.append(nextNode)
print(bfs(n,k))
```
