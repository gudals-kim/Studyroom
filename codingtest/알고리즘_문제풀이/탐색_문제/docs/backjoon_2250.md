
# [백준 2250번 트리의 높이와 너비](https://www.acmicpc.net/problem/2250)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_2.svg" width="20">  백준 2250번 트리의 높이와 너비   


|  시간제한  | 메모리제한  | 정답비율  |  난이도   | 
|:------:|:------:|:-----:|:------:|
|   2초   | 128MB  |  27%  |  골드2   |

---

### 문제

<br> 이진 트리를 다음의 규칙에 따라 행과 열에 번호가 붙은 격자 모양의 틀 속에 그리려고한다.
<br> 이때 다음의 규칙에 따라 그린다.

1. 이진트리에서 같은 레벨(level)에 있는 노드는 같은 행에 위치한다.
2. 한 열에는 한 노드만 존재한다.
3. 임의의 노드의 왼쪽 부트리(left subtree)에 있는 노드들은 해당 노드보다 왼쪽의 열에 위치하고, 오른쪽 부트리(right subtree)에 있는 노드들은 해당 노드보다 오른쪽의 열에 위치한다.
4. 노드가 배치된 가장 왼쪽 열과 오른쪽 열 사이엔 아무 노드도 없이 비어있는 열은 없다.

<br> 이와 같은 규칙에 따라 이진트리를 그릴 때 각 레벨의 너비는 그 레벨에 할당된 노드 중 가장 오른쪽에 위치한 노드의 열 번호에서 가장 왼쪽에 위치한 노드의 열 번호를 뺀 값 더하기 1로 정의한다.
<br> 트리의 레벨은 가장 위쪽에 있는 루트 노드가 1이고 아래로 1씩 증가한다.
<br>  

- 아래 그림은 어떤 이진트리를 위의 규칙에 따라 그려본 것이다.
  - 첫번째 레벨의 너비는 1
  - 두 번째 레벨의 너비는 13
  - 세번째, 네번째 레벨의 너비는 각각 18
  - 다섯 번째 레벨의 너비는 13
  - 여섯 번재 레벨의 너비는 12

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_2250_1.png?raw=true">

<br> 우리는 주어진 이진트리를 위의 규칙에 따라 그릴 때에 너비가 가장 넓은 레벨과 그 레벨의 너비를 계산하려고한다.
<br> 위의 그림의 예에서 너비가 가장 넓은 레벨은 3번째와 4번째로 너비가 18이다.
<br> 너비가 가장 넓은 레벨이 두 개 이상 있을 때는 번호가 작은 레벨을 답으로 한다.
<br> 그로므로 이 예의 대한 답은 레벨은 3이고, 너비는 18이다.
<br>
<br> 임의의 이진트리가 입력으로 주어질 때 너비가 가장 넓은 레벨과 그 레벨의 너비를 출력하는 프로그램을 작성하시오.

### 예제 입출력

#### 입력 조건
> 첫째 줄에 노드의 개수를 나타내는 정수 N(1<= N <= 10,000)이 주어진다.<br> 
> 다음 N개의 줄에는 각 줄마다 노드 번호와 해당 노드의 왼쪽 자식 노드와 오른쪽 자식 노드의 번호가 순서대로 주어진다.<br>
> 노드들의 번호는 1부터 N까지이며, 자식이 없는 경우에는 자식 노드의 번호에 -1이 주어진다. <br>
#### 출력 조건
> 첫째 줄에 너비가 가장 넓은 레벨과 그 레벨의 너비를 순서대로 출력한다. <br>
> 너비가 가장 넓은 레벨이 두 개 이상 있을 때에는 번호가 작은 레벨을 출력한다. <br>
---
#### 예제 입력 1
```
19
1 2 3
2 4 5
3 6 7
4 8 -1
5 9 10
6 11 12
7 13 -1
8 -1 -1
9 14 15
10 -1 -1
11 16 -1
12 -1 -1
13 17 -1
14 -1 -1
15 18 -1
16 -1 -1
17 -1 19
18 -1 -1
19 -1 -1
```
#### 예제 출력 1
```
3 18
```
---



<br>

### 문제풀이 전략
- 문제 유형
  - 그래프, 트리, DFS
- 한국정보올림피아드 2003 고등부 1번 문제

#### 문제풀이 핵심 아이디어
- 중위 순회를 이용하면 X축 기준으로 왼쪽부터 방문한다는 특징이 있다.
- 이 문제는 중위 순회 알고리즘을 이용하고, 추가적으로 Level 값을 저장하도록 하여 문제를 해결 할 수 있다.

### 답안 전체코드

```py
class Node:
    def __init__(self, number, left_node, right_node):
        self.parent = -1
        self.number = number
        self.left_node = left_node
        self.right_node = right_node

def 중위순회(node, level):
    global level_depth, x
    level_depth = max(level_depth, level)
    if node.left_node != -1:
        중위순회(tree[node.left_node], level+1)
    level_min[level] = min(level_min[level], x)
    level_max[level] = max(level_max[level], x)
    x += 1
    if node.right_node != -1:
        중위순회(tree[node.right_node], level+1)

n = int(input())
tree = {}
level_min = [n]
level_max = [0]
root = -1
x = 1
level_depth = 1

for i in range(1, n + 1):
    tree[i] = Node(i, -1, -1)
    level_min.append(n)
    level_max.append(0)

for _ in range(n):
    number, left_node, right_node = map(int, input().split())
    tree[number].left_node = left_node
    tree[number].right_node = right_node
    if left_node != -1:
        tree[left_node].parent = number
    if right_node != -1:
        tree[right_node].parent = number

for i in range(1, n + 1):
    if tree[i].parent == -1:
        root = i

중위순회(tree[root], 1)

result_level = 1
result_width = level_max[1] - level_min[1] + 1
for i in range(2, level_depth + 1):
    width = level_max[i] - level_min[i] + 1
    if result_width < width:
        result_revel = i
        result_width = width
print(result_revel, result_width)
```
