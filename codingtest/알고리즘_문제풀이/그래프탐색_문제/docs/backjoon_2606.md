
# [백준 2606번 바이러스](https://www.acmicpc.net/problem/2606)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_3.svg" width="20">  백준 2606번 바이러스  


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  1초  | 128MB | 	46%  | 실버3 |

---

### 문제
 

  

<br> 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
<br> 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
<br> 
<br> 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자.
<br> 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다.
<br> 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
<br>
<br>

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_2606_1.png?raw=true">


<br>

<br> 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다.
<br> 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.


### 예제 입출력

#### 입력 조건
> 첫째 줄에는 컴퓨터의 수가 주어진다.<br>
> 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.<br>
> 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.<br>
> 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.<br>
#### 출력 조건
> 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.<br>
---
#### 예제 입력 1
```
7
6
1 2
2 3
1 5
5 2
5 6
4 7
```
#### 예제 출력 1
```
4
```

---


<br>

### 문제풀이 전략
- 문제 유형
  - 그래프, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

#### 문제풀이 핵심 아이디어

- 1번 컴퓨터로 인해 웜 바이러스에 걸린 컴퓨터의 수는 1번 컴퓨터와 연결된 컴퓨터이다.
  - bfs or dfs로 1번 노드에서 시작되는 그래프 탐색을 하면 된다.

- 단순히 시작 정점에서부터 도달할 수 있는 노드의 수를 계산하는 문제
- 따라서 DFS or BFS를 이용하여 방문하게 되는 노드의 개수를 계산하면 된다.
  - BFS가 약간 더 빠르다.
- 컴퓨터의 수가 적음으로, DFS를 이용해 빠르게 문제를 푸는 것이 유리하다.

### 답안 전체코드
#### 답안 1
```py
from collections import defaultdict,deque
cnt = int(input())
graph = defaultdict(set)
for _ in range(int(input())):
    a, b = map(int,input().split())
    graph[a].add(b)
    graph[b].add(a)
def bfs(graph, startNode):
    result = list()
    visited = deque([startNode])
    while visited:
        node = visited.popleft()
        if node not in result:
            result.append(node)
            visited.extend(graph[node])
    return result
print(len(bfs(graph, 1))-1)
```

#### 답안 2 
```python
n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
count = 0

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

def dfs(startNode):
    global count
    count+=1
    visited[startNode]=True
    for nextNode in graph[startNode]:
        if not visited[nextNode]:
            dfs(nextNode)
dfs(1)
print(count-1)
```