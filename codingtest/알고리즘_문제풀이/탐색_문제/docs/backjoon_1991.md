
# [백준 1991번 트리 순회](https://www.acmicpc.net/problem/1991)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_1.svg" width="20">  백준 1991번 트리 순회   


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  2초  | 128MB | 66%  | 실버1 |

---

### 문제

<br> 이진 트리를 입력받아
<br> 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)
<br> 의 결과를 출력하는 프로그램을 작성하시오
<br>   <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1991_1.png?raw=true">

* 예를들어 위와 같은 이진 트리가 입력되면,
  - 전위 순회한 결과 : ABDCEFG//(루트)(왼쪽 자식)(오른쪽 자식)
  - 중위 순회한 결과 : DBAECFG//(왼쪽 자식)(루트)(오른쪽 자식)
  - 후위 순회한 결과 : DBEGFCA//(왼쪽 자식)(오른쪽 자식)(루트)

### 예제 입출력

#### 입력 조건
> 첫째 줄에는 이진트리의 노드의 개수 N(1<=N<=26)이 주어진다.<br> 
> 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. <br> 
> 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. <br> 
> 자식 노드가 없는 경우에는 . 으로 표현한다. <br> 
#### 출력 조건
> 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셀째 줄에 후위 순회한 결과를 출력한다. <br>
> 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다. <br>
---
#### 예제 입력 1
```
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
```
#### 예제 출력 1
```
ABDCEFG
DBAECFG
DBEGFCA
```
---



<br>

### 문제풀이 전략
- 문제 유형
  - 트리, 재귀


#### 문제풀이 핵심 아이디어
- 전위 순회 : 루트 -> 왼쪽 -> 오른쪽
- 중위 순회 : 왼쪽 -> 루트 -> 오른쪽
  - 중위 순회의 특징 
    - 트리를 왼쪽부터 순서대로 읽으면 그게 순회 순서이다.
- 후위 순회 : 왼쪽 -> 오른쪽 -> 루트

> 재귀적으로 구현해야하기 때문에 재귀 개념을 명확하게 이해해야한다.



### 답안 전체코드

```py
import sys
n = int(input())
tree = {}

class Node:
  def __init__(self, data, left_node, right_node):
    self.data = data
    self.left_node = left_node
    self.right_node = right_node
def 전위순회(node):
  print(node.data, end='')
  if node.left_node != '.':
    전위순회(tree[node.left_node])
  if node.right_node != '.':
    전위순회(tree[node.right_node])
def 중위순회(node):
  if node.left_node != '.':
    중위순회(tree[node.left_node])
  print(node.data, end='')
  if node.right_node != '.':
    중위순회(tree[node.right_node])
def 후위순회(node):
  if node.left_node != '.':
    후위순회(tree[node.left_node])
  if node.right_node != '.':
    후위순회(tree[node.right_node])
  print(node.data, end='')

for i in range(n):
  data, left_node, right_node = input().split()
  tree[data] = Node(data, left_node, right_node)
전위순회(tree['A'])
print()
중위순회(tree['A'])
print()
후위순회(tree['A'])

```
