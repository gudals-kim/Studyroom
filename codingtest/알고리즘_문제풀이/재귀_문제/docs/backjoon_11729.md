
# [백준 11729번 하노이 탑 이동 순서](https://www.acmicpc.net/problem/11729)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_1.svg" width="20">  백준 11729번 하노이 탑 이동 순서 


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  1초  | 128MB | 50%  | 실버1 |

<br>

### 문제

세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다.<br>
각 원판은 반경이 큰 순서대로 쌓여있다.<br>
이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세번째 장대로 옮기려 한다.<br>

  1. 한번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
  2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야한다.

이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라.<br>
단, 이동 횟수는 최소가 되어야한다.<br>
아래 그림은 원판이 5개인 경우의 예시이다.<br>
<img src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11729/hanoi.png">


<br>

### 예제 입출력

---

#### 예제 입력 1
> 첫째 줄에 첫 번째 쌓인 원판의 개수 N(1<=N<=20)이 주어진다.
```
3
```
#### 예제 출력 1
> 첫째 줄에 옮긴 횟수 K를 출력한다.<br>
> 두 번째 줄부터 수행 과정을 출력한다. <br>
> 두번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다. 
```
7
1 3
1 2
3 2
1 3
2 1
2 3
1 3
```
---


<br>

### 문제풀이 전략
- 문제 유형
  - 재귀

### 핵심 아이디어

* 원판이 1개일때 -> 답 1 
* 원판이 n개일때 -> 찾아보자

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbbKmtl%2FbtqF4UmQjUp%2F2kDQz7dPiknXkzBvWqVTD0%2Fimg.png">

> n개의 원판을 3번 막대에 옮기려고 할때

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FlxurM%2FbtqF80L8HZz%2FGSOXa5eauMWlNHbJsusKbk%2Fimg.png">

> 1단계 n-1개의 원판을 2번 막대로 옮긴다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FrRHji%2FbtqF7u1rEVk%2F7nMyX00mi7c7jGgV06dfi0%2Fimg.png">

> 2단계 남은 1개의 원판을 1번 막대에서 3번 막대로 옮긴다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcrWuHX%2FbtqF8YOhATf%2FgIiv0KftXEZeTH77u7cFMk%2Fimg.png">

> 3단계 n-1개의 원판을 2번 막대에서 3번 막대로 옮긴다.



### 답안 전체코드
```python
# n : 원판개수
# start : 원판이 들어있던 막대
# end : 최종적으로 원판이 들어오는 막대
def hanoi_tower(n, start, end) :
    if n == 1 :
        print(start, end)
        return
    # 1단계 
    hanoi_tower(n-1, start, 6-start-end) 
    # 2단계
    print(start, end) 
    # 3단계
    hanoi_tower(n-1, 6-start-end, end)
    
n = int(input())
print(2**n-1)
hanoi_tower(n, 1, 3)
```

