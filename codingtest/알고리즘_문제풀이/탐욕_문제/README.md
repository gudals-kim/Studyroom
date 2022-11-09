# 탐욕 알고리즘 문제풀이

문제를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.

<details>
<summary>backjoon_11399</summary>

* [문제링크](https://www.acmicpc.net/problem/11399)

## 백준 (11399)번 (ATM)

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|1초|256MB|67%|첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)|첫째 줄에 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력한다.

<br>

### 문제

```
인하은행에는 ATM이 1대밖에 없다. 지금 이 ATM앞에 N명의 사람들이 줄을 서있다. 사람은 1번부터 N번까지 번호가 매겨져 있으며, i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분이다.

사람들이 줄을 서는 순서에 따라서, 돈을 인출하는데 필요한 시간의 합이 달라지게 된다. 예를 들어, 총 5명이 있고, P1 = 3, P2 = 1, P3 = 4, P4 = 3, P5 = 2 인 경우를 생각해보자. [1, 2, 3, 4, 5] 순서로 줄을 선다면, 1번 사람은 3분만에 돈을 뽑을 수 있다. 2번 사람은 1번 사람이 돈을 뽑을 때 까지 기다려야 하기 때문에, 3+1 = 4분이 걸리게 된다. 3번 사람은 1번, 2번 사람이 돈을 뽑을 때까지 기다려야 하기 때문에, 총 3+1+4 = 8분이 필요하게 된다. 4번 사람은 3+1+4+3 = 11분, 5번 사람은 3+1+4+3+2 = 13분이 걸리게 된다. 이 경우에 각 사람이 돈을 인출하는데 필요한 시간의 합은 3+4+8+11+13 = 39분이 된다.

줄을 [2, 5, 1, 4, 3] 순서로 줄을 서면, 2번 사람은 1분만에, 5번 사람은 1+2 = 3분, 1번 사람은 1+2+3 = 6분, 4번 사람은 1+2+3+3 = 9분, 3번 사람은 1+2+3+3+4 = 13분이 걸리게 된다. 각 사람이 돈을 인출하는데 필요한 시간의 합은 1+3+6+9+13 = 32분이다. 이 방법보다 더 필요한 시간의 합을 최소로 만들 수는 없다.

줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때, 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램을 작성하시오.
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|5|32|
|3 1 4 3 2||


<br>

### 풀이 방법

* 대표적인 탐욕 문제이다.
* 적게걸리는 사람부터 빠지는게 최솟값이다.
* 정렬 후 값을 더하는 로직을 만들면 된다.

### 기능요구사항

> ***입력 기능***
> - make_input 함수
> - [x] 입력을 받아서 리스트로 반환

> ***정렬 기능***
> - make_sort 함수 구현
> - [x] 퀵정렬로 구현

> ***값을 더하는 기능***
> - make_atm 함수
> - [x] 조건에 맞게 값을 더하는 기능 추가


### 답안 전체코드

```py
#입력기능
def make_input():
    i=0
    result=list()
    while i < 2:
        if i<1:
            people_count = int(input())
            result.append(people_count)
        else:
            withdrawal_time = list(map(int,input().split()))
            result.append(withdrawal_time)
        i += 1
    return result

#정렬기능
def make_sort(withdrawal_time):
    if len(withdrawal_time)<=1:
        return withdrawal_time
    pivot = withdrawal_time[0]
    left = list()
    right = list()
    for index in range(1,len(withdrawal_time)):
        if pivot > withdrawal_time[index]:
            left.append(withdrawal_time[index])
        else:
            right.append(withdrawal_time[index])
    return make_sort(left)+[pivot]+make_sort(right)
#메인 로직 구현(값을 더하는 기능)
def make_atm():
    withdrawal_time = make_sort(make_input()[1])
    pre_time=0
    time_sum=0
    for time in withdrawal_time:
        pre_time += time
        time_sum += pre_time 
    return time_sum
#test code
print(make_atm())
```

</details>

<details>
<summary>backjoon_문제번호 노트정리</summary>

* [문제링크](문제링크)

## 백준 (문제번호)번 (문제이름)

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|1초|256MB|35%|입력조건|출력조건

<br>

### 문제

```
문제 내용
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|예제입력1|예제출력2|
|예제입력2|예제출력2|

<br>

### 문제풀이 전략



### 답안 전체코드



</details>