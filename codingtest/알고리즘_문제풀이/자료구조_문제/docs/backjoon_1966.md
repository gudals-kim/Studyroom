# [백준 1966번 프린터 큐](https://www.acmicpc.net/problem/1966)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_3.svg" width="20"> 1966번 프린터 큐

| 시간제한 |메모리제한|정답비율| 난이도 |
|:----:|:---:|:---:|:---:|
|  2초  |128MB|57%| 실버3 |

<br>

### 문제

```
[문제]
여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다.
여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다.
하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.

현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다.
그렇지 않다면 바로 인쇄를 한다.
예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.

여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다.
예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.

[입력]
첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.

테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과, 
몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)이 주어진다.
이때 맨 왼쪽은 0번째라고 하자.
두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다.
중요도는 1 이상 9 이하의 정수이고, 중요도가 같은 문서가 여러 개 있을 수도 있다.

[출력]
각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력한다.

```


<br>

|    예제입력1     | 예제출력1 |
|:-----------:|:-----:|
|      3      |   1   |
|     1 0     |   2   |
|      5      |   5   |
|     4 2     ||
|   1 2 3 4   ||
|     6 0     ||
| 1 1 9 1 1 1 ||



<br>

### 문제풀이 전략

1. 데이터의 개수가 많지 않으므로, 단순히 문제에서 요구하는 대로 구현한다.
2. 현재 리스트에서 가장 큰수가 앞에 올때까지 회전시킨 뒤에 추출한다.
3. 가장 큰 수가 M이면서 가장 앞에 있을 때 프로그램을 종료한다.


#### enumerate() 함수
인덱스(index)와 원소를 동시에 접근하면서 루프를 돌릴 수가 있을까요? 🐍

바로 파이썬의 내장 함수인 enumerate()를 이용하면 되는데요. for 문의 in 뒷 부분을 enumerate() 함수로 한 번 감싸주기만 하면 됩니다.
```python
for entry in enumerate(['A', 'B', 'C']):
    print(entry)

출력 > (0, 'A')
출력 > (1, 'B')
출력 > (2, 'C')
#----------------------
for i, letter in enumerate(['A', 'B', 'C']):
    print(i, letter)
출력 > 0 A
출력 > 1 B
출력 > 2 C
#----------------------
#시작인덱스 변경
for i, letter in enumerate(['A', 'B', 'C'], start=1):
    print(i, letter)
출력 > 1 A
출력 > 2 B
출력 > 3 C
```



### 답안 전체코드

```py
테스트케이스횟수 = int(input())
횟수=0
while 횟수<테스트케이스횟수:
    횟수+=1
    문서개수, pickNum = map(int,input().split())
    중요도리스트 = list(map(int,input().split()))
    queue = [(중요도,인덱스) for 인덱스, 중요도 in enumerate(중요도리스트)]
    중요도집합 = set(중요도리스트)
    count = 0
    if len(중요도리스트) == len(중요도집합):
        뽑아야하는값=중요도리스트[pickNum]
        중요도리스트.sort(reverse=True)
        for i in 중요도리스트:
            count+=1
            if 뽑아야하는값 == i:
                print(count)
                break
    else:
        while True:
            if queue[0][0] == max(queue, key=lambda x: x[0])[0]:
                count+=1
                if queue[0][1]==pickNum:
                    print(count)
                    break
                else:
                    queue.pop(0)
            else:
                queue.append(queue.pop(0))

```
