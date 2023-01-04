
# [백준 2751번 수 정렬하기2](https://www.acmicpc.net/problem/2751)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_5.svg" width="20">  백준 2751번 수 정렬하기2


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  2초  | 256MB | 30%  | 실버5 |

<br>

### 문제

---

<br> N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
<br>

### 예제 입출력

---

#### 예제 입력 1
> 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.<br>
> 둘째 줄부터 N개의 줄에는 수가 주어진다.<br>
> 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다.<br>
> 수는 중복되지 않는다.
```
5
5
4
3
2
1
```
#### 예제 출력 1
> 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
```
1
2
3
4
5
```
---

<br>

### 문제풀이 전략
- 문제 유형
  - 정렬


#### 문제풀이 핵심 아이디어
- 데이터의 개수가 최대 1,000,000개 이다.
- 효율적인 정렬알고리즘 (병합,퀵,힙) 정렬을 이용해야한다.
- pypy3 로 제출이 가능하다면 pypy3로 제출하자(메모리를 더 쓰지만 시간이 단축)

***고급 정렬 풀이 방법 3가지*** 
1. 퀵 정렬
2. 병합 정렬
3. 힙 정렬 -> python 내장 heapq 사용



### 답안 전체코드

```py
import heapq
import sys
반복 = int(sys.stdin.readline())
data = []
for _ in range(반복):
    heapq.heappush(data,int(sys.stdin.readline()))
for _ in range(반복):
    print(heapq.heappop(data))
```
