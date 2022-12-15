
# [백준 10816번 숫자카드2](https://www.acmicpc.net/problem/10816)

## <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_4.svg" width="20">  백준 10816번 숫자카드 2 


| 시간제한 | 메모리제한 | 정답비율 | 난이도 | 
|:----:|:-----:|:----:|:---:|
|  1초  | 256MB | 36%  | 실버4 |

<br>

### 문제

```
[문제]
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 
상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 
이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 
넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 
이 수는 공백으로 구분되어져 있다. 
이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

[출력]
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 
각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.

```


<br>

### 예제 입출력

---

#### 예제 입력 1
> 10 <br>
> 6 3 2 10 10 10 -10 -10 7 3 <br>
> 8 <br>
> 10 9 -5 2 3 4 5 -10 <br>
#### 예제 출력 1
> 3 0 0 1 2 0 0 2

---


<br>

### 문제풀이 전략
- 문제 유형
  - 자료 구조, 정렬, 이분 탐색, 해시

### 핵심 아이디어

#### 1. [이분 탐색](https://github.com/gudals-kim/Studyroom/blob/fcf9f797bbe4ad104e4b4e243320d71e95423467/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/%ED%83%90%EC%83%89/README.md) 풀이방법
 - 이분 탐색을 하기 위해 nCard 리스트를 정렬한다.
 - nCard에 있는 요소들이 각각 몇개 있는지 dict 자료형에 담아서 저장해 놓는다.
 - 이분탐색을 진행한다.
   - nCard의 요소인 nNum을 중간 값과 비교한다.
   - nNum이 중간요소가 아닌 경우 : 탐색 범위를 절반으로 나누고 다시 이분 탐색을 한다.
   - nNum이 중간요소인 경우 : start에서 end까지의 범위에서 count() 메소드를 사용해서 몇 개가 있는지 센 후 return

#### 2. [해쉬](https://github.com/gudals-kim/Studyroom/blob/fcf9f797bbe4ad104e4b4e243320d71e95423467/codingtest/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0/%ED%95%B4%EC%89%AC/README.md) 풀이방법
- 해쉬 자료구조의 구현 방식은 Dictionary를 많이 사용합니다.
  - hash맵에서 해당 주소에 값이 없으면 값을 추가합니다.
  - hash맵에서 해당 주소에 값이 있으면 그 값에 추가해줍니다.
<br>
<br>
- 해쉬 방식을 활용해서 N의 값을 순회하면서 해당 값이 없으면 hashmap에 요소를 추가하고 1을 세어줍니다.
- 해당 값이 hashmap에 존재하면 숫자를 1씩 늘려줍니다.
- 모든 N의 요소들을 순회하고 나면 hashmap에는 모든 요소들의 숫자가 세어져 있습니다.

### 답안 전체코드


#### 이분 탐색 풀이방법
```python
from sys import stdin
n = stdin.readline()
nCard = sorted(map(int,stdin.readline().split()))
m = stdin.readline()
mCard = map(int,stdin.readline().split())

def binary(nNum, nCard, start, end):
    if start > end:
        return 0
    pivot = (start+end)//2
    if nNum == nCard[pivot]:
        return nCard[start:end+1].count(nNum)
    elif nNum < nCard[m]:
        return binary(nNum, nCard, start, pivot-1)
    else:
        return binary(nNum, nCard, pivot+1, end)

result = {}
for nNum in nCard:
    start = 0
    end = len(nCard) - 1
    if nNum not in result:
        result[nNum] = binary(nNum, nCard, start, end)

print(' '.join(str(result[x]) if x in result else '0' for x in mCard ))
```


#### 해쉬 풀이방법
```python
import sys

n = sys.stdin.readline()
nCard = list(map(int,sys.stdin.readline().split()))
m = sys.stdin.readline()
mCard = list(map(int,sys.stdin.readline().split()))

result = {}

for num in nCard:
    if num in result:
        result[num] += 1
    else:
        result[num] = 1
print(' '.join(str(result[x]) if x in result else '0' for x in mCard))
```
