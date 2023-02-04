
# [백준 1987번 알파벳](https://www.acmicpc.net/problem/1987)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_4.svg" width="20"> 백준 1987번 알파벳 


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  2초  | 256MB | 29%  | 골드4 |

---

### 문제


<br> 세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다.
<br> 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.
<br> 
<br> 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
<br> 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데,  즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
<br> 
<br> 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오.
<br> 말이 지나는 칸은 좌측 상단의 칸도 포함된다. 



### 예제 입출력

#### 입력 조건
> 첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1 ≤ R,C ≤ 20)  <br>
> 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.  <br>
#### 출력 조건
> 첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다. <br>

---

#### 예제 입력 1
```
2 4
CAAB
ADCB
```
#### 예제 출력 1
```
3
```

---
#### 예제 입력 2
```
3 6
HFDFFB
AJHGDH
DGAGEH
```
#### 예제 출력 2
```
6
```

---
#### 예제 입력 3
```
5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH
```
#### 예제 출력 3
```
10
```

---

<br>

### 문제풀이 전략
- 문제 유형
  - 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 백트래킹



#### 문제풀이 핵심 아이디어
> 지금까지 지나온 모든 칸에 적혀 있는 알파벳과 다른 알파벳이 적힌 칸으로 이동해야 한다.


### 답안 전체코드

```py
import sys
input = sys.stdin.readline
# 이동 좌표 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def bfs(x, y):
    global result
    # 동일한 경우는 한 번만 계산하기 위하여 집합(Set) 자료형 사용
    q = set()
    q.add((x, y, array[x][y]))
    while q:
        x, y, step = q.pop()
        # 가장 긴 이동 거리를 저장
        result = max(result, len(step))
        # 네 방향 (상, 하, 좌, 우)으로 이동하는 경우를 각각 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 이동할 수 있는 위치이면서, 새로운 알파벳인 경우
            if (0 <= nx and nx < r and 0 <= ny and ny < c and
                array[nx][ny] not in step):
                q.add((nx, ny, step + array[nx][ny]))
# 전체 보드 데이터를 입력 받습니다.
r, c = map(int, input().split())
array = [input() for _ in range(r)]
# 백트래킹 수행 결과를 출력합니다.
result = 0
bfs(0, 0)
print(result)

```
