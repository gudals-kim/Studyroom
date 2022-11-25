# 자료구조 문제풀이

## 문제풀이 

> 메모리 검사 코드 

```py
import psutil
def memory_usage(message: str = 'debug'):
    # current process RAM usage
    p = psutil.Process()
    rss = p.memory_info().rss / 2 ** 20 # Bytes to MB
    print(f"[{message}] memory usage: {rss: 10.5f} MB")

memory_usage("#1")
```

> 문제를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.
<details>
<summary>2920번 음계</summary>

* [문제링크](https://www.acmicpc.net/problem/2920)

## 백준 2920번 음계

| 시간제한 |메모리제한|정답비율|입력조건|출력조건|
|:----:|:---:|:---:|:---:|:---:|
|  1초  |128MB|55%|문제에표기|문제에표기|

<br>

### 문제

```
문제
다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 
이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. 
c는 1로, d는 2로, ..., C를 8로 바꾼다.

1부터 8까지 차례대로 연주한다면 ascending,
8부터 1까지 차례대로 연주한다면 descending,
둘 다 아니라면 mixed 이다.

연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지,
아니면 mixed인지 판별하는 프로그램을 작성하시오.

입력조건
첫째 줄에 8개 숫자가 주어진다.
이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.

출력조건
첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.

```


<br>

|예제입력|예제출력|
|:---:|:---:|
|1 2 3 4 5 6 7 8|ascending|
|8 7 6 5 4 3 2 1|descending|
|8 1 7 2 6 3 5 4|mixed|



<br>

### 문제풀이 전략


1. 리스트에서 원소를 차례대로 비교한다.
2. 비교할때 두 원소 기준으로 오름차순, 내림차순 여부를 체크한다
3. 지속되는지 확인한다.



### 답안 전체코드

```py
inputData = list(map(int, input().split()))

ascending = 0
descending = 0
for index in range(1,len(inputData)):
    if inputData[index-1]!=inputData[index]+1 and inputData[index-1]!=inputData[index]-1:
        print("mixed")
        break
    elif inputData[index-1]==inputData[index]-1:
        ascending+=1
    elif inputData[index-1]==inputData[index]+1:
        descending+=1

if ascending==7:
    print("ascending")
elif descending==7:
    print("descending")
```

</details>
<details>
<summary>2798번 블랙잭</summary>

* [문제링크](https://www.acmicpc.net/problem/2798)

## backjoon 2798번 블랙잭

| 시간제한 |메모리제한|정답비율|입력조건|출력조건|
|:----:|:---:|:---:|:---:|:---:|
|  1초  |128MB|47%|문제에표기|문제에표기

<br>

### 문제

```
문제

카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다.
카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다.
블랙잭은 카지노마다 다양한 규정이 있다.

한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.

김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다.
그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다.
그런 후에 딜러는 숫자 M을 크게 외친다.

이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다.
블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

입력
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

```


<br>

|   예제입력    |예제출력|
|:---------:|:---:|
|   5 21    ||
| 5 6 7 8 9 |21|
|   10 500    ||
| 93 181 245 214 315 36 185 138 216 295 |497|



<br>

### 문제풀이 전략


1. 카드 중 3개씩 뽑는 모든 경우의 수는 n(n-1)(n-2) 이며 n의 최대는 100이다.
2. 약 1,000,000이라는 실행횟수는 파이썬에서 부담되는 실행횟수가 아니기 때문에 단순 완전탐색으로 푼다.
3. 3중 반복문(완전탐색)으로 모든 경우의 수를 확인하여 문제를 해결한다.



### 답안 전체코드

```py
n,m = map(int,input().split())
카드덱 = list(map(int,input().split()))
result = 0

for index in range(len(카드덱)):
    for index2 in range(index+1,len(카드덱)):
        for index3 in range(index2+1,len(카드덱)):
            sum_value = 카드덱[index]+카드덱[index2]+카드덱[index3]
            if sum_value <= m:
                result = max(result, sum_value)

print(result)

```

</details>