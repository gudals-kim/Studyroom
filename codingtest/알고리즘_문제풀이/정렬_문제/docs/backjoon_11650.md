
# [백준 11650번 좌표 정렬하기](https://www.acmicpc.net/problem/11650)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_5.svg" width="20">  백준 11650번 좌표 정렬하기


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  1초  | 256MB | 48%  | 실버5 |

<br>

### 문제

```
[문제]
2차원 평면 위의 점 N개가 주어진다. 
좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

[입력]
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. 
(-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

[출력]
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
```


<br>

### 예제 입출력

#### 예제입력 1
```
5
3 4
1 1
1 -1
2 2
3 3
```
#### 예제출력 1
```
1 -1
1 1
2 2
3 3
3 4
```

<br>

### 문제풀이 전략
- 문제 유형
  - 정렬

#### [lambda 함수](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/파이썬함수/lambda.md) 및 [sorted 함수](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/파이썬함수/sorted.md) 사용법을 물어보는 문제이다.

* 문제 자체는 단순 정렬을 하면 되기 때문에 
* lambda 함수와 sorted 함수를 적절히 사용하면 쉽게 풀 수 있다.
* 추가로 이 문제에서 [join 함수](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/파이썬함수/join.md)도 유용하다.

1. (x, y)좌표를 입력 받은뒤 x좌표, y좌표 순서로 오름차순 정렬한다.
2. 파이썬의 기본 정렬 라이브러리는 기본적으로 튜플의 인덱스 순서대로 오름차순 정렬한다.
3. 따라서 key 파라미터를 사용하지 않고 단순 sorted 함수를 사용하면 된다.

### 답안 전체코드

```py
n = int(input())
data = []
for i in range(n):
    x,y = map(int,input().split())
    data.append((x,y))
data=sorted(data)
for item in data:
    print(data[0], data[1])
```
