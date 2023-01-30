
# [백준 1012번 유기농 배추](https://www.acmicpc.net/problem/1012)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_2.svg" width="20">  백준 1012번 유기농 배추  


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  1초  | 512MB | 	37%  | 실버2 |

---

### 문제

<br> 차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다.  
<br> 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다.  
<br> 이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다.
<br> 특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다.
<br> 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
<br> 
<br> 한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다.
<br> 배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.  
<br> 예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다.
<br> 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.
<br> 

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1012_1.png?raw=true">


### 예제 입출력
   
#### 입력 조건
> 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.<br>
> 그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다.<br>
> 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.<br>
> 두 배추의 위치가 같은 경우는 없다.<br>

#### 출력 조건
> 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.<br>
---
#### 예제 입력 1
```
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
```
#### 예제 출력 1
```
5
1
```

---
#### 예제 입력 2
```
1
5 3 6
0 2
1 2
2 2
3 2
4 2
4 0
```
#### 예제 출력 2
```
2
```

---
#### 예제 입력 3
```
1
3 3 3
0 0
0 1
1 0
```
#### 예제 출력 3
```
1
```

---
#### 예제 입력 4
```
1
7 7 33
0 0
0 1
0 2
0 3
0 4
0 5
0 6
1 0
1 6
2 0
2 2
2 3
2 4
2 6
3 0
3 2
3 4
3 6
4 0
4 2
4 3
4 4
4 6
5 0
5 6
6 0
6 1
6 2
6 3
6 4
6 5
6 6
3 1
```
#### 예제 출력 4
```
1
```

---
#### 예제 입력 5
```
1
2 3 5
0 0
1 0
1 1
1 2
0 2
```
#### 예제 출력 5
```
1
```

---

<br>

### 문제풀이 전략
- 문제 유형
  - 그래프, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

- 연결 요소의 개수를 세는 문제입니다.
- 모든 정점에 대하여 DFS 및 BFS를 수행하고 한 번 방문한 정점은 다시 확인하지 않습니다.
- 전체적으로 DFS 및 BFS를 수행한 총 횟수를 계산합니다.
- DFS 및 BFS 응용 문제 중에서 출제 비중이 매우 높은 유형입니다.
- DFS로 문제를 푸는 경우, sys 라이브러리의 setrecursionlimit() 함수 설정을 해줄 필요가 있습니다.

#### 문제풀이 핵심 아이디어

- 모든 정점에 대해서 dfs 및 bfs를 수행 이후 각 정점별 탐색 여부를 체크한다.

### 답안 전체코드
#### 답안1
```python
from collections import defaultdict, deque
import sys
input = sys.stdin.readline

#bfs 코드
def bfs(graph,startNode):
    result = set() #차집합을 사용하기 때문에 set 자료형으로 반환한다.
    visited = deque([startNode])
    while visited:
        node = visited.popleft()
        if node not in result:
            result.add(node)
            visited.extend(graph[node])
    return result


for _ in range(int(input())):
  #graph 생성 코드
    m, n, k = map(int, input().split()) 
    real=list()
    graph = defaultdict(set)
    # 배추가 심어진 좌표를 real에 담는다.
    for __ in range(k):
        x, y = map(int,input().split())
        real.append((x,y))
    for ex in real:
        x,y = ex
        #배추가 심어진곳에서 상하좌우로 탐색한다. + 본인 좌표도 추가해야함
        for ex2 in [(x,y+1),(x-1,y),(x,y),(x+1,y),(x,y-1)]:
          #상하좌우에 배추가 심어져 있다면 그래프에 추가한다.
            if ex2 in real:
                graph[ex].add(ex2)
                graph[ex2].add(ex)
    
    #그래프의 모든 key(배추가 심어진 곳)에서 붙어 있는 곳(그래프로 연결된 곳)을 찾아 차집합으로 빼준다.
    array = set(graph.keys())
    count = 0
    while array:
        node = array.pop()
        array = array - bfs(graph,node)
        count+=1
    print(count)
```

#### 답안2
```python
import sys
sys.setrecursionlimit(100000)

def dfs(x,y):
    visited[x][y] = True
    directions = [(-1,0), (1,0), (0,-1), (0,1)]
    for dx, dy in directions:
        nx, ny = x + dx, y + dy
        if nx < 0 or nx >= n or ny < 0 or ny>=m:
            continue
        if array[nx][ny] and not visited[nx][ny]:
            dfs(nx, ny)

for _ in range(int(input())):
    m, n, k = map(int, input().split())        
    array = [[0]* m for _ in range(n)]
    visited = [[False] * m for _ in range(n)]
    for _ in range(k):
        y, x = map(int, input().split())
        array[x][y] = 1
    result = 0
    for i in range(n):
        for j in range(m):
            if array[i][j] and not visited[i][j]:
                dfs(i,j)
                result += 1
    print(result)
```