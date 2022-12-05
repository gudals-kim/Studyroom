
# [백준 1874번 스택수열](https://www.acmicpc.net/problem/1874)

## 백준 1874번 스택수열

<img src="https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/img/rank/silver_3.svg">

| 시간제한 |메모리제한|정답비율|입력조건|출력조건|
|:----:|:---:|:---:|:---:|:---:|
|  2초  |128MB|36%|문제에표기|문제에표기|

<br>

### 문제

```
문제
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.

임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
push연산은 +로, pop 연산은 -로 표현하도록 한다.
불가능한 경우 NO를 출력한다.

```


<br>

| 예제입력1 | 예제출력1 |
|:-----:|:-----:|
|   8   |   +   |
|   4   |   +   |
|   3   |   +   |
|   6   |   +   |
|   8   |   -   |
|   7   |   -   |
|   5   |   +   |
|   2   |   +   |
|   1   |   -   |
|       |   +   |
|       |   +   |
|       |   -   |
|       |   -   |
|       |   -   |
|       |   -   |
|       |   -   |

| 예제입력2 | 예제출력2 |
|:-----:|:-----:|
|   5   |  NO   |
|   1   |       |
|   2   |       |
|   5   |       |
|   3   |       |
|   4   |       |



<br>

### 문제풀이 전략
- 문제 유형
  - 스택, 그리디

문제 이해가 관건이다.
1. push를 하면 1부터 차례로 steak에 들어간다는 뜻이다
2. 만약 4를 steak에 넣고 빼고싶으면 push,push,push,push를 해야한다는 소리이다.(+,+,+,+)
3. 4를 꺼내야하니 pop을 해준다 (-)

* 풀이 전략
    1. 스택에 원소를 삽입할 때는, 단순히 특정 수에 도달할 때 까지 삽입하면 된다.
    2. 스택에서 원소를 연달아 빼낼 때 내림차순을 유지할 수 있는지 확인한다. 

### join 함수
문자열 합치기 - join 함수
join함수는 리스트의 문자열들을 합치는 역할을 합니다. 사용법은 아래와 같습니다.

"".join(리스트)
```python
str = "Hi my name is limcoing" 
splitted_str = str.split() 
print(splitted_str) 
출력 > ['Hi', 'my', 'name', 'is', 'limcoing'] 

joined_str = "".join(splitted_str) 
print(joined_str) 
출력 > Himynameislimcoing 
```

### 답안 전체코드

```py
반복 = int(input())
i=0
count = 1
stack = list()
result = list()
while i<반복:
    i+=1
    data = int(input())
    while count<=data:
        stack.append(count)
        count+=1
        result.append("+")
    if data == stack[-1]:
        stack.pop()
        result.append("-")
    else:
        print("NO")
        exit(0)
        
print('\n'.join(result))
```
