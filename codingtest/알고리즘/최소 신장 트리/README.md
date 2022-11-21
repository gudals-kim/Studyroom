# 신장트리(Spanning Tree)

## 1.신장트리란?

* Spanning Tree, 또는 신장트리라고 불린다.
* 원래의 그래프의 모든 노드가 연결되어 있으면서, 트리의 속성을 만족하는 그래프
* 신장 트리의 조건
    - 본래의 그래프의 모든 노드를 포함해야함
    - 모든 노드가 서로 연결되야함
    - 트리의 속성을 만족시킴(사이클이 존재하지 않음)

<img src="https://www.fun-coding.org/00_Images/spanningtree.png">

## 2. 최소신장트리(Minimum Spanning Tree(MST))

* Minimum Spanning Tree(MST)
* 간선의 가중치 합이 최소인 신장트리를 지친한다.

<img src="https://www.fun-coding.org/00_Images/mst.png" width=600>

## 3. 최소 신장 트리 알고리즘

* 그래프에서 최소 시장트리를 찾을 수 있는 알고리즘이 존재한다.

### 대표적인 최소 신장 트리 알고리즘

<details>
<summary> [크루스칼 알고리즘] </summary>

# 크루스칼 알고리즘

## 구현방법

1. 모든 정점을 독립적인 집합으로 만든다.
2. 모든 간선을 비용의 기준으로 정렬한다.
3. 비용이 작은 간선부터 양 끝의 두 정점을 비교한다.
4. 두 정점의 최상위 정점을 확인하고, 서로 다를 경우 두 정점을 연결한다.

> 탐욕 알고리즘을 기초로 하고 있다.

<img src="https://www.fun-coding.org/00_Images/kruscal_internal1.png" width=650>

<img src="https://www.fun-coding.org/00_Images/kruscal_internal2.png" width=800>

## Union-Find 알고리즘

* ***Disjoint Set***을 표현할 때 사용하는 알고리즘으로 트리 구조를 활용하는 알고리즘
    - 노드들 중에 연결된 노드를 찾거나, 노드들을 서로 연결할 때 사용한다.
* ***Disjoint Set***이란?
    - 서로 중복되지 않는 부분 집합으로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료 구조
    - 공통 원소가 없는 상호 배타적인 부분 집합들로 나눠진 원소들에 대한 자료구조를 의마한다.
    - Disjoint Set = 서로소 집합 자료구조

### 구현방법

1. 초기화
    - n 개의 원소가 개별 집합으로 이뤄지도록 초기화한다.
    <img src="https://www.fun-coding.org/00_Images/initial_findunion.png" width=400>
2. Union
    - 두 개별 집합을 하나의 집합으로 합친다. (두 트리를 하나의 트리로 만든다.)
    <img src="https://www.fun-coding.org/00_Images/union_findunion.png" width=600>
3. Find
    - 여러 노드가 존재할 때, 두 개의 노드를 선택해서, 현재 두 노드가 서로 같은 그래프에 속하는지 판별하기 위해, 각 그룹의 최상단 원소(루트노드)를 확인한다.
    <img src="https://www.fun-coding.org/00_Images/find_findunion.png" width=500>

### 구현시 주의사항

- Union 순서에 따라서, 최악의 경우 링크드 리스트와 같은 형태가 될 수 있음.
- 이 때는 Find/Union 시 계산량이 O(N) 이 될 수 있으므로, 해당 문제를 해결하기 위해, union-by-rank, path compression 기법을 사용함 

<img src="https://www.fun-coding.org/00_Images/worst_findunion.png" width=200>

## union-by-rank 기법

* 각 트리에 대한 높이(rank)를 변수에 기억한다.
* Union시 두 트리의 높이(rank)가 다르면, 높이가 작은 트리를 높이가 큰 트리에 붙인다.

<img src="https://www.fun-coding.org/00_Images/unionbyrank_findunion.png" width=700>

* 높이가 h-1 인 두개의 트리를 합칠 때는 한쪽 트리 높이를 1 증가시켜준 후 큰 트리에 붙인다.

<img src="https://www.fun-coding.org/00_Images/unionbyranksame_findunion.png" width=700>

### union-by-rank 기법 사용시 시간복잡도(O(log N))
- 초기화시, 모든 원소는 높이(rank) 가 0 인 개별 집합인 상태에서, 하나씩 원소를 합칠 때, union-by-rank 기법을 사용한다면,
    - 높이가 h 인 트리가 만들어지려면, 높이가 h - 1 인 두 개의 트리가 합쳐져야 함
    - 높이가 h - 1 인 트리를 만들기 위해 최소 n개의 원소가 필요하다면, 높이가 h 인 트리가 만들어지기 위해서는 최소 2n개의 원소가 필요함
    - 따라서 union-by-rank 기법을 사용하면, union/find 연산의 시간복잡도는 O(N) 이 아닌, $ O(log{N}) $ 로 낮출 수 있음

## path compression 기법

* Find를 실행한 노드에서 거쳐간 노드를 루트에 다이렉트로 연결하는 기법
* Find를 실행한 노드는 이후부터는 루트 노드를 한번에 알 수 있다.

<img src="https://www.fun-coding.org/00_Images/pathcompression_findunion.png" width=400>

### path compression 기법까지 사용시 시간복잡도(O(1) 근사치)

- union-by-rank 와 path compression 기법 사용시 시간 복잡도는 다음 계산식을 만족함이 증명되었음
  - $ O(M log^*{N}) $
  - $ log^*{N} $ 은 다음 값을 가짐이 증명되었음
    - N이 $ 2^{65536} $ 값을 가지더라도, $ log^*{N} $ 의 값이 5의 값을 가지므로, 거의 O(1), 즉 상수값에 가깝다고 볼 수 있음

<div style="text-align:left">
<table>
  <tr>
    <th style="text-align:center">N</th>
    <th style="text-align:center">$ log^*{N} $</th>
  </tr>
  <tr>
    <td style="text-align:left">1</td>
    <td style="text-align:left">0</td>
  </tr>
  <tr>
    <td style="text-align:left">2</td>
    <td style="text-align:left">1</td>
  </tr>
  <tr>
    <td style="text-align:left">4</td>
    <td style="text-align:left">2</td>
  </tr>
  <tr>
    <td style="text-align:left">16</td>
    <td style="text-align:left">3</td>
  </tr>
  <tr>
    <td style="text-align:left">65536</td>
    <td style="text-align:left">4</td>
  </tr>
  <tr>
    <td style="text-align:left">$ 2^{65536} $</td>
    <td style="text-align:left">5</td>
  </tr>
</table>
</div>

## 크루스칼 알고리즘 파이썬 구현

### 크루스칼 알고리즘

```python
부모 = dict() #'노드' : '부모노드' 
rank = dict() #'노드' : 높이

def kruskal(그래프):
    최소신장트리 = list()

    # 1. 초기화(독립적인 집합)
    for 노드 in 그래프['노드']:
        make_set(노드)

    # 2. 가중치 기준 최소로 sorting
    간선들 = 그래프['간선']
    간선들.sort()

    # 3. 간선 연결(사이클 없이)
    for 간선 in 간선들:
        가중치, 시작노드, 도착노드 = 간선
        # 루트노드가 같지 않다면
        if find(시작노드) != find(도착노드):
            union(시작노드, 도착노드)
            최소신장트리.append(간선)

    return 최소신장트리
```

### 초기화(독립적인 집합)

```py
# 부모노드 자기 자신, 높이가 0이면 독립적인 노드라고 할 수 있다.
def make_set(노드):
    부모[노드] = 노드
    rank[노드] = 0
```

### path compression 기법 (find 함수)

```py
def find(노드):
    # path compression 기법
    # 모두 부모노드를 직통할수 있게 만듬
    if 부모[노드] != 노드:
        부모[노드] = find(부모[노드])
    return 부모[노드]
```

### union-by-rank

```py
def union(시작노드,도착노드):
    root_시작노드 = find(시작노드)
    root_도착노드 = find(도착노드)

    #union-by-rank 기법
    #루트노드가 더 높은곳으로 합치는것
    if rank[root_시작노드] > rank[root_도착노드]:
        부모[root_도착노드] = root_시작노드
    else:
        부모[root_시작노드] = root_도착노드
        if rank[root_시작노드] == rank[root_도착노드]:
            rank[root_도착노드] += 1

```

## 크루스칼 알고리즘 시간복잡도(O(1))

- 크루스컬 알고리즘의 시간 복잡도는 O(E log E)
  - 다음 단계에서 2번, 간선을 비용 기준으로 정렬하는 시간에 좌우됨 (즉 간선을 비용 기준으로 정렬하는 시간이 가장 큼)
  1. 모든 정점을 독립적인 집합으로 만든다.
  2. 모든 간선을 비용을 기준으로 정렬하고, 비용이 작은 간선부터 양 끝의 두 정점을 비교한다.
     - 퀵소트를 사용한다면 시간 복잡도는 O(n log n) 이며, 간선이 n 이므로 O(E log E)
  3. 두 정점의 최상위 정점을 확인하고, 서로 다를 경우 두 정점을 연결한다. (최소 신장 트리는 사이클이 없으므로, 사이클이 생기지 않도록 하는 것임)
     - union-by-rank 와 path compression 기법 사용시 시간 복잡도가 결국 상수값에 가까움, O(1)

<img src="https://www.fun-coding.org/00_Images/kruscal_time.png">

</details>


<details>
<summary> [프림 알고리즘] </summary>

# 프림 알고리즘(Prim's algorithm)

## 1. 프림 알고리즘이란

* 대표적인 최소 신장 트리 알고리즘 중 하나이다.
* 탐욕 알고리즘을 기초로 하고 있다.
* 시작 정점을 선택한 후, 정점에 인접한 간선 중 최소 간선으로 연결된 정점을 선택, 해당 정점에서 다시 최소 간선으로 연결된 정점을 선택하는 방식으로 최소 신장트리를 확장해 나가는 방식

## 2. 프림 알고리즘의 동작 방식

1. 임의의 정점을 선택, '연결된 노드 집합'에 넣는다.
2. 선택된 정점에 연결된 간선들을 '간선 리스트'에 넣는다.
3. '간선 리스트'에서 최소 가중치를 가지는 간선부터 추출한다.(최소heap구조)
    - 해당 간선에 연결된 정점이 '연결된 노드 집합'에 이미 들어 있다면, 추출하지 않는다.(최소 신장 트리는 cycle이 생기면 안된다.)
    - 해당 간선에 연결된 정점이 '연결된 노드 집합'에 들어 있지 않다면, 해당 간선을 선택하고, 해당 간선 정보를 '최소 신장 트리'에 넣는다.
4. 추출한 간선은 '간선 리스트'에서 제거한다.
   - (힙 구조에서는 pop으로 꺼내면 힙에서 삭제되니 추출되지 않은 간선을 다시 '간선리스트에' push한다.)
5. '간선 리스트'에 더 이상의 간선이 없을 때까지 3번과 4번을 반복한다.

    <img src="https://www.fun-coding.org/00_Images/prim1.png" width=800>
    <img src="https://www.fun-coding.org/00_Images/prim2.png" width=800>
    <img src="https://www.fun-coding.org/00_Images/prim3.png" width=800>

## 3. 프림 알고리즘 파이썬 코드 작성

> 간선 정보 (가중치,노드A,노드B)
```python
간선들 = [
    (7, 'A', 'B'), (5, 'A', 'D'),
    (8, 'B', 'C'), (9, 'B', 'D'), (7, 'B', 'E'),
    (5, 'C', 'E'),
    (7, 'D', 'E'), (6, 'D', 'F'),
    (8, 'E', 'F'), (9, 'E', 'G'),
    (11, 'F', 'G')
]
```
> 프림알고리즘 파이썬 구현
```python
from collections import defaultdict
import heapq


def 프림알고리즘(시작노드, 간선들):
    최소신장트리 = list()
    노드입력간선출력 = defaultdict(list)

    for 가중치, 노드A, 노드B in 간선들:
        노드입력간선출력[노드A].append((가중치, 노드A, 노드B))
        노드입력간선출력[노드B].append((가중치, 노드B, 노드A))

    연결된노드집합 = set(시작노드) # 1. 임의의 정점을 선택, '연결된 노드 집합'에 넣는다.
    간선리스트 = 노드입력간선출력[시작노드] # 2. 선택된 정점에 연결된 간선들을 '간선 리스트'에 넣는다.
    heapq.heapify(간선리스트) # 최소heap
    
    while 간선리스트: #5. '간선 리스트'에 더 이상의 간선이 없을 때까지 3번과 4번을 반복한다.
        가중치, 노드A, 노드B = heapq.heappop(간선리스트) #3. '간선 리스트'에서 최소 가중치를 가지는 간선부터 추출한다.(최소heap구조)
        if 노드B not in 연결된노드집합: #3-1. 해당 간선에 연결된 정점이 '연결된 노드 집합'에 들어 있지 않다면, 
            연결된노드집합.add(노드B) # 연결을 했으니, '연결된 노드 집합'에 넣는다.
            최소신장트리.append((가중치, 노드A, 노드B))# 해당 간선 정보를 '최소 신장 트리'에 넣는다.
            #4. 추출한 간선은 '간선리스트'에서 제거한다.
            #(힙 구조에서는 pop으로 꺼내면 힙에서 삭제 된다.
            for 간선 in 노드입력간선출력[노드B]:
                #노드B가 시작노드가 된다. 노드B에 연결된 간선 정보를 가져온다.
                if 간선[2] not in 연결된노드집합:# 연결된 노드가 아닌 노드만 간선리스트에 넣는다.
                    heapq.heappush(간선리스트, 간선)
                    
    return 최소신장트리
```
> 출력
```python
print(프림알고리즘('A', 간선들))

출력 > [(5, 'A', 'D'),
 (6, 'D', 'F'),
 (7, 'A', 'B'),
 (7, 'B', 'E'),
 (5, 'E', 'C'),
 (9, 'E', 'G')]

```


## 프림 알고리즘 시간복잡도 O(ElogE)
  - 최악의 경우, while 구문에서 모든 간선에 대해 반복하고, 최소 힙 구조를 사용하므로 O($ElogE$) 시간 복잡도를 가짐

---

### [부록] 조금더 개선된 프림 알고리즘

- 간선이 아닌 노드를 중심으로 우선순위 큐를 적용하는 방식
  - 초기화 - 정점:key 구조를 만들어놓고, 특정 정점의 key값은 0, 이외의 정점들의 key값은 무한대로 놓음.  모든 정점:key 값은 우선순위 큐에 넣음
  - 가장 key값이 적은 정점:key를 추출한 후(pop 하므로 해당 정점:key 정보는 우선순위 큐에서 삭제됨), (extract min 로직이라고 부름)
  - 해당 정점의 인접한 정점들에 대해 key 값과 연결된 가중치 값을 비교하여 key값이 작으면 해당 정점:key 값을 갱신
    - 정점:key 값 갱신시, 우선순위 큐는 최소 key값을 가지는 정점:key 를 루트노드로 올려놓도록 재구성함 (decrease key 로직이라고 부름)

- 개선된 프림 알고리즘 구현시 고려 사항
  - 우선순위 큐(최소힙) 구조에서, 이미 들어가 있는 데이터의 값 변경시, 최소값을 가지는 데이터를 루트노드로 올려놓도록 재구성하는 기능이 필요함
  - 구현 복잡도를 줄이기 위해, heapdict 라이브러리를 통해, 해당 기능을 간단히 구현

> 개선된 프림 알고리즘 파이썬 구현
```python
from heapdict import heapdict

def prim(graph, start):
    mst, keys, pi, total_weight = list(), heapdict(), dict(), 0
    for node in graph.keys():
        keys[node] = float('inf')
        pi[node] = None
    keys[start], pi[start] = 0, start

    while keys:
        current_node, current_key = keys.popitem()
        mst.append([pi[current_node], current_node, current_key])
        total_weight += current_key
        for adjacent, weight in mygraph[current_node].items():
            if adjacent in keys and weight < keys[adjacent]:
                keys[adjacent] = weight
                pi[adjacent] = current_node
    return mst, total_weight
```
> 출력
```python

mygraph = {
    'A': {'B': 7, 'D': 5},
    'B': {'A': 7, 'D': 9, 'C': 8, 'E': 7},
    'C': {'B': 8, 'E': 5},
    'D': {'A': 5, 'B': 9, 'E': 7, 'F': 6},
    'E': {'B': 7, 'C': 5, 'D': 7, 'F': 8, 'G': 9},
    'F': {'D': 6, 'E': 8, 'G': 11},
    'G': {'E': 9, 'F': 11}    
}
mst, total_weight = prim(mygraph, 'A')
print ('MST:', mst)
print ('Total Weight:', total_weight)

출력 > MST: [['A', 'A', 0], ['A', 'D', 5], ['D', 'F', 6], ['A', 'B', 7], ['D', 'E', 7], ['E', 'C', 5], ['E', 'G', 9]]
출력 > Total Weight: 39
```

### 개선된 프림 알고리즘의 시간복잡도 O(ElogV)
- 최초 key 생성 시간 복잡도: $ O(V) $
- while 구문과 keys.popitem() 의 시간 복잡도는 $ O(VlogV) $
  - while 구문은 V(노드 갯수) 번 실행됨
  - heap 에서 최소 key 값을 가지는 노드 정보 추출 시(pop)의 시간 복잡도: $ O(logV) $
- for 구문의 총 시간 복잡도는 $ O(ElogV) $
  - for 구문은 while 구문 반복시에 결과적으로 총 최대 간선의 수 E만큼 실행 가능 $ O(E) $
  - for 구문 안에서 key값 변경시마다 heap 구조를 변경해야 하며, heap 에는 최대 V 개의 정보가 있으므로 $ O(logV) $
    > 일반적인 heap 자료 구조 자체에는 본래 heap 내부의 데이터 우선순위 변경시, 최소 우선순위 데이터를 루트노드로 만들어주는 로직은 없음. 이를 decrease key 로직이라고 부름, 해당 로직은 heapdict 라이브러리를 활용해서 간단히 적용가능
- 따라서 총 시간 복잡도는 $ O(V + VlogV + ElogV) $ 이며,
- O(V)는 전체 시간 복잡도에 큰 영향을 미치지 않으므로 삭제,
- E > V 이므로 (최대 $ V^2 = E $ 가 될 수 있음), $ O((V + E)logV) $ 는 간단하게 $ O(ElogV) $ 로 나타낼 수 있음

</details>

<br>
<br>
<br>
<br>

---