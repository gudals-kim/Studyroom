
# [백준 5719번 거의 최단 경로](https://www.acmicpc.net/problem/5719)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/platinum_5.svg" width="20">  백준 5719번 거의 최단 경로  


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  2초  | 512MB | 47%  | 골드4 |

---

### 문제
  

<br> 자유 시간이 많은 농부 John의 농장에 있는 소들은 종종 비디오 게임을 하며 시간을 보냅니다.
<br> 그들이 가장 좋아하는 것 중 하나는 Puyo Puyo라는 인기 있는 인간 비디오 게임을 기반으로 합니다. 
<br> 암소 버전은 물론 Mooyo Mooyo라고 불립니다.
<br> 
<br> Mooyo Mooyo 게임은 크고 좁은 그리드에서 진행됩니다.
<br> N 높이 (1 <= N <= 100)이다 N = 6, 너비가 10일때의 예시

```
0000000000
0000000300
0054000300
1054502230
2211122220
1111111223
```
  
   


<br> 각 셀은 비어 있거나(0으로 표시됨) 9가지 색상 중 하나의 건초 더미(문자 1..9로 표시됨)입니다.
<br> 중력으로 인해 건초더미가 아래로 떨어지므로 건초더미 아래에는 0 셀이 없습니다.
<br> 
<br> 두 개의 셀이 가로 또는 세로로 직접 인접하고 0이 아닌 동일한 색상을 갖는 경우 두 셀은 동일한 연결 영역에 속합니다.
<br> 연결된 지역이 적어도 K 셀, 건초더미가 모두 사라지고 0으로 변합니다.
<br>
<br> 이와 같이 연결된 영역이 동시에 여러 개 존재하면 모두 동시에 사라집니다.
<br> 그 후 중력으로 인해 건초더미가 아래로 떨어져 0이 된 결과 셀 중 일부를 채울 수 있습니다.
<br> 결과 구성에서 다시 적어도 크기의 연결된 영역이 있을 수 있습니다.
<br> K 세포. 그렇다면 그것들도 사라지고(동시에 그러한 영역이 여러 개 있는 경우) 중력이 나머지 셀을 아래로 끌어당기고 적어도 크기의 연결된 영역이 없을 때까지 프로세스가 반복됩니다.
<br> K 존재합니다.
<br> 
<br> Mooyo Mooyo 보드의 상태를 고려하여 이러한 작업이 발생한 후 보드의 최종 사진을 출력하십시오.


### 예제 입출력

#### 입력 조건
> 입력의 첫 줄에는 다음이 포함됩니다. <br> 
> N과 K(1 <= K <= 10N). 나머지 N 라인은 보드의 초기 상태를 지정합니다. 

#### 출력 조건
> 출력해주세요 최종 보드 상태의 그림을 설명하는 N줄. <br>
> 만약, 거의 최단 경로가 없는 경우에는 -1을 출력한다. <br>
---
#### 예제 입력 1
```
6 3
0000000000
0000000300
0054000300
1054502230
2211122220
1111111223
```
#### 예제 출력 1
```
0000000000
0000000000
0000000000
0000000000
1054000000
2254500000
```

---



<br>

### 문제풀이 전략
- 문제 유형
  - 그래프, bfs, dfs

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