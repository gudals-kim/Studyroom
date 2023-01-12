
# [백준 1904번 01타일](https://www.acmicpc.net/problem/1904)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_3.svg" width="20">  백준 1904번 01타일  


| 시간제한 | 메모리제한  | 정답비율 | 난이도 | 
|:----:|:------:|:----:|:---:|
|  0.75 초 (추가 시간 없음)  | 256MB  | 32%  | 실버3 |

---

### 문제

<br> 지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다.
<br>  그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.
<br>
<br> 어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다.
<br>  결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.
<br> 
<br> 그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다.
<br> 예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.
<br> 
<br> 우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로 가정하자.


### 예제 입출력

#### 입력 조건
> 첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000) <br> 

#### 출력 조건
> 첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다. <br> 

---
#### 예제 입력 1
```
4
```
#### 예제 출력 1
```
5
```
---

<br>

### 문제풀이 전략
- 문제 유형
  - DP

#### 문제풀이 핵심 아이디어
1. 점화식찾기
    - n=1 -> 1
    - n=2 -> 2 
    - n=3 -> 3
    - n=4 -> 5
    - n=5 -> 8
    - 따라서 n = n-1 + n+2

2. 초기값 설정

```python
import sys
n = int(sys.stdin.readline()) #input() 함수보다 빠른 입력 받는 함수

numbers = [0] * 1000001 # n의 최대값까지 리스트를 만들어준다. ([0 for i in range(n+1)]하면 인덱싱 에러가 난다 이유를 찾아 공부해야한다.)
numbers[1] = 1 # 1 - > 1 처리
numbers[2] = 2 # 2 - > 2 처리
```

3. 점화식 코드 작성

```python
if n > 2:
    for index in range(3,n+1):
        numbers[index] = (numbers[index-1] + numbers[index-2])
```

4. 문제 조건 검토

```python
    for index in range(3,n+1):
        numbers[index] = (numbers[index-1] + numbers[index-2])% 15746
print(numbers[n])
```


### 답안 전체코드

```py
import sys
n = int(sys.stdin.readline())

numbers = [0] * 1000001
numbers[1] = 1
numbers[2] = 2
if n > 2:
    for index in range(3,n+1):
        numbers[index] = (numbers[index-1] + numbers[index-2])% 15746
print(numbers[n])
```
