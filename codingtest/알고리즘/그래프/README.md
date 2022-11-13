# 그래프

## 1. 그래프(Graph) 란?

* 그래프는 실제 세계의 현상이나 사물을 정점(노드)와 간선으로 표현하기 위해 사용된다.

#### 예제 집에서 회사로 가는 경로를 그래프로 표현한 예

<img src="https://www.fun-coding.org/00_Images/graph.png" width=400>

<br>

### 1.1 그래프 용어

- ```노드 (Node)```: 위치를 말함, ```정점(Vertex)```라고도 함
- ```간선 (Edge)```: 위치 간의 관계를 표시한 선으로 노드를 연결한 선이라고 보면 됨 (link 또는 branch 라고도 함)
- 인접 정점 (Adjacent Vertex) : 간선으로 직접 연결된 정점(또는 노드)

- ***참고 용어***
  - 정점의 차수 (Degree): 무방향 그래프에서 하나의 정점에 인접한 정점의 수
  - 진입 차수 (In-Degree): 방향 그래프에서 외부에서 오는 간선의 수
  - 진출 차수 (Out-Degree): 방향 그래프에서 외부로 향하는 간선의 수
  - 경로 길이 (Path Length): 경로를 구성하기 위해 사용된 간선의 수
  - 단순 경로 (Simple Path): 처음 정점과 끝 정점을 제외하고 중복된 정점이 없는 경로
  - 사이클 (Cycle): 단순 경로의 시작 정점과 종료 정점이 동일한 경우

<br>

### 1.2 그래프 종류

#### 무방향 그래프 (Undirected Graph)
- 방향이 없는 그래프
- 간선을 통해, 노드는 양방향으로 갈 수 있음
- 보통 노드 A, B가 연결되어 있을 경우, (A, B) 또는 (B, A) 로 표기
- <img src="https://www.fun-coding.org/00_Images/undirectedgraph.png" width=300>

#### 방향 그래프 (Directed Graph)
- 간선에 방향이 있는 그래프
- 보통 노드 A, B가 A -> B 로 가는 간선으로 연결되어 있을 경우, <A, B> 로 표기 (<B, A> 는 B -> A 로 가는 간선이 있는 경우이므로 <A, B> 와 다름)
- <img src="https://www.fun-coding.org/00_Images/directedgraph.png" width=300>

#### 가중치 그래프 (Weighted Graph) 또는 네트워크 (Network)
- 간선에 비용 또는 가중치가 할당된 그래프
- <img src="https://www.fun-coding.org/00_Images/weightedgraph.png" width=300>

#### 연결 그래프 (Connected Graph) 와 비연결 그래프 (Disconnected Graph)
- 연결 그래프 (Connected Graph)
  - 무방향 그래프에 있는 모든 노드에 대해 항상 경로가 존재하는 경우
- 비연결 그래프 (Disconnected Graph)
  - 무방향 그래프에서 특정 노드에 대해 경로가 존재하지 않는 경우
  - <img src="https://www.fun-coding.org/00_Images/disconnectedgraph.png" width=300>

#### 사이클 (Cycle) 과 비순환 그래프 (Acyclic Graph)
- 사이클 (Cycle)
  - 단순 경로의 시작 노드와 종료 노드가 동일한 경우
- 비순환 그래프 (Acyclic Graph)
  - 사이클이 없는 그래프
  - <img src="https://www.fun-coding.org/00_Images/acyclicgraph.png" width=300>

#### 완전 그래프 (Complete Graph)
- 그래프의 모든 노드가 서로 연결되어 있는 그래프
- <img src="https://www.fun-coding.org/00_Images/completegraph.png" width=300>

<br>

### 1.3 그래프와 트리의 차이

- 트리는 그래프 중에 속한 특별한 종류라고 볼 수 있음

<div style="text-align:left">
<table>
  <tr>
    <th></th>
    <th style="text-align:center">그래프</th>
    <th style="text-align:center">트리</th>
  </tr>
  <tr>
    <td style="text-align:center">정의</td>
    <td style="text-align:left">노드와 노드를 연결하는 간선으로 표현되는 자료 구조</td>
    <td style="text-align:left">그래프의 한 종류, 방향성이 있는 비순환 그래프</td>
  </tr>
  <tr>
    <td style="text-align:center">방향성</td>
    <td style="text-align:left">방향 그래프, 무방향 그래프 둘다 존재함</td>
    <td style="text-align:left">방향 그래프만 존재함</td>
  </tr>
  <tr>
    <td style="text-align:center">사이클</td>
    <td style="text-align:left">사이클 가능함, 순환 및 비순환 그래프 모두 존재함</td>
    <td style="text-align:left">비순환 그래프로 사이클이 존재하지 않음</td>
  </tr>
  <tr>
    <td style="text-align:center">루트 노드</td>
    <td style="text-align:left">루트 노드 존재하지 않음</td>
    <td style="text-align:left">루트 노드 존재함</td>
  </tr>
  <tr>
    <td style="text-align:center">부모/자식 관계</td>
    <td style="text-align:left">부모 자식 개념이 존재하지 않음</td>
    <td style="text-align:left">부모 자식 관계가 존재함</td>
  </tr>
</table>
</div>

<br>

## 2. 그래프를 활용한 알고리즘

<details>
<summary> [BFS(넓이우선탐색)과 DFS(깊이우선탐색)] </summary>

### 2.1 BFS 와 DFS 란?
* 대표적인 그래프 **탐색** 알고리즘
  - 너비 우선 탐색 (Breadth First Search): 정점들과 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 탐색하는 방식
  - 깊이 우선 탐색 (Depth First Search): 정점의 자식들을 먼저 탐색하는 방식

#### 2.1 BFS/DFS 방식 이해를 위한 예제
- BFS 방식: A - B - C - D - G - H - I - E - F - J 
  - 한 단계씩 내려가면서, 해당 노드와 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 순회함
- DFS 방식: A - B - D - E - F - C - G - H - I - J 
  - 한 노드의 자식을 타고 끝까지 순회한 후, 다시 돌아와서 다른 형제들의 자식을 타고 내려가며 순화함

<img src="https://www.fun-coding.org/00_Images/BFSDFS.png" width=700>

#### 2.2 파이썬으로 그래프를 표현하는 방법
- 파이썬에서 제공하는 딕셔너리와 리스트 자료 구조를 활용해서 그래프를 표현할 수 있음

#### 2.3 그래프 예와 파이썬 표현

 * ```BFS(넓이우선탐색)```
<img src="https://www.fun-coding.org/00_Images/bfsgraph.png" width=700>

* ```DFS(깊이우선탐색)```
<img src="https://www.fun-coding.org/00_Images/dfsgraph.png" width=700>

<br>

```python
graph = dict()

graph['A'] = ['B', 'C']
graph['B'] = ['A', 'D']
graph['C'] = ['A', 'G', 'H', 'I']
graph['D'] = ['B', 'E', 'F']
graph['E'] = ['D']
graph['F'] = ['D']
graph['G'] = ['C']
graph['H'] = ['C']
graph['I'] = ['C', 'J']
graph['J'] = ['I']

```

### 2.2 BFS(넓이우선탐색) 알고리즘 구현

- 자료구조 큐를 활용함
  - need_visit 큐와 visited 큐, 두 개의 큐를 생성
  
<img src="https://www.fun-coding.org/00_Images/bfsqueue.png" width=700>

- 큐의 구현은 간단히 파이썬 리스트를 활용
- graph는 딕셔너리 자료형

```python
#입력

def bfs(graph, start_node):
    result = list()
    visited = list()

    visited.append(start_node)

    while visited:
        node = visited.pop(0)
        if node not in result:
            result.append(node)
            visited.extend(graph[node])
    
    return result
```
```python

print(bfs(graph,'A'))

#출력
> ['A', 'B', 'C', 'D', 'G', 'H', 'I', 'E', 'F', 'J']
```
<img src="https://www.fun-coding.org/00_Images/bfsgraph.png" width=700>

#### 2.2.1 BFS 시간 복잡도

- 일반적인 BFS 시간 복잡도
  - 노드 수: V
  - 간선 수: E
    - 위 코드에서 while need_visit 은 V + E 번 만큼 수행함
  - 시간 복잡도: O(V + E)

<br>

### 2.3 DFS(깊이우선탐색) 알고리즘 구현

- 자료구조 스택과 큐를 활용함
  - need_visit 스택과 visited 큐, 두 개의 자료 구조를 생성

> BFS 자료구조는 두 개의 큐를 활용하는데 반해, DFS 는 스택과 큐를 활용한다는 차이가 있음을 인지해야 함

- 큐와 스택 구현은 별도 라이브러리를 활용할 수도 있지만, 간단히 파이썬 리스트를 활용할 수도 있음

```python
#입력
def dfs(graph, start_node):
    result = list()
    visited = list()

    visited.append(start_node)

    while visited:
        node = visited.pop()
        if node not in result:
            result.append(node)
            visited.extend(graph[node])
    
    return result
```

```python
#출력
print(dfs(graph,'A'))

> ['A', 'C', 'I', 'J', 'H', 'G', 'B', 'D', 'F', 'E']
```

<img src="https://www.fun-coding.org/00_Images/dfsgraph.png" width=700>

### 2.3.1 DFS(깊이우선탐색)의 시간복잡도

- 일반적인 DFS 시간 복잡도
  - 노드 수: V
  - 간선 수: E
    - 위 코드에서 while need_visit 은 V + E 번 만큼 수행함
  - 시간 복잡도: O(V + E)

</details>

<details>
<summary> [최단경로 알고리즘(다익스트라 알고리즘)] </summary>

# 그래프 최단경로 알고리즘

## 최단 경로 문제란?

* 최단 경로 문제란 두 노드를 잇는 가장 짧은 경로를 찾는 문제이다.
* ``가중치 그래프(Weighted Graph)`` 에서 ``간선(Edge)``의 ``가중치 합이 최소``가 되도록 하는 경로를 찾는것이 목표이다.

## 최단 경로 문제 종류

1. 단일 출발 및 단일 도착(single-source and single-destination shortest path problem) 최단 경로 문제
      * 그래프 내의 특정 노드 u 에서 출발, 또 다른 특정 노드 v에 도착하는 가장 짧은 경로를 찾는 문제

2. 단일 출발(single-source shortest path problem) 최단 경로 문제
      * 그래프 내의 특정 노드 u와 그래프 내 다른 모든 노드 각각의 가장 짧은 경로를 찾는 문제
> 명확히 말하면, 예를 들어 A,B,C,D 라는 노드를 가진 그래프에서 특정 노드를 A라고 한다면, A외 모든 노드인 B,C,D 각 노드와 A 간에 (즉, A-B,A-C,A-D) 각각 가장 짧은 경로를 찾는 문제를 의미한다. 단일 도착을 찾는 알고리즘을 포함한다고 볼 수 있다.

3. 전체 쌍(all-pair) 최단 경로
      * 그래프 내의 모든 노드 쌍(u,v)에 대한 최단 경로를 찾는 문제

## 대표적인 최단 경로 알고리즘 - 다익스트라 알고리즘

* 다익스트라 알고리즘은 위의 최단 경로 문제 종류 중, 2번에 해당한다.
  * 하나의 정점에서 다른 모든 정점 간의 각각 ***가장 짧은 거리***를 구하는 문제

### 다익스트라 알고리즘 로직

* ***첫 정점을 기준으로 연결되어 있는 정점들을 추가해 가며, 최단 거리를 갱신하는 기법***

  - 첫 정점부터 각 노드간의 거리를 저장하는 배열을 만든 후, 첫 정점의 인접 노드 간의 거리부터 먼저 계산하면서, 첫 정점부터 해당 노드간의 가장 짧은 거리를 해당 배열에 업데이트한다.

  - 다익스트라 알고리즘은 너비우선탐색(bfs)와 유사하다.
    * 첫 정점부터 각 노드간의 거리를 저장하는 배열을 만든 후, 첫 정점의 인접 노드 간의 거리부터 먼저 계산하면서, 첫 정점부터 해당 노드간의 가장 짧은 거리를 해당 배열에 업데이트한다.

### 우선순위큐를 활용한 다익스트라 알고리즘

* 우선순위 큐는 **MinHeap** 방식을 활용해서, **현재 가장 짧은 거리를 가진 노드 정보를 먼저 꺼내게 된다.**

#### 다익스트라 알고리즘 구현방법

1. 첫 정점을 기준으로 배열을 선언하여, 첫 정점에서 각 정점까지의 거리를 저장한다.
    - 초기에는 첫 정점의 거리는 0, 나머지는 무한대로 젖아함(inf)
    - 우선순위 큐에 (첫 정점, 거리 0) 을 넣는다.
2. 우선순위 큐에서 노드를 꺼낸다.
    - 첫음에는 첫 정점만 저장되어 있으므로, 첫 시작점이 꺼내진다.
    - 첫 정점에 인접한 노드를 각각에 대해, **첫 정점에서 각 노드로 가는 거리**와 **현재 배열에 저장되어 있는 첫 정점에서 각 정점까지의 거리**를 ``비교``한다.
    - ``비교`` 후 **더 짧은 거리가 탐색이 된다면, 배열에 업데이트**한다.
    - 배열에 해당 노드의 거리가 업데이트가 된 경우, 우선순위 큐에 넣는다.
      - 결과적으로 bfs와 유사하게 첫 정점에 인접한 노드들을 순차적으로 방문한다.
    - ``비교`` 후 만약 배열에 기록된 현재까지 발견된 가장 짧은 거리보다, 더 긴 거리(루트)를 가진 (노드,거리)의 경우에는 해당 노드와 인접한 노드간의 거리를 계산하지 않는다.
3. 우선순위 큐에 꺼낼 노드가 없을 때 까지 반복한다.

### 다익스트라 알고리즘 그림으로 이해하기

<img src="https://www.fun-coding.org/00_Images/dijkstra.png" width=300>

### 1단계: 초기화 설명
- 첫 정점을 기준으로 배열을 선언하여 첫 정점에서 각 정점까지의 거리를 저장
   - 초기에는 첫 정점의 거리는 0, 나머지는 무한대로 저장함 (inf 라고 표현함)
   - 우선순위 큐에 (첫 정점, 거리 0) 만 먼저 넣음 
<img src="https://www.fun-coding.org/00_Images/dijkstra_initial.png">

### 2단계: 우선순위 큐에서 꺼낸 노드와 거리비교 설명
- 우선순위 큐에서 노드를 꺼냄
     - 처음에는 첫 정점만 저장되어 있으므로, 첫 정점이 꺼내짐
     - 큐에서 꺼낸 노드의 인접한 노드들 각각에 대해, **첫 정점에서 각 노드로 가는 거리**와 현재 배열에 저장되어 있는 **첫 정점에서 각 정점까지의 거리**를 ``비교``한다.
     - 배열에 저장되어 있는 거리보다, 첫 정점에서 해당 노드로 가는 거리가 더 짧을 경우, 배열에 해당 노드의 거리를 업데이트한다.
     - 배열에 해당 노드의 거리가 업데이트된 경우, 우선순위 큐에 넣는다.
       - 결과적으로 너비 우선 탐색 방식과 유사하게, 첫 정점에 인접한 노드들을 순차적으로 방문하게 됨
       - 만약 배열에 기록된 현재까지 발견된 가장 짧은 거리보다, 더 긴 거리(루트)를 가진 (노드, 거리)의 경우에는 해당 노드와 인접한 노드간의 거리 계산을 하지 않음
       
> 이전 표에서 보듯이, 첫 정점 이외에 모두 inf 였었으므로, 첫 정점에 인접한 노드들은 모두 우선순위 큐에 들어가고, 첫 정점과 인접한 노드간의 거리가 배열에 업데이트됨

<img src="https://www.fun-coding.org/00_Images/dijkstra_1st.png">

### 3단계: 우선순위 큐에서 (C, 1) [노드, 첫 노드와의 거리] 를 기반으로 인접한 노드와의 거리 계산
- 우선순위 큐가 MinHeap(최소 힙) 방식이므로, 위 표에서 넣어진 (C, 1), (D, 2), (B, 8) 중 (C, 1) 이 먼저 추출됨 (pop)
- 위 표에서 보듯이 1단계까지의 A - B 최단 거리는 8 인 상황임
  - A - C 까지의 거리는 1, C 에 인접한 B, D에서 C - B는 5, 즉 A - C - B 는 1 + 5 = 6 이므로, A - B 최단 거리 8보다 더 작은 거리를 발견, 이를 배열에 업데이트
    - 배열에 업데이트했으므로 B, 6 (즉 A에서 B까지의 현재까지 발견한 최단 거리) 값이 우선순위 큐에 넣어짐
  - C - D 의 거리는 2, 즉 A - C - D 는 1 + 2 = 3 이므로, A - D의 현재 최단 거리인 2 보다 긴 거리, 그래서 D 의 거리는 업데이트되지 않음

<img src="https://www.fun-coding.org/00_Images/dijkstra_2nd.png">

### 4단계: 우선순위 큐에서 (D, 2) [노드, 첫 노드와의 거리] 를 기반으로 인접한 노드와의 거리 계산
- 지금까지 접근하지 못했던 E와 F 거리가 계산됨
  - A - D 까지의 거리인 2 에 D - E 가 3 이므로 이를 더해서 E, 5
  - A - D 까지의 거리인 2 에 D - F 가 5 이므로 이를 더해서 F, 7

<img src="https://www.fun-coding.org/00_Images/dijkstra_3rd.png">

### 5단계: 우선순위 큐에서 (E, 5) [노드, 첫 노드와의 거리] 를 기반으로 인접한 노드와의 거리 계산
- A - E 거리가 5인 상태에서, E에 인접한 F를 가는 거리는 1, 즉 A - E - F 는 5 + 1 = 6, 현재 배열에 A - F 최단거리가 7로 기록되어 있으므로, F, 6 으로 업데이트
  - 우선순위 큐에 F, 6 추가

<img src="https://www.fun-coding.org/00_Images/dijkstra_3-2th.png">

### 6단계: 우선순위 큐에서 (B, 6), (F, 6) 를 순차적으로 추출해 각 노드  기반으로 인접한 노드와의 거리 계산
- 예제의 방향 그래프에서 B 노드는 다른 노드로 가는 루트가 없음 
- F 노드는 A 노드로 가는 루트가 있으나, 현재 A - A 가 0 인 반면에 A - F - A 는 6 + 5 = 11, 즉 더 긴 거리이므로 업데이트되지 않음

<img src="https://www.fun-coding.org/00_Images/dijkstra_4th.png">

### 7단계: 우선순위 큐에서 (F, 7), (B, 8) 를 순차적으로 추출해 각 노드  기반으로 인접한 노드와의 거리 계산
- A - F 로 가는 하나의 루트의 거리가 7 인 상황이나, 배열에서 이미 A - F 로 가는 현재의 최단 거리가 6인 루트의 값이 있는 상황이므로, 더 긴거리인 F, 7 루트 기반 인접 노드까지의 거리는 계산할 필요가 없음, 그래서 계산없이 스킵함
  - 계산하더라도 A - F 거리가 6인 루트보다 무조건 더 긴거리가 나올 수 밖에 없음
- B, 8 도 현재 A - B 거리가 6이므로, 인접 노드 거리 계산이 필요 없음. 

> 우선순위 큐를 사용하면 불필요한 계산 과정을 줄일 수 있음

<img src="https://www.fun-coding.org/00_Images/dijkstra_5th.png">

### 우선순위 큐 사용 장점
- 지금까지 발견된 가장 짧은 거리의 노드에 대해서 먼저 계산
- 더 긴 거리로 계산된 루트에 대해서는 계산을 스킵할 수 있음

### 참고: heapq 라이브러리 활용을 통해 우선순위 큐 사용하기
- 데이터가 리스트 형태일 경우, 0번 인덱스를 우선순위로 인지, 우선순위가 낮은 순서대로 pop 할 수 있음

### 파이썬으로 다익스트라 알고리즘 구현

```py
#입력
import heapq
#graph : 그래프
#start : 시작정점
#end : 도착정점
def dijkstra(graph, start, end):
    
    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    queue = []
    heapq.heappush(queue, [distances[start], start])
    
    while queue:
        current_distance, current_node = heapq.heappop(queue)
        
        if distances[current_node] < current_distance:
            continue
            
        for adjacent, weight in graph[current_node].items():
            distance = current_distance + weight
            
            if distance < distances[adjacent]:
                distances[adjacent] = distance
                heapq.heappush(queue, [distance, adjacent])
#start -> end 경로 부분 추가
    path = end
    path_output = end + '->'
    while distances[path][1] != start:
        path_output += distances[path][1] + '->'
        path = distances[path][1]
    path_output += start
    print (path_output)
    return distances

#테스트 코드

graph = {
    'A': {'B': 8, 'C': 1, 'D': 2},
    'B': {},
    'C': {'B': 5, 'D': 2},
    'D': {'E': 3, 'F': 5},
    'E': {'F': 1},
    'F': {'A': 5}
}

print(dijkstra(graph, 'A'))
```
```py
#출력
> "F->E->D->A"
> {'A': 0, 'B': 6, 'C': 1, 'D': 2, 'E': 5, 'F': 6}
```

### 다익스트라 알고리즘 시간복잡도

### 5. 시간 복잡도 $ O(Elog{E}) $

- 위 다익스트라 알고리즘은 크게 다음 두 가지 과정을 거침
  - 과정1: 각 노드마다 인접한 간선들을 모두 검사하는 과정
  - 과정2: 우선순위 큐에 노드/거리 정보를 넣고 삭제(pop)하는 과정
  
- 각 과정별 시간 복잡도
  - 과정1: 각 노드는 최대 한 번씩 방문하므로 (첫 노드와 해당 노드간의 갈 수 있는 루트가 있는 경우만 해당), 그래프의 모든 간선은 최대 한 번씩 검사
    - 즉, 각 노드마다 인접한 간선들을 모두 검사하는 과정은 O(E) 시간이 걸림, E 는 간선(edge)의 약자

  - 과정2: 우선순위 큐에 가장 많은 노드, 거리 정보가 들어가는 경우, 우선순위 큐에 노드/거리 정보를 넣고, 삭제하는 과정이 최악의 시간이 걸림
    - 우선순위 큐에 가장 많은 노드, 거리 정보가 들어가는 시나리오는 그래프의 모든 간선이 검사될 때마다, 배열의 최단 거리가 갱신되고, 우선순위 큐에 노드/거리가 추가되는 것임
    - 이 때 추가는 각 간선마다 최대 한 번 일어날 수 있으므로, 최대 O(E)의 시간이 걸리고, O(E) 개의 노드/거리 정보에 대해 우선순위 큐를 유지하는 작업은 $ O(log{E}) $ 가 걸림
      - 따라서 해당 과정의 시간 복잡도는 $ O(Elog{E}) $ 
    
### 총 시간 복잡도
  - 과정1 + 과정2 = O(E) + $ O(Elog{E}) $  = $ O(E + Elog{E}) = O(Elog{E}) $
  
### 참고: 힙의 시간 복잡도
- depth (트리의 높이) 를 h라고 표기한다면,
- n개의 노드를 가지는 heap 에 데이터 삽입 또는 삭제시, 최악의 경우 root 노드에서 leaf 노드까지 비교해야 하므로  h=log2n  에 가까우므로, 시간 복잡도는  O(logn)

</details>