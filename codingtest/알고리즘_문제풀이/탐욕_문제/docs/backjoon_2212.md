
# [백준 2212번 센서](https://www.acmicpc.net/problem/2212)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_5.svg" width="20">  백준 2212번 센서 


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  2초  | 128MB | 47%  | 골드5  |

---

### 문제


<br> 한국도로공사는 고속도로의 유비쿼터스화를 위해 고속도로 위에 N개의 센서를 설치하였다.
<br>  문제는 이 센서들이 수집한 자료들을 모으고 분석할 몇 개의 집중국을 세우는 일인데, 예산상의 문제로, 고속도로 위에 최대 K개의 집중국을 세울 수 있다고 한다.
<br> 
<br> 각 집중국은 센서의 수신 가능 영역을 조절할 수 있다.
<br> 집중국의 수신 가능 영역은 고속도로 상에서 연결된 구간으로 나타나게 된다.
<br> N개의 센서가 적어도 하나의 집중국과는 통신이 가능해야 하며, 집중국의 유지비 문제로 인해 각 집중국의 수신 가능 영역의 길이의 합을 최소화해야 한다.
<br> 
<br> 편의를 위해 고속도로는 평면상의 직선이라고 가정하고, 센서들은 이 직선 위의 한 기점인 원점으로부터의 정수 거리의 위치에 놓여 있다고 하자.
<br> 따라서, 각 센서의 좌표는 정수 하나로 표현된다.
<br> 이 상황에서 각 집중국의 수신 가능영역의 거리의 합의 최솟값을 구하는 프로그램을 작성하시오.
<br> 단, 집중국의 수신 가능영역의 길이는 0 이상이며 모든 센서의 좌표가 다를 필요는 없다.


### 예제 입출력

#### 입력 조건
> 첫째 줄에 센서의 개수 N(1 ≤ N ≤ 10,000), 둘째 줄에 집중국의 개수 K(1 ≤ K ≤ 1000)가 주어진다  <br> 
> 셋째 줄에는 N개의 센서의 좌표가 한 개의 정수로 N개 주어진다. 각 좌표 사이에는 빈 칸이 하나 있으며, 좌표의 절댓값은 1,000,000 이하이다.  <br> 
#### 출력 조건
> 첫째 줄에 문제에서 설명한 최대 K개의 집중국의 수신 가능 영역의 길이의 합의 최솟값을 출력한다. <br>

---

#### 예제 입력 1
```
6
2
1 6 9 3 6 7
```
#### 예제 출력 1
```
5
```

---

#### 예제 입력 2
```
10
5
20 3 14 6 7 8 18 10 12 15
```
#### 예제 출력 2
```
7
```

---


<br>

### 문제풀이 전략
- 문제 유형
  - 정렬, 그리디 알고리즘

- 최대 K개의 집중국을 설치해야 한다.
- 집중국들의 수신 가능 영역의 길이의 합을 최소화 하는것이 목표이다.
- O(NlogN) 시간 복잡도 이내에 문제를 해결할 수 있다.

#### 문제풀이 핵심 아이디어
> 정렬된 센서들을 최대 K개의 영역으로 나누는 것과 동일하다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_2212_1.png?raw=true">

1. K개의 집중국이기 때문에 K개의 영역으로 나누어진다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_2212_2.png?raw=true">

2. 각 영역의 거리를 적게 하기 위해선 정렬이 필요하다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_2212_3.png?raw=true">

3. 각 센서 사이의 거리를 계산한다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_2212_4.png?raw=true">

4. 가장 거리가 먼 순서대로 K-1개의 연결고리를 제거한다.
>여기서는 3과 6의 사이가 가장 크기 때문에 제거한다.

<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_2212_5.png?raw=true">

5. 따라서 남아있는 모든 거리의 합은 5이다.

### 답안 전체코드

```py
import sys
input = sys.stdin.readline
센서개수 = int(input())
집중국개수 = int(input())
센서좌표 = sorted(map(int, input().split()))
result = 0
#집중국의 개수가 센서개수 보다 많을때
if 집중국개수>=센서개수:
    #모든 센서위치에 집중국을 설치하면 된다.
    #집중국의 수신 가능영역은 0이다.
    pass
else:
    #각 센서 간의 거리를 계산하여 내림차순 정렬
    거리 = []
    for index in range(1, 센서개수):
        거리.append(센서좌표[index]-센서좌표[index-1])
    거리.sort(reverse=True)

    #가장 긴 거리부터 하나씩 제거한다.
    for i in range(집중국개수-1):
        거리[i] = 0
    result = sum(거리)
print(result)
```
