
# [백준 11004번 K 번째 수](https://www.acmicpc.net/problem/11004)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_5.svg" width="20">  백준 11004번 K번째 수


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  2초  | 512MB | 40%  | 실버5 |

<br>

### 문제

---

<br> 수 N개 A1, A2, ..., AN이 주어진다.
<br> A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.


### 예제 입출력

---

#### 예제 입력 1
> 첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.<br>
> 둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

```
5 2
4 1 2 3 5
```
#### 예제 출력 1
> A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.
```
2
```
---

<br>

### 문제풀이 전략
- 문제 유형
  - 정렬


#### 문제풀이 핵심 아이디어
- 데이터의 개수가 최대 5,000,000개 이다.
- 효율적인 정렬알고리즘 (병합,퀵,힙) 정렬을 이용해야한다.
- pypy3 로 제출이 가능하다면 pypy3로 제출하자(메모리를 더 쓰지만 시간이 단축)

***고급 정렬 풀이 방법 3가지*** 
1. 퀵 정렬 -> sorted 함수 사용
2. 병합 정렬
3. 힙 정렬 -> python 내장 heapq 사용


### 답안 전체코드

```py
import sys
N, K = map(int, sys.stdin.readline().split())
result=list(map(int,sys.stdin.readline().split()))
result = sorted(result)
print(result[K-1])
```
