
# [백준 12865번 평범한 배낭](https://www.acmicpc.net/problem/12865)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_5.svg" width="20">  백준 12865번 평범한 배낭  


| 시간제한 | 메모리제한 | 정답비율 | 난이도  | 
|:----:|:-----:|:----:|:----:|
|  2초  | 512MB |  35%  | 골드5  |

---

### 문제

<br> 이 문제는 아주 평범한 배낭에 관한 문제이다. 
<br> 
<br> 한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다.
<br> 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
<br> 
<br> 준서가 여행에 필요하다고 생각하는 N개의 물건이 있다.
<br> 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
<br> 
<br> 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
<br> 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.




### 예제 입출력

#### 입력 조건
> 첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.<br> 
> 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.<br>
> 입력으로 주어지는 모든 수는 정수이다.<br>
#### 출력 조건
> 한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다. <br>
---
#### 예제 입력 1
```
4 7
6 13
4 8
3 6
5 12
```
#### 예제 출력 1
```
14
```

---


<br>

### 문제풀이 전략
- 문제 유형
  - DP, 배낭

* 배낭 문제(Knapsack Problem)으로도 알려져 있는, 전형적인 동적 프로그래밍 문제이다.
* 물품 수 N, 배낭에 담을 수 있는 최대 무게 K
* DP를 이용하면 O(NK)이내로 문제를 해결 할 수 있다.

#### 문제풀이 핵심 아이디어
* ***핵심 아이디어*** : 모든 무게에 대하여 최대 가치를 저장하기
* D[i][j] = 배낭에 넣은 물품의 무게 합이 j일 때 얻을 수 있는 최대 가치
* 각 물품의 번호 i에 따라서 최대 가치 테이블 D[i][j]를 갱신하여 문제를 해결
* 점화식
  * D[i][j] = D[i-1][j]\(if j<W[i])
  * D[i][j] = max(D[i-1][j],D[i-1][j-W[i]]+V[i])\(if j>=W[i])

* 예를 들어 N = 4, K = 7 일 때의 예시를 확인해 봅시다.

|  n  | 무게  | 가치  |
|:---:|:---:|:---:|
| 물건1 |  6  | 13  |
| 물건2 |  4  |  8  |
| 물건3 |  3  |  6  |
| 물건4 |  5  | 12  |

* 2차원 배열 D[0][k] 진행
  - 기본적으로 k가 0(최대 가방 무게가 0)일때 물건의 무게도 0이 된다.

| n/k |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 초기값 |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
| 물건1 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
| 물건2 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
| 물건3 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
| 물건4 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |

* 2차원 배열 D[1][k] 진행
  - K가 1일때, 물건 1의 무게 6보다 작다(D[1-1][1]값 가져온다.)
  - K가 2일때, 물건 1의 무게 6보다 작다(D[1-1][2]값 가져온다.)
  - K가 3일때, 물건 1의 무게 6보다 작다(D[1-1][3]값 가져온다.)
  - K가 4일때, 물건 1의 무게 6보다 작다(D[1-1][4]값 가져온다.)
  - K가 5일때, 물건 1의 무게 6보다 작다(D[1-1][5]값 가져온다.)
  - k가 6일때, 물건 1의 무게 6과 같다. 
    - 가치 13 입력 (D[1-1][6] 과 비교해서 더 큰값을 입력한다.)
  - K가 7일때, 물건 1의 무게 6 보다 크고 가방 무게 1이 남는다
    - 가치 13 + D[1][1]\(남는 가방 무게 1의 최대 무게) = 13(D[1-1][7] 과 비교해서 더 큰값을 입력한다.)

| n/k |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 초기값 |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
| 물건1 |  0  |  0  |  0  |  0  |  0  |  0  | 13  | 13  |
| 물건2 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
| 물건3 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
| 물건4 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |


* 2차원 배열 D[2][k] 진행
  - K가 1일때, 물건 2의 무게 4보다 작다(D[2-1][1]값 가져온다.)
  - K가 2일때, 물건 2의 무게 4보다 작다(D[2-1][2]값 가져온다.)
  - K가 3일때, 물건 2의 무게 4보다 작다(D[2-1][3]값 가져온다.)
  - K가 4일때, 물건 2의 무게 4과 같다.
    - 가치 8 입력(D[2-1][4] 과 비교해서 더 큰값을 입력한다.)
  - K가 5일때, 물건 2의 무게 4 보다 크고 1이 남는다
    - 가치 8 + D[2][1]\(남는 가방 무게 1의 최대 무게) = 8 (D[2-1][5] 과 비교해서 더 큰값을 입력한다.)
  - k가 6일때, 물건 2의 무게 4 보다 크고 2이 남는다
    - 가치 8 + D[2][2]\(남는 가방 무게 2의 최대 무게) = 8 (D[2-1][6] 과 비교해서 더 큰값을 입력한다.) -> 13
  - K가 7일때, 물건 2의 무게 4 보다 크고 3이 남는다
    - 가치 8 + D[2][3]\(남는 가방 무게 3의 최대 무게) = 8 (D[2-1][7] 과 비교해서 더 큰값을 입력한다.) -> 13

| n/k |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 초기값 |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
| 물건1 |  0  |  0  |  0  |  0  |  0  |  0  | 13  | 13  |
| 물건2 |  0  |  0  |  0  |  0  |  8  |  8  | 13  | 13  |
| 물건3 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
| 물건4 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |

* 2차원 배열 D[3][k] 진행
  - K가 1일때, 물건 3의 무게 3보다 작다(D[3-1][1]값 가져온다.)
  - K가 2일때, 물건 3의 무게 3보다 작다(D[3-1][2]값 가져온다.)
  - K가 3일때, 물건 3의 무게 3과 같다.
    - 가치 6 입력(D[3-1][4] 과 비교해서 더 큰값을 입력한다.)
  - K가 4일때, 물건 3의 무게 3보다 크고 1이 남는다
    - 가치 6 + D[3][1]\(남는 가방 무게 1의 최대 무게) = 6 (D[3-1][4] 과 비교해서 더 큰값을 입력한다.) -> 8
  - K가 5일때, 물건 3의 무게 3보다 크고 2이 남는다
    - 가치 6 + D[3][2]\(남는 가방 무게 1의 최대 무게) = 6 (D[3-1][5] 과 비교해서 더 큰값을 입력한다.) -> 8
  - k가 6일때, 물건 3의 무게 3보다 크고 3이 남는다
    - 가치 6 + D[3][3]\(남는 가방 무게 2의 최대 무게) = 12 (D[3-1][6] 과 비교해서 더 큰값을 입력한다.) -> 13
  - K가 7일때, 물건 3의 무게 3보다 크고 4이 남는다
    - 가치 6 + D[3][4]\(남는 가방 무게 3의 최대 무게) = 14 (D[3-1][7] 과 비교해서 더 큰값을 입력한다.) -> 14

| n/k |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 초기값 |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
| 물건1 |  0  |  0  |  0  |  0  |  0  |  0  | 13  | 13  |
| 물건2 |  0  |  0  |  0  |  0  |  8  |  8  | 13  | 13  |
| 물건3 |  0  |  0  |  0  |  6  |  8  |  8  | 13  | 14  |
| 물건4 |  0  |  -  |  -  |  -  |  -  |  -  |  -  |  -  |

* 2차원 배열 D[4][k] 진행
  - K가 1일때, 물건 4의 무게 5보다 작다->기존값 유지(D[4-1][1]값 가져온다.)
  - K가 2일때, 물건 4의 무게 5보다 작다->기존값 유지(D[4-1][2]값 가져온다.)
  - K가 3일때, 물건 4의 무게 5보다 작다->기존값 유지(D[4-1][3]값 가져온다.)
  - K가 4일때, 물건 4의 무게 5보다 작다->기존값 유지(D[4-1][4]값 가져온다.)
  - K가 5일때, 물건 4의 무게 5와 같다.
    - 가치 12 입력(D[4-1][5] 과 비교해서 더 큰값을 입력한다.)
  - k가 6일때, 물건 4의 무게 5보다 크고 1이 남는다.
    - 가치 12 + D[4][1]\(남는 가방 무게 1의 최대 무게) = 12 (D[4-1][6] 과 비교해서 더 큰값을 입력한다.) -> 13
  - k가 7일때, 물건 4의 무게 5보다 크고 2이 남는다.
    - 가치 12 + D[4][2]\(남는 가방 무게 2의 최대 무게) = 12 (D[4-1][7] 과 비교해서 더 큰값을 입력한다.) -> 14
    
| n/k |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 초기값 |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |
| 물건1 |  0  |  0  |  0  |  0  |  0  |  0  | 13  | 13  |
| 물건2 |  0  |  0  |  0  |  0  |  8  |  8  | 13  | 13  |
| 물건3 |  0  |  0  |  0  |  6  |  8  |  8  | 13  | 14  |
| 물건4 |  0  |  0  |  0  |  6  |  8  | 12  | 13  | 14  |

### 답안 전체코드

```py
n, k = map(int, input().split())
dp = [[0] * (k+1) for _ in range(n+1)]

for i in range(1, n+1):
    weight, value = map(int, input().split())
    for j in range(1, k+1):
        if j < weight:#물건의 무게보다 k가 낮을때는 그대로 가져온다.
            dp[i][j] = dp[i-1][j]
        else:#max(둘중에 더 큰값)
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight]+value)
print(dp[n][k])
```
