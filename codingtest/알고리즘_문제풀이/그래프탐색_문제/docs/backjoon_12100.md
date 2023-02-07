
# [백준 12100번 2048(easy)](https://www.acmicpc.net/problem/12100)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_2.svg" width="20">  백준 12100번 2048(easy)  


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  1초  | 512MB | 25%  | 골드2 |

---

### 문제

 
2048 게임은 4×4 크기의 보드에서 혼자 즐기는 재미있는 게임이다. 이 [링크](https://play2048.co/)를 누르면 게임을 해볼 수 있다.
<br> 이 게임에서 한 번의 이동은 보드 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동시키는 것이다.
<br> 이때, 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다.
<br> 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다. (실제 게임에서는 이동을 한 번 할 때마다 블록이 추가되지만, 이 문제에서 블록이 추가되는 경우는 없다)
<br> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_12100_1.png?raw=true">
<br> <그림 1>의 경우에서 위로 블록을 이동시키면 <그림 2>의 상태가 된다. 여기서 왼쪽으로 블록을 이동시키면 <그림 3>의 상태가 된다.
<br> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_12100_2.png?raw=true">
<br> <그림 4>의 상태에서 블록을 오른쪽으로 이동시키면 <그림 5>가 되고, 여기서 다시 위로 블록을 이동시키면 <그림 6>이 된다. 여기서 오른쪽으로 블록을 이동시켜 <그림 7>을 만들 수 있다.
<br> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_12100_3.png?raw=true">
<br> <그림 8>의 상태에서 왼쪽으로 블록을 옮기면 어떻게 될까? 2가 충돌하기 때문에, 4로 합쳐지게 되고 <그림 9>의 상태가 된다.
<br> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_12100_4.png?raw=true">
<br> <그림 10>에서 위로 블록을 이동시키면 <그림 11>의 상태가 된다.
<br> <그림 12>의 경우에 위로 블록을 이동시키면 <그림 13>의 상태가 되는데, 그 이유는 한 번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없기 때문이다.
<br> <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_12100_5.png?raw=true">
<br> 마지막으로, 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다.
<br> 예를 들어, 위로 이동시키는 경우에는 위쪽에 있는 블록이 먼저 합쳐지게 된다. <그림 14>의 경우에 위로 이동하면 <그림 15>를 만든다.
<br>
<br> 
<br> 이 문제에서 다루는 2048 게임은 보드의 크기가 N×N 이다.
<br> 보드의 크기와 보드판의 블록 상태가 주어졌을 때, 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값을 구하는 프로그램을 작성하시오.

### 예제 입출력

#### 입력 조건
> 첫째 줄에 보드의 크기 N (1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 게임판의 초기 상태가 주어진다. <br>
> 0은 빈 칸을 나타내며, 이외의 값은 모두 블록을 나타낸다. 블록에 쓰여 있는 수는 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴이다. <br>
> 블록은 적어도 하나 주어진다. <br>
#### 출력 조건
> 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력한다. <br>
---
#### 예제 입력 
```
3
2 2 2
4 4 4
8 8 8
```
#### 예제 출력 
```
16
```

---



<br>

### 문제풀이 전략
- 문제 유형
  - 탐색, dfs, bfs


#### 문제풀이 핵심 아이디어
> 상하좌우 4가지 케이스를 5회 반복하니 4^5 = 1,024 회의 결과에서 최댓값을 구하면 된다.
- 배열을 합치는 문제이다.
- 특히 이렇게 배열을 합치는 문제는 상하좌우를 나누어서 생각하지 않는다.
  - 한 방향의 코드를 짜고 배열 자체를 90도 180도 270도로 돌려서 케이스를 나누는게 더 쉽다.
- 수행 이후 90도 180도 270도의 3가지 가지를 치면서 bfs로 탐색하면 된다.
  - 기존 상태(최댓값)와 자식노드의 최댓값이 같다면 가지를 끊어낸다.
### 답안 전체코드
```python
from copy import deepcopy

n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]

#rotate90() 90도 돌리기 함수
def rotate90(data, n):
    newData = deepcopy(data)
    for i in range(n):
        for j in range(n):
            newData[j][(n-i-1)] = data[i][j]
    return newData
def convert(열, n):
    #양수만 가져온다.
    합쳐진열 = [i for i in 열 if i]
    for i in range(1, len(합쳐진열)):
        if 합쳐진열[i-1] == 합쳐진열[i]:
            합쳐진열[i-1] *= 2
            합쳐진열[i] = 0
    합쳐진열 = [i for i in 합쳐진열 if i]
    return 합쳐진열 + [0] * (n-len(합쳐진열))
def dfs(n, data, count):
    #result는 현재 data 최댓값
    result = max([max(i) for i in data])
    #입력한 count가 0 회가 되면 result를 리턴하고 종료
    if count == 0:
        return result
    #상하좌우 4번을 돌려야한다.
    for _ in range(4):
        #data를 연산한다. 한 방향으로 배열 합치기
        newData = [convert(열, n) for 열 in data]
        if newData != data:
            # 이전과 같지 않다면 count를 1내리고 다시 dfs를 돌린다.
            result = max(result, dfs(n, newData, count-1))
        #배열을 90도로 돌린다.
        data = rotate90(data, n)
    return result


print(dfs(n, data, 5))
```