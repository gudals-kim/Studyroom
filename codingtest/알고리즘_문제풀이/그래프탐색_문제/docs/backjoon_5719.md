
# [백준 5719번 거의 최단 경로](https://www.acmicpc.net/problem/5719)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/platinum_5.svg" width="20">  백준 5719번 거의 최단 경로  


| 시간제한 | 메모리제한 | 정답비율 |  난이도  | 
|:----:|:-----:|:----:|:-----:|
|  2초  | 256MB | 39%  | 플래티넘5 |

---

### 문제

<br> 요즘 많은 자동차에서는 GPS 네비게이션 장비가 설치되어 있다.
<br>  네비게이션은 사용자가 입력한 출발점과 도착점 사이의 최단 경로를 검색해 준다.
<br> 하지만, 교통 상황을 고려하지 않고 최단 경로를 검색하는 경우에는 극심한 교통 정체를 경험할 수 있다.
<br> 
<br> 상근이는 오직 자기 자신만 사용 가능한 네비게이션을 만들고 있다.
<br> 이 네비게이션은 절대로 최단 경로를 찾아주지 않는다.
<br> 항상 거의 최단 경로를 찾아준다.
<br> 거의 최단 경로란 최단 경로에 포함되지 않는 도로로만 이루어진 경로 중 가장 짧은 것을 말한다.
<br> 
<br> 예를 들어, 도로 지도가 아래와 같을 때를 생각해보자.
<br> 원은 장소를 의미하고, 선은 단방향 도로를 나타낸다.
<br> 시작점은 S, 도착점은 D로 표시되어 있다.
<br> 굵은 선은 최단 경로를 나타낸다. (아래 그림에 최단 경로는 두 개가 있다)
<br> 거의 최단 경로는 점선으로 표시된 경로이다.
<br>
<br> 이 경로는 최단 경로에 포함되지 않은 도로로 이루어진 경로 중 가장 짧은 경로이다.
<br> 거의 최단 경로는 여러 개 존재할 수도 있다.
<br> 예를 들어, 아래 그림의 길이가 3인 도로의 길이가 1이라면, 거의 최단 경로는 두 개가 된다.
<br> 또, 거의 최단 경로가 없는 경우도 있다.
<br> 

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_5719_1.png?raw=true">

### 예제 입출력

#### 입력 조건
> 입력은 여러 개의 테스트 케이스로 이루어져 있다. <br> 
> 각 테스트 케이스의 첫째 줄에는 장소의 수 N (2 ≤ N ≤ 500)과 도로의 수 M (1 ≤ M ≤ 104)가 주어진다. <br> 
> 장소는 0부터 N-1번까지 번호가 매겨져 있다. 둘째 줄에는 시작점 S와 도착점 D가 주어진다. (S ≠ D; 0 ≤ S, D < N) <br> 
> 다음 M개 줄에는 도로의 정보 U, V, P가 주어진다. (U ≠ V ; 0 ≤ U, V < N; 1 ≤ P ≤ 103) 이 뜻은 U에서 V로 가는 도로의 길이가 P라는 뜻이다. <br> 
> U에서 V로 가는 도로는 최대 한 개이다. 또, U에서 V로 가는 도로와 V에서 U로 가는 도로는 다른 도로이다.  <br> 
> 입력의 마지막 줄에는 0이 두 개 주어진다. <br>
#### 출력 조건
> 각 테스트 케이스에 대해서, 거의 최단 경로의 길이를 출력한다. <br>
> 만약, 거의 최단 경로가 없는 경우에는 -1을 출력한다. <br>
---
#### 예제 입력 1
```
7 9
0 6
0 1 1
0 2 1
0 3 2
0 4 3
1 5 2
2 6 4
3 6 2
4 6 4
5 6 1
4 6
0 2
0 1 1
1 2 1
1 3 1
3 2 1
2 0 3
3 0 2
6 8
0 1
0 1 1
0 2 2
0 3 3
2 5 3
3 4 2
4 1 1
5 1 1
3 0 1
0 0
```
#### 예제 출력 1
```
5
-1
6
```

---
#### 예제 입력 2
```
6 9
0 5
0 1 1
1 2 1
2 5 1
0 3 1
3 4 1
4 5 1
0 2 10
2 3 10
3 5 10
4 5
0 2
0 1 1
0 3 5
1 2 2
1 3 1
3 2 1
5 3
0 4
0 1 1
0 2 1
0 3 1
0 0
```
#### 예제 출력 2
```
30
-1
-1
```

---
#### 예제 입력 3
```
6 8
0 5
0 1 1
1 2 1
2 3 1
3 4 1
4 5 1
0 2 2
2 5 10
0 5 5
5 6
0 4
0 1 10
0 2 1
2 1 2
1 3 1
3 4 2
1 4 5
8 11
0 7
0 1 1
0 2 1
1 3 1
2 3 3
3 4 1
4 7 1
4 6 2
3 5 1
5 6 2
5 7 1
6 7 1
0 0
```
#### 예제 출력 3
```
-1
15
-1
```

---


<br>

### 문제풀이 전략
- 문제 유형
  - 그래프, 데이크스트라

- 다익스트라 최단 경로 알고리즘을 수행한다.
- 다익스트라 최단 경로에 포함되는 **모든 간선을 추적**해야 한다.
- 초기 최단 경로에 포함된 간선을 제외한 뒤에, **다시 최단 경로를 탐색**하면 된다.

#### 문제풀이 핵심 아이디어




### 답안 전체코드

#### 답안 1
> 수정필요 틀렸음
```py
import heapq
import sys

input = sys.stdin.readline
def dijkstra(그래프, 시작노드, 도착노드):
    최단거리저장 = {노드: [float('inf'), 시작노드] for 노드 in 그래프}
    최단거리저장[시작노드] = [0, 시작노드]

    최소힙 = []
    heapq.heappush(최소힙, [최단거리저장[시작노드][0], 시작노드])

    while 최소힙:
        현재노드까지의최단거리, 현재노드 = heapq.heappop(최소힙)
        # 최단거리에 저장된 거리가 더 짧다면 수행 필요없음
        if 최단거리저장[현재노드][0] < 현재노드까지의최단거리:
            continue
        for 다음노드, 현재노드와다음노드의거리 in 그래프[현재노드].items():
            다음노드까지의최단거리 = 현재노드와다음노드의거리 + 현재노드까지의최단거리
            if 다음노드까지의최단거리 < 최단거리저장[다음노드][0]:
                최단거리저장[다음노드] = [다음노드까지의최단거리, 현재노드]
                heapq.heappush(최소힙, [다음노드까지의최단거리, 다음노드])

    경로 = [도착노드]
    역추적노드 = 도착노드
    while 최단거리저장[역추적노드][1] != 시작노드:
        경로.append(최단거리저장[역추적노드][1])
        역추적노드 = 최단거리저장[역추적노드][1]
    경로.append(시작노드)
    경로 = list(reversed(경로))
    return 최단거리저장, 경로

종료조건 = 1
while 종료조건 == 1:
    answer=0
    장소의수, 도로의수 = map(int,input().split())
    if (장소의수+도로의수)==0:
        종료조건=0
        continue
    시작점S, 도착점D = map(int,input().split())
    graph = {node : {} for node in range(장소의수)}
    for _ in range(도로의수):
        장소u, 장소v, u에서v의거리 = map(int, input().split())
        graph[장소u][장소v] = u에서v의거리
    #최초 최단경로를 탐색한다.
    최단경로테이블, 경로 = dijkstra(graph, 시작점S, 도착점D)
    if 최단경로테이블[도착점D][0] == float('inf'):
        print(-1)
        continue
    #현재 최단경로를 저장한다.
    최초최단경로길이 = 최단경로테이블[도착점D][0]
    #최단경로가 같은경우를 탐색한다.
    while 최초최단경로길이 == 최단경로테이블[도착점D][0]:
        for index in range(len(경로)-1):
            정점a,정점b = 경로[index],경로[index+1]
            #최단경로를 삭제한다.
            del graph[정점a][정점b]
        #최단 경로를 삭제후 다시 최단경로를 찾는다.
        최단경로테이블, 경로 = dijkstra(graph, 시작점S, 도착점D)
        answer = 최단경로테이블[도착점D][0]
        if answer == float('inf'):
            answer=-1
            continue
    print(answer)
```
#### 답안2
> 나동빈님 풀이
```python
from collections import deque
import heapq
import sys
input = sys.stdin.readline
def dijkstra():
    heap_data = []
    heapq.heappush(heap_data, (0, start))
    distance[start] = 0
    while heap_data:
        dist, now = heapq.heappop(heap_data)
        if distance[now] < dist:
            continue
        for i in adj[now]:
            cost = dist + i[1]
            if distance[i[0]] > cost and not dropped[now][i[0]]:
                distance[i[0]] = cost
                heapq.heappush(heap_data, (cost, i[0]))
def bfs():
    q = deque()
    q.append(end)
    while q:
        now = q.popleft()
        if now == start:
            continue
        for prev, cost in reverse_adj[now]:
            if distance[now] == distance[prev] + cost:
                dropped[prev][now] = True
                q.append(prev)


while True:
    n, m = map(int, input().split())
    if n == 0:
        break
    start, end = map(int, input().split())
    adj = [[] for _ in range(n + 1)]
    reverse_adj = [[] for _ in range(n + 1)]
    for _ in range(m):
        x, y, cost = map(int, input().split())
        adj[x].append((y, cost))
        reverse_adj[y].append((x, cost))
    dropped = [[False] * (n + 1) for _ in range(n + 1)]
    distance = [1e9] * (n + 1)
    dijkstra()
    bfs()
    distance = [1e9] * (n + 1)
    dijkstra()
    if distance[end] != 1e9:
        print(distance[end])
    else:
        print(-1)
```