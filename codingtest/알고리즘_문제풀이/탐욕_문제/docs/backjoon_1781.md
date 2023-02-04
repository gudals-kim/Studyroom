
# [백준 1781번 컵라면](https://www.acmicpc.net/problem/1781)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_2.svg" width="20">  백준 1781번 컵라면 


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  2초  | 256MB | 31%  | 골드2 |

---


### 문제



 
 
<br> 상욱 조교는 동호에게 N개의 문제를 주고서, 각각의 문제를 풀었을 때 컵라면을 몇 개 줄 것인지 제시 하였다.
<br> 하지만 동호의 찌를듯한 자신감에 소심한 상욱 조교는 각각의 문제에 대해 데드라인을 정하였다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1781_1.png?raw=true">

<br> 위와 같은 상황에서 동호가 2, 6, 3, 1, 7, 5, 4 순으로 숙제를 한다면 2, 6, 3, 7번 문제를 시간 내에 풀어 총 15개의 컵라면을 받을 수 있다.
<br> 문제는 동호가 받을 수 있는 최대 컵라면 수를 구하는 것이다. 위의 예에서는 15가 최대이다.
<br> 
<br> 문제를 푸는데는 단위 시간 1이 걸리며, 각 문제의 데드라인은 N이하의 자연수이다.
<br> 또, 각 문제를 풀 때 받을 수 있는 컵라면 수와 최대로 받을 수 있는 컵라면 수는 모두 231보다 작거나 같은 자연수이다.
<br> 
<br> 
<br> 


### 예제 입출력

#### 입력 조건
> 첫 줄에 숙제의 개수 N (1 ≤ N ≤ 200,000)이 들어온다. <br> 
> 다음 줄부터 N+1번째 줄까지 i+1번째 줄에 i번째 문제에 대한 데드라인과 풀면 받을 수 있는 컵라면 수가 공백으로 구분되어 입력된다.  <br> 
#### 출력 조건
> 첫 줄에 동호가 받을 수 있는 최대 컵라면 수를 출력한다. <br>

---

#### 예제 입력 1
```
7
1 6
1 7
3 2
3 1
2 4
2 5
6 1
```
#### 예제 출력 1
```
15
```

---


<br>

### 문제풀이 전략
>데이터의 개수가 최대 200,000개 이므로 O(NlogN)이내의 시간에 해결 해야 한다.
- 문제 유형
  - 큐, 그리디 알고리즘


#### 문제풀이 핵심 아이디어
> 데드라인을 초과하는 문제는 풀 수 없다.

1. 데이터를 데드라인 기준으로 오름차순 정렬을 한다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1781_2.png?raw=true">

2. 각 문제의 '컵라면 수'를 우선순위 큐에 넣으면서, 데드라인을 초과하는 경우는 heapq.pop()을 한다.
> min heap을 사용하기 때문에 컵라면의 수가 가장 적은것이 나온다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1781_3.png?raw=true">

- 첫번째 데이터를 빼서 우선순위 큐에 넣는다.
  - 데드라인 : 1
  - 우선순위 큐의 크기-1 (방금 넣은 데이터는 고려하지 않는다.) = 0
  - 데드라인을 넘지 않는다.
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1781_4.png?raw=true">

- 두번째 데이터를 빼서 우선순위 큐에 넣는다.
  - 데드라인 : 1
  - 우선순위 큐의 크기-1 (방금 넣은 데이터는 고려하지 않는다.) = 1
  - 데드라인을 초과한다.
  - 우선순위 큐 heapq.pop() 진행
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1781_5.png?raw=true">

- 세번째 데이터를 빼서 우선순위 큐에 넣는다.
  - 데드라인 : 2
  - 우선순위 큐의 크기-1 (방금 넣은 데이터는 고려하지 않는다.) = 1
  - 데드라인을 넘지않는다.
  - <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1781_6.png?raw=true">

> 이런식으로 모든 데이터를 넣고 빼고를 진행한다.
- 남아있는 **우선순위 큐의 모든 값의 합이 정답**이 된다.
- <img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1781_7.png?raw=true">

### 답안 전체코드

```py
import heapq, sys
input = sys.stdin.readline
#데이터를 데드라인 기준으로 오름차순 정렬을 한다.
모든문제들 = sorted([tuple(map(int,input().split())) for _ in range(int(input()))])
풀어서받은컵라면들 = []
#a모든 문제의 '컵라면 수'를 우선순위 큐에 넣으면서, 데드라인을 초과하는 경우는 heapq.pop()을 한다.
for 데드라인,컵라면 in 모든문제들:
    heapq.heappush(풀어서받은컵라면들,컵라면)
    if len(풀어서받은컵라면들)-1 >= 데드라인:
        heapq.heappop(풀어서받은컵라면들)
result = 0
if len(풀어서받은컵라면들)!=0:
    result = sum(풀어서받은컵라면들)
print(result)
```
