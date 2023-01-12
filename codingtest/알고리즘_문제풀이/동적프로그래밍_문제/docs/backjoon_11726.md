
# [백준 11726번 2xN 타일링](https://www.acmicpc.net/problem/11726)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_3.svg" width="20">  백준 1766번 2xN 타일링  


| 시간제한 | 메모리제한  | 정답비율 | 난이도  | 
|:----:|:------:|:----:|:----:|
|  1초  | 256MB  | 35%  | 실버3  |

---

### 문제

<br> 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
<br> 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

<img src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11726/1.png" width=400>



### 예제 입출력

#### 입력 조건
> 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000) <br> 

#### 출력 조건
> 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.<br>
---
#### 예제 입력 1
```
2
```
#### 예제 출력 1
```
2
```
---
#### 예제 입력 2
```
9
```
#### 예제 출력 2
```
55
```
---



<br>

### 문제풀이 전략
- 문제 유형
  - DP, 점화식찾기

#### 문제풀이 핵심 아이디어

1. 점화식 찾기
        - n = 1 -> 1
        - n = 2 -> 2
        - n = 3 -> 3
        - n = 4 -> 5
        - n = 5 -> 8
        - 이런식의 진행이였기 때문에 ```f(n) = f(n-1) + f(n-2)```라고 생각했다.
2. 초기값 설정

    ```python
    n = int(input()) #입력값을 받는다.
    cache = [0 for i in range(n+1)] #입력 n까지의 리스트를 만든다.
    cache[0] = 0 # 조건이 n이 0이 나올 순 없지만 0으로 잡아주었다.
    cache[1] = 1 # n 이 1일땐 1이다.
    cache[2] = 2 # n 이 2일땐 2이다.
    ```

3. 점화식 코드 적용 
    
    ```python
    for index in range(3,n+1): #입력 n 일때 3부터 n+1은 점화식조건을 따른다.
        cache[index] = cache[index-1] + cache[index-2]
    ```

4. 문제 조건 검토
    
    ```python
    if n < 3: #n이 1과 2일땐 점화식에 적용받지 않음으로 계산하지 않도록 바로 그 값을 return한다.
        print(n)
    else:
        #이후 점화식 코드 및 저장공간 코드(cache)
        
        print(cache[n]%10007) #마지막엔 문제조건에 맞게 cache[n]을 제출한다.
    ```

### 답안 전체코드

```py
n = int(input())
if n < 3:
    print(n)
else:
    cache = [0 for i in range(n+1)]
    cache[0] = 0
    cache[1] = 1
    cache[2] = 2
    for index in range(3,n+1):
        cache[index] = cache[index-1] + cache[index-2]
    print(cache[n]%10007)
```
