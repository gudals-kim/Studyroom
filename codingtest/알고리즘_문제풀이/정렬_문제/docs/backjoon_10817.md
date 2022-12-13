
# [백준 10817번 세 수](https://www.acmicpc.net/problem/10817)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/bronze_3.svg" width="20">  백준 10817번 세 수 


| 시간제한 | 메모리제한 | 정답비율 | 난이도  | 
|:----:|:-----:|:----:|:----:|
|  1초  | 256MB | 48%  | 브론즈3 |

<br>

### 문제

```
[문제]
세 정수 A, B, C가 주어진다. 
이때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오. 

[입력]
첫째 줄에 세 정수 A, B, C가 공백으로 구분되어 주어진다. 
(1 ≤ A, B, C ≤ 100)

[출력]
두 번째로 큰 정수를 출력한다.

```


<br>

### 예제 입출력

---

#### 예제 입력 1
> 20 30 10
#### 예제 출력 1
> 20

---

#### 예제 입력 2
> 30 30 10
#### 예제 출력 2
> 30

---

#### 예제 입력 3
> 40 40 40
#### 예제 출력 3
> 40

---

#### 예제 입력 4
> 20 10 10
#### 예제 출력 4
> 10

---

<br>

### 문제풀이 전략
- 문제 유형
  - 구현, 정렬

### 핵심 아이디어
> 매운 쉬운 문제이다. 
- [sorted 함수](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/파이썬함수/sorted.md)
- [map 함수](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/파이썬함수/map.md)
- list 함수
- input().split()
이 함수들을 공부 후에 푼다면 매우 쉽게 풀 수 있다.

### 답안 전체코드

```python
print(sorted(list(map(int, input().split())))[1])
```
