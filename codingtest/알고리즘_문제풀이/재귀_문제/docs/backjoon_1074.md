
# [백준 1074번 Z](https://www.acmicpc.net/problem/1074)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_1.svg" width="20">  백준 1074번 Z


| 시간제한 | 메모리제한 | 정답비율 |  난이도  | 
|:----:|:-----:|:----:|:-----:|
| 0.5초 | 512MB | 39%  |  실버1  |

<br>

### 문제

<br>[문제]
<br>한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 
<br>예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
<br>

<img src="https://upload.acmicpc.net/21c73b56-5a91-43aa-b71f-9b74925c0adc/-/preview/" width="100">

<br>
<br>N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.
<br>다음 예는 22 × 22 크기의 배열을 방문한 순서이다.
<br>

<img src="https://upload.acmicpc.net/adc7cfae-e84d-4d5c-af8e-ee011f8fff8f/-/preview/" width="200">

<br>
<br>N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
<br>
<br>다음은 N=3일 때의 예이다.
<br>

<img src="https://upload.acmicpc.net/d3e84bb7-9424-4764-ad3a-811e7fcbd53f/-/preview/" width="300">

<br>

<br>[입력]
<br>첫째 줄에 정수 N, r, c가 주어진다.
<br>
<br>[출력]
<br>r행 c열을 몇 번째로 방문했는지 출력한다.
<br>
<br>[조건]
<br>1 ≤ N ≤ 15
<br>0 ≤ r, c < 2N
### 예제 입출력

---

#### 예제 입력 
```
6
2 3 1
3 7 7
1 0 0
4 7 7
10 511 511
10 512 512
```
#### 예제 출력 
```
11
63
0
63
262143
786432
```


---


<br>

### 문제풀이 전략
- 문제 유형
  - 분할 정복, 재귀

### 핵심 아이디어

- 큰 사각형(배열)부터 작은 사격형(배열)로 재귀 함수를 통해 탐색한다.
- 탐색 중인 배열 중에 찾는 좌표가 없다면 좌표에 크기를 더한다.
- 찾는 좌표라면 result를 출력하고 종료한다.

### 답안 전체코드

```python
import sys
def visited(n, r, c):
    global res

    # 찾는 좌표라면 res를 출력하고 종료
    if r == R and c == C:
        print(int(res))
        return

    # 탐색 증인 배열 중에 찾는 좌표가 없다면 좌표에 크기를 더한다.
    if not (r <= R < r + n and c <= C < c + n):
        res += n * n
        return

    # 1/2/3/4사분면을 재귀적으로 탐색
    visited(n / 2, r, c)  # 1사분면
    visited(n / 2, r, c + n / 2)  # 2사분면
    visited(n / 2, r + n / 2, c)  # 3사분면
    visited(n / 2, r + n / 2, c + n / 2)  # 4사분면


N, R, C = map(int, sys.stdin.readline().split())
res = 0

# 2^n을 0, 0부터 탐색
visited(2 ** N, 0, 0)
```

