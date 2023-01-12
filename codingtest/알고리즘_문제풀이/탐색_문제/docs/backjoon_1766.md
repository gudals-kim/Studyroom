
# [백준 1766번 문제집](https://www.acmicpc.net/problem/1766)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_2.svg" width="20">  백준 1766번 문제집  


| 시간제한 | 메모리제한  | 정답비율 | 난이도 | 
|:----:|:------:|:----:|:---:|
|  2초  | 128MB  | 47%  | 골드2 |

---

### 문제

<br> 민오는 1번 부터 N번 까지 총 N개의 문제로 되어 있는 문제집을 풀려고 한다.
<br> 문제는 난이도 순서로 출제되어 있다.
<br> 즉 1번 문제가 가장 쉬운 문제이고, N번 문제가 가장 어려운 문제가 된다.
<br> 
<br> 어떤 문제부터 풀까 고민하면서 문제를 훑어보던 민오는, 몇몇 문제들 사이에는 '먼저 푸는 것이 좋은 문제'가 있다는 것을 알게 되었다.
<br> 
<br> 예를들어 1번 문제를 풀고나면 4번 문제가 쉽게 풀린다거나 하는 식이다.
<br> 민오는 다음의 세가지 조건에 따라 문제를 풀 순서를 정하기로 하였다.

1. N개의 문제는 모두 풀어야 한다.
2. 먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 먼저 풀어야한다.
3. 가능하면 쉬운 문제부터 풀어야 한다.


<br> 예를 들어서 네 개의 문제가 있다고 하자.
<br> 4번 문제는 2번 문제보다 먼저 푸는 것이 좋고, 3번 문제는 1번 문제보다 먼저 푸는 것이 좋다고 하자.
<br> 만일 4-3-2-1의 순서로 문제를 풀게 되면 조건 1과 조건 2를 만족한다.  
<br> 하지만 조건 3을 만족하지 않는다. 4보다 3을 충분히 먼저 풀 수 있기 때문이다.
<br> 따라서 조건 3을 만족하는 문제 풀이 순서는 3-1-4-2가 된다.
<br> 
<br> 문제의 개수와 먼저 푸는 것이 좋은 문제에 대한 정보가 주어졌을 때, 주어진 조건을 만족하면서 민오가 풀 문제의 순서를 결정해 주는 프로그램을 작성하시오.

### 예제 입출력

#### 입력 조건
> 첫째 줄에 문제의 수 N(1<=N<=32,000)와 먼저 푸는 것이 좋은 문제에 대한 정보의 개수 M(1<=M<=100,000)이 주어진다.<br> 
> 둘째 줄부터 M개의 줄에 걸쳐 두 정수의 순서쌍 A,B가 빈칸을 사이에 두고 주어진다.<br>
> 이는 A번 문제는 B번 문제보다 먼저 푸는 것이 좋다는 의미이다. <br>
> 항상 문제를 모두 풀 수 있는 경우만 입력으로 주어진다. <br>
#### 출력 조건
> 첫째 줄에 문제 번호를 나타내는 1 이상 N 이하의 정수들을 민오가 풀어야 하는 순서대로 빈칸을 사이에 두고 출력한다. <br>
---
#### 예제 입력 1
```
4 2
4 2
3 1
```
#### 예제 출력 1
```
3 1 4 2
```

---

#### 예제 입력 2
```
5 3
4 1
3 1
5 3
```
#### 예제 출력 2
```
2 4 5 3 1
```

---

#### 예제 입력 3
```
5 4
5 4
4 3
3 2 
2 1
```
#### 예제 출력 3
```
5 4 3 2 1
```

---

#### 예제 입력 4
```
5 4
4 1
5 1
2 5 
3 5
```
#### 예제 출력 4
```
2 3 4 5 1
```
---


<br>

### 문제풀이 전략
- 문제 유형
  - 자료 구조, 그래프, 우선순위 큐, 위상 정렬

#### 문제풀이 핵심 아이디어
- 이 문제는 전형적인 위상 정렬 문제입니다.
- 위상 정렬은 ***순서가 정해져 있는 작업***을 차례로 수행해야 할 때, 순서를 결정해주는 알고리즘입니다.
- 위상 정렬의 시간 복잡도는 O(V+E)로 문제를 해결할 수 있습니다.

#### 위상정렬(Topology sort) 알고리즘

1. 진입 차수가 0인 정점을 큐에 삽입한다.
2. 큐에서 원소를 꺼내 해당 원소와 간선을 제거한다.
3. 제거 이후에 진입 차수가 0이 된 정점을 큐에 삽입한다.
4. 큐가 빌 때 까지 2) - 3) 과정을 반복한다.

- ***사이클이 존재한다면 위상정렬은 사용하지 못한다.***
  * 모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재하는 것이다.
  * 모든 원소를 방문했다면 큐에서 꺼낸 순서가 위상 정렬의 결과이다.


##### step 1
> 진입 차수가 0인 정점(루트 노드)를 큐에 삽입한다.

* 그래프
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1766_1.png?raw=true">
* 큐
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1766_2.png?raw=true">

#### step 2
> 큐에서 원소를 꺼내 해당 원소와 간선을 제거한다.

* 그래프
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1766_4.png?raw=true">
* 큐 
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1766_3.png?raw=true">

#### step 3
>  제거 이후에 진입 차수가 0이 된 정점을 큐에 삽입한다.

* 그래프
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1766_5.png?raw=true">
* 큐 
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1766_6.png?raw=true">
  
#### step 4
> 큐가 빌 때까지 반복한다.


### 답안 전체코드

```py
import heapq
n, m = map(int, input().split())
array = [[] for i in range(n+1)]
indegree = [0] * (n+1)

heap = []
result = []

for _ in range(m):
    x, y = map(int, input().split())
    array[x].append(y)
    indegree[y]+=1
for i in range(1, n+1):
    if indegree[i]==0:
        heapq.heappush(heap, i)
while heap:
    data = heapq.heappop(heap)
    result.append(data)
    for y in array[data]:
        indegree[y] -= 1
        if indegree[y] == 0:
            heapq.heappush(heap,y)

print(" ".join(map(str,result)))
```
