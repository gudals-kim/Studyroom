
# [백준 10814번 나이순 정렬](https://www.acmicpc.net/problem/10814)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_5.svg" width="20">  백준 10814번 나이순 정렬


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  3초  | 256MB | 42%  | 실버5 |

<br>

### 문제

```
[문제]
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
이때, 회원들을 나이가 증가하는 순으로, 
나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

[입력]
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고,
이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 
입력은 가입한 순서로 주어진다.

[출력]
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 
나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.

```


<br>

### 예제입력

#### 예제입력 1

> 3 
> 21 Junkyu
> 21 Dohyun
> 20 Sunyoung

#### 예제출력 1

> 20 Sunyoung
> 21 Junkyu
> 21 Dohyun


<br>

### 문제풀이 전략
- 문제 유형
  - 정렬

#### [lambda 함수](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/파이썬함수/lambda.md) 및 [sorted 함수](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/파이썬함수/sorted.md) 사용법을 물어보는 문제이다.

* 문제 자체는 단순 정렬을 하면 되기 때문에 
* lambda 함수와 sorted 함수를 적절히 사용하면 쉽게 풀 수 있다.
* 추가로 이 문제에서 [join 함수](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/파이썬함수/join.md)도 유용하다.



### 답안 전체코드

```py
n = int(input())
data = dict()
for i in range(n):
    data[i] = list(input().split())

data = sorted(data.items(),key=lambda x:int(x[1][0]))

for index,item in data:
    print(" ".join(item))
```
