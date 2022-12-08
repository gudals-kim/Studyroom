
# [백준 1427번 소트인사이트](https://www.acmicpc.net/problem/1427)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_5.svg" width="20">  백준 1427번 소트인사이트


| 시간제한 |메모리제한| 정답비율 | 난이도 | 
|:----:|:---:|:----:|:---:|
|  1초  |128MB| 64%  | 실버5 |

<br>

### 문제

```
[문제]
배열을 정렬하는 것은 쉽다.
수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

[입력]
첫째 줄에 정렬하려고 하는 수 N이 주어진다.
N은 1,000,000,000보다 작거나 같은 자연수이다.

[출력]
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

```


<br>

---

#### 예제 입력 1
> 2143
#### 예제 출력 1
> 4321

---

#### 예제 입력 2
> 999998999
#### 예제 출력 2
> 999999998

---

#### 예제 입력 3
> 61423
#### 예제 출력 3
> 64321

---

#### 예제 입력 4
> 500613009
#### 예제 출력 4
> 965310000

---

<br>

### 문제풀이 전략
- 문제 유형
  - 문자열, 정렬

#### 파이썬 내장함수를 연습하기 좋은 문제

1. input으로 받은 문자열을 각 자리수로 나누기위한 lambda함수와 map 사용
```python
map(lambda x:int(x[0])%10,input())
```
2. list함수로 변환해서 저장
```python
n = list(map(lambda x:int(x[0])%10,input()))
```
3. sorted함수를 이용하여 내림차순 정렬
```python
sorted(n,reverse=True)
```
4. join 함수를 사용하기위해선 문자열 자료여야 하기 때문에 map함수로 str로 변환
```python
map(str,sorted(n,reverse=True))
```
5. join 함수를 사용하여 출력
```python
print("".join(map(str,sorted(n,reverse=True))))
```

### 답안 전체코드

```py
n = list(map(lambda x:int(x[0])%10,input()))
print("".join(map(str,sorted(n,reverse=True))))
```
