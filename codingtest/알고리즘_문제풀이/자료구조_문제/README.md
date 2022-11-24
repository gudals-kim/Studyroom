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