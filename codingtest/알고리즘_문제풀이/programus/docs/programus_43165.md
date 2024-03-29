
# [프로그래머스 43165번 타겟넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=python3)

## <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/rank/level_2.png?raw=true" width="150"> 프로그래머스 43165번 타겟넘버 


| 시간제한 | 메모리제한 | 정답비율 |  난이도   | 
|:----:|:-----:|:----:|:------:|
|  2초  | 128MB | 44%  | level2 |

---

### 문제

<br> n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
<br> 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

```
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
```

<br> 사용할 수 있는 숫자가 담긴 배열과 타겟넘버가 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 찾는 프로그램을 작성해주세요.




### 예제 입출력

#### 입력 조건
> 첫번째 줄에 배열의 개수 n이 주어진다. n은 2 이상 20 이하입니다.  <br>
> 두번째 줄에 사용할 수 있는 숫자가 담긴 배열이 공백을 기준으로 나누어 주어진다. 각 숫자는 1 이상 50 이하인 자연수입니다.  <br>
> 세번째 줄에 타겟넘버가 주어진다. 타겟 넘버는 1 이상 1000 이하인 자연수입니다.  <br>
  #### 출력 조건
> 타겟 넘버를 만드는 방법의 수를 출력한다. <br>

---

#### 예제 입력 1
```
5
1 1 1 1 1
3
```
#### 예제 출력 1
```
5
```

---
#### 예제 입력 2
```
4
4 1 2 1
4
```
#### 예제 출력 2
```
2
```

---

<br>

### 문제풀이 전략

- dfs, bfs

#### 문제풀이 핵심 아이디어
> 다음 인덱스에 해당하는 nubers 원소를 더하거나 빼서 자식 노드로 붙여서 이어간다.

- 예) numbers = [1,1,1,1,1]
  - 1(index 0)
    - +1(index 1) => 2
      - +1(index 2) => 3
      - -1(index 2) => -1
    - -1(index 1) => 0 
  - -1(index 0)
...

- 이런식으로 노드를 탐색해 간다.

### 답안 전체코드

```py
from collections import deque
n = int(input())
numbers = list(map(int,input().split()))
target = int(input())

def solution(numbers, target):
    answer = 0
    queue = deque()
    n = len(numbers)
    queue.append([numbers[0], 0])
    queue.append([-1 * numbers[0], 0])
    while queue:
        node, idx = queue.popleft()
        idx += 1
        if idx < n:
            queue.append([node + numbers[idx], idx])
            queue.append([node - numbers[idx], idx])
        else:
            if node == target:
                answer += 1
    return answer

print(solution(numbers, target))
```
