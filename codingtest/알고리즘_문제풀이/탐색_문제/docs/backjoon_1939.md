
# [백준 1939 중량제한](https://www.acmicpc.net/problem/1939)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_3.svg" width="20">  백준 1939 중량제한   


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  2초  | 128MB | 25%  | 골드3 |

<br>

### 문제

---

<br> N(2 ≤ N ≤ 10,000)개의 섬으로 이루어진 나라가 있다. 
<br>이들 중 몇 개의 섬 사이에는 다리가 설치되어 있어서 차들이 다닐 수 있다.
<br>
<br>영식 중공업에서는 두 개의 섬에 공장을 세워 두고 물품을 생산하는 일을 하고 있다. 
<br>물품을 생산하다 보면 공장에서 다른 공장으로 생산 중이던 물품을 수송해야 할 일이 생기곤 한다. 
<br>그런데 각각의 다리마다 중량제한이 있기 때문에 무턱대고 물품을 옮길 순 없다. 
<br>만약 중량제한을 초과하는 양의 물품이 다리를 지나게 되면 다리가 무너지게 된다.
<br>
<br>한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하는 프로그램을 작성하시오.

### 예제 입출력

#### 입력 조건
> 첫째 줄에 N, M(1 ≤ M ≤ 100,000)이 주어진다. 다음 M개의 줄에는 다리에 대한 정보를 나타내는 세 정수 A, B(1 ≤ A, B ≤ N), C(1 ≤ C ≤ 1,000,000,000)가 주어진다. <br> 
> 이는 A번 섬과 B번 섬 사이에 중량제한이 C인 다리가 존재한다는 의미이다. <br> 
> 서로 같은 두 섬 사이에 여러 개의 다리가 있을 수도 있으며, 모든 다리는 양방향이다. <br> 
> 마지막 줄에는 공장이 위치해 있는 섬의 번호를 나타내는 서로 다른 두 정수가 주어진다. <br> 
> 공장이 있는 두 섬을 연결하는 경로는 항상 존재하는 데이터만 입력으로 주어진다. <br> 
#### 출력 조건
> 첫째 줄에 답을 출력한다. <br>
---
#### 예제 입력 1
```
3 3
1 2 2
3 1 3
2 3 2
1 3
```
#### 예제 출력 1
```
3
```
---



<br>

### 문제풀이 전략
- 문제 유형
  - 이분 탐색, 그래프 탐색, 너비 우선 탐색


#### 문제풀이 핵심 아이디어
> A, B의 모든 경로 중 가중치의 최대값을 구하여라.<br>

- 다리의 개수 M은 최대 100,000이며, 중량 제한 C는 최대 1,000,000,000 입니다.
- 이진 탐색을 이용하여 O(M logC)에 문제를 해결해야 합니다.
- 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 이진 탐색으로 찾습니다.
> 이진탐색을 이용해서 C를 구하자!<br>

#### 문제풀이 프로세스
- 반복적으로 중량을 설정하며, 이동이 가능한 경우를 찾습니다. (시작노드:1, 도착노드:3)
  <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1939_1.png?raw=true">
  - 1과 이어진 모든 경로
    - 최대 중량 = 9
    - 최소 중량 = 2
  - 이후 9과 2의 중간 중량을 찾고, 그 중간 중량일때, bfs로 섬이 이어지는지 찾는다.
    - 9와 2의 중간 중량 = 5일때, 섬이 이어지는경우
      - 최대 중량을 5로 저장한 후 5와 9의 중간값 7의 중량을 찾는다.
      - 최대 중량 7로 길이 이어지는지 탐색한다.
    - 9와 2의 중간 중량 = 5일때, 섬이 이어지지 않는경우
      - 2와 4의 중간값 3으로 이어지는지 탐색한다.
### 답안 전체코드

```py
import sys
from collections import deque
n, m = map(int, input().split())
adj = [[] for _ in range(n+1)]
def bfs(c):
    queue = deque([start_node])
    visited = [False] * (n+1)
    visited[start_node] = True
    while queue:
       x = queue.popleft()
       for y, weight in adj[x]:
           if not visited[y] and weight >= c:
                visited[y] = True
                queue.append(y)
    return visited[end_node]

start = 1000000000
end = 1

for _ in range(m):
    x, y ,weight = map(int, input().split())
    adj[x].append((y, weight))
    adj[y].append((x, weight))
    start = min(start, weight)
    end = max(end, weight)

start_node, end_node = map(int, input().split())
result = start
while(start<=end):
    mid = (start + end)//2
    if bfs(mid):
        result = mid
        start = mid + 1
    else:
        end = mid - 1
print(result)
```
