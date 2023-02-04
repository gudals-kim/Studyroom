
# [백준 9663번 N-Queen](https://www.acmicpc.net/problem/9663)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_4.svg" width="20"> 백준 9663번 N-Queen 


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  10초  | 128MB | 46%  | 골드4 |

---

### 문제


<br> N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
<br> 
<br> N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.


### 예제 입출력

#### 입력 조건
> 첫째 줄에 N이 주어진다. (1 ≤ N < 15)  <br>
#### 출력 조건
> 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다. <br>

---

#### 예제 입력 1
```
8
```
#### 예제 출력 1
```
92
```

---


<br>

### 문제풀이 전략
> 대표적인 백트래킹 문제이다.
- 문제 유형
  - 백트래킹, 브루트포스 알고리즘

- Dfs를 이용해서 백트래킹 알고리즘을 구현할 수 있다.

#### 문제풀이 핵심 아이디어
> 각 행을 차례대로 확인하면서, 각 열에 퀸을 놓는 경우를 고려한다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_9663_1.png?raw=true">

1. 첫번째 행의 첫번째 열에 퀸을 놓는다.
2. 두번째 행으로 커서를 옮긴다.
3. 두번째 행의 모든 열을 탐색하면서, 현재 위치에 퀸을 놓을 수 있는 지 확인한다.
  - 퀸을 놓을 수 있는 지 확인하는 방법
    - 같은 열에 퀸이 있는지 확인한다.
    - 대각선에 퀸이 있는지 확인한다.
4. 놓을 수 있다면, 퀸을 놓고 다음 열로 넘어간다.
5. 다음 행으로 넘어간다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_9663_2.png?raw=true">


### 답안 전체코드

```py
def check(x):
    #이전 행에서 놓았던 모든 Queen들을 확인한다.
    for i in range(x):
        # 위쪽 혹은 대각선을 확인
        if row[x] == row[i]:
            return False
        if abs(row[x]-row[i])== x-i:
            return False
    return True

# x번째 행에 대하여 처리
def dfs(x):
    global result
    if x == n:
        result += 1
    else:
        #x번째 행의 각 열에 Queen을 둔다고 가정한다.
        for i in range(n):
            row[x] = i
            #해당 위치에 Queen을 두어도 괜찮은 경우
            if check(x):
                # 다음행으로 넘어간다.
                dfs(x+1)
n = int(input())
row = [0] * n
result = 0
dfs(0)
print(result)
```
