
# [백준 1759번 암호 만들기](https://www.acmicpc.net/problem/1759)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_5.svg" width="20"> 백준 1759번 암호 만들기 


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  2초  | 128MB | 44%  | 골드5 |

---

### 문제

<br> 바로 어제 최백준 조교가 방 열쇠를 주머니에 넣은 채 깜빡하고 서울로 가 버리는 황당한 상황에 직면한 조교들은, 702호에 새로운 보안 시스템을 설치하기로 하였다.
<br> 이 보안 시스템은 열쇠가 아닌 암호로 동작하게 되어 있는 시스템이다.
<br> 
<br> 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
<br> 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다.
<br> 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
<br> 
<br> 새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다.
<br> 이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다. 
<br> C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.


### 예제 입출력

#### 입력 조건
> 첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15)  <br>
> 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다.  <br>
> 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.  <br>
  #### 출력 조건
> 각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력한다. <br>

---

#### 예제 입력 1
```
4 6
a t c i s w
```
#### 예제 출력 1
```
acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
```

---


<br>

### 문제풀이 전략
- 문제 유형
  - 수학, 브루트포스 알고리즘, 조합론, 백트래킹



#### 문제풀이 핵심 아이디어
- C개의 문자들이 주어졌을 때, 가능한 L 길이의 암호를 모두 찾아야한다.
- 따라서 C개의 문자들 중에서 L개를 선택하는 **모든 조합**을 고려해야한다.
  - Python의 조합(combinations)라이브러리를 활용하면 간단히 해결할 수 있다.
  - 혹 dfs를 사용해서 조합 함수를 구현해도된다.


#### C = 4, L = 3일 때의 예시
<img src="https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/img/backjoon_1759_1.png?raw=true">

### 답안 전체코드

```py
from itertools import combinations
vowels = ('a', 'e', 'i', 'o', 'u')
l, c = map(int, input().split(' '))

# 가능한 암호를 사전식으로 출력해야 하므로 정렬 수행
array = input().split(' ')
array.sort()

# 길이가 l인 모든 암호 조합을 확인
for password in combinations(array, l):
    # 모음의 개수를 세기
    count = 0
    for i in password:
        if i in vowels:
            count += 1

    # 최소 한 개의 모음과 최소 두 개의 자음이 있는 경우 출력
    if count >= 1 and count <= l - 2:
        print(''.join(password))
```
