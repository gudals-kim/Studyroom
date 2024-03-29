
# [백준 1325번 효율적인 해킹](https://www.acmicpc.net/problem/1325)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_1.svg" width="20">  백준 1325번 효율적인 해킹  


| 시간제한 | 메모리제한 | 정답비율  | 난이도  | 
|:----:|:-----:|:-----:|:----:|
|  5초  | 256MB | 	19%  | 실버1  |

---

### 문제


<br> 해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다.
<br> 이 회사는 N개의 컴퓨터로 이루어져 있다.
<br> 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
<br> 
<br> 이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
<br> 
<br> 이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.

### 예제 입출력
   
#### 입력 조건
> 첫째 줄에, N과 M이 들어온다.<br>
> N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다.<br>
> 둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다.<br>
> 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.<br>
#### 출력 조건
> 첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다. <br>
---
#### 예제 입력 1
```
5 4
3 1
3 2
4 3
5 3
```
#### 예제 출력 1
```
1 2
```

---


<br>

### 문제풀이 전략
- 문제 유형
  - 그래프, 그래프 탐색, 너비 우선 탐색

#### 문제풀이 핵심 아이디어

- 모든 정점에 대하여 DFS 및 BFS를 수행 한다.
- ***DFS 혹은 BFS를 수행할 때 마다 방문하게 되는 노드의 개수를 계산***하면 된다.
- 가장 노드의 개수가 크게 되는 시작 정점을 출력한다.


### 답안 전체코드
#### 답안 1
```py
from collections import defaultdict, deque
import sys
input = sys.stdin.readline
n, m = map(int,input().split())
graph = defaultdict(list)
for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)
def bfs(graph, startNode):
    result = list()
    visited = deque([startNode])
    while visited:
        node = visited.popleft()
        if node not in result:
            result.append(node)
            visited += graph[node]
    return len(result)

answer = list()
maxNum = 0
array = graph.keys()
for computer in range(1,n+1):
    numberOfHacks = bfs(graph,computer)
    if maxNum <= numberOfHacks:
        maxNum = numberOfHacks
        answer.append(computer)
print(" ".join(str(x) for x in sorted(answer)))
```

#### 답안 2
```python
from collections import  deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    graph[y].append(x)

def bfs(startNode):
    q = deque([startNode])
    #방문 여부 체크
    visited = [False] * (n+1)
    visited[startNode] = True

    count = 1
    
    while q:
        node = q.popleft()
        for e in graph[node]:
            if not visited[e]:
                q.append(e)
                visited[e] = True
                count += 1
    return count
result = []
max_value = -1

for computer in range(1, n+1):
    numberOfHacks = bfs(computer)
    if numberOfHacks > max_value:
        result = [computer]
        max_value = numberOfHacks
    elif numberOfHacks == max_value:
        result.append(computer)
        max_value = numberOfHacks
for e in result:
    print(e, end=" ")
```