
# [백준 1260번 DFS와 BFS](https://www.acmicpc.net/problem/1260)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_2.svg" width="20">  백준 1260번 DFS와 BFS  


| 시간제한 | 메모리제한 | 정답비율 | 난이도  | 
|:----:|:-----:|:----:|:----:|
|  2초  | 128MB | 36%  | 실버2  |

---

### 문제

<br> 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
<br> 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
<br> 정점 번호는 1번부터 N번까지이다.


### 예제 입출력

#### 입력 조건
> 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. <br> 
> 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.<br>
> 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.<br>
> 입력으로 주어지는 간선은 양방향이다.<br>
#### 출력 조건
> 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. <br>
> V부터 방문된 점을 순서대로 출력하면 된다. <br>
---
#### 예제 입력 1
```
4 5 1
1 2
1 3
1 4
2 4
3 4
```
#### 예제 출력 1
```
1 2 4 3
1 2 3 4
```

---
#### 예제 입력 2
```
5 5 3
5 4
5 2
1 2
3 4
3 1
```
#### 예제 출력 2
```
3 1 2 5 4
3 1 4 2 5
```

---
#### 예제 입력 3
```
1000 1 1000
999 1000
```
#### 예제 출력 3
```
1000 999
1000 999
```

---
#### 예제 입력 4
```
5 5 1
1 2
2 3
3 1
1 4
3 5
```
#### 예제 출력 4
```
1 2 3 5 4
1 2 3 4 5
```

---
#### 예제 입력 5
```
15 14 1
1 2
1 3
2 4
2 5
3 6
3 7
4 8
4 9
5 10
5 11
6 12
6 13
7 14
7 15
```
#### 예제 출력 5
```
1 2 4 8 9 5 10 11 3 6 12 13 7 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
```

---
#### 예제 입력 6
```
4 5 1
2 3
4 3
2 3
3 4
4 2
```
#### 예제 출력 6
```
1
1
```

---


<br>

### 문제풀이 전략
- 문제 유형
  - 그래프, 그래프 탐색, 깊이 우선 탐색, 너비 우선 탐색


#### 문제풀이 핵심 아이디어

* 기본적인 형태의 그래프를 단순히 DFS와 BFS로 탐색한다.
* 이 문제에서는 '정점 번호가 작은 것'을 먼저 방문해야 한다.
* 모든 노드와 간선을 차례대로 조회하여 O(N+M)의 시간 복잡도로 문제를 해결해야 한다.
* 국내 코딩 테스트 합격을 위해서는 이 문제 정도는 매우 빠르게 풀 수 있도록 숙달해야한다.
* 큐 구현을 위해 collections 라이브러리의 deque를 사용한다.


### 답안 전체코드

```py
from collections import defaultdict, deque
n, m, v = map(int, input().split())
graph = defaultdict(list)
graphDFS = defaultdict(list)
# 그래프 생성
for _ in range(m):
    A, B = map(int, input().split())
    graph[A].append(B)
    graph[B].append(A)
# 작은 수부터 처리하기 위한 정렬작업
for _ in graph.keys():
  #BFS는 큐이기 때문에 오름차순정렬
    graph[_] = set(sorted(graph[_]))
  #DFS는 스택이기 때문에 내림차순 정렬 (maxIndex 부터 빠지니 maxIndex가 낮아야함)
    graphDFS[_] = sorted(graph[_],reverse=True)

# 너비 우선 탐색
def BFS(graph, startNode):
    result = []
    visited = deque([startNode])
    while visited:
        node = visited.popleft()
        if node not in result:
            result.append(node)
            visited.extend(graph[node])
    return result
# 깊이 우선 탐색
def DFS(graph, startNode):
    result = []
    visited = deque([startNode])
    while visited:
        node = visited.pop()
        if node not in result:
            result.append(node)
            visited.extend(graph[node])
    return result
# 출력
print(" ".join(str(x) for x in DFS(graphDFS,v)))
print(" ".join(str(x) for x in BFS(graph,v)))
```
