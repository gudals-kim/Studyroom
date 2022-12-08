# heapq 

## heapq 모듈이란

heapq 모듈은 이진 트리 기반의 최소 [힙 자료 구조](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/자료구조/힙)를 제공한다!

## 사용법
### import
> 내장 모듈이기 때문에 설치는 따로 안해도 되고 import 해서 사용하면 된다.
```python
import heapq
```
### 힙에 원소 추가(heappush)
> 힙으로 사용할 자료(list)로 선언을 하고 heapq.heappush(저장소, 추가할원소)의 명령어를 사용하면
> 최소 힙구조로 저장이 된다.
```python
import heapq
heap = list()
추가할원소 = 1
heapq.heappush(heap, 추가할원소)
```

### 힙에 원소 출력(heappop)
> 힙 구조로 저장된 자료형을 출력하기 위해선 heappop()을 사용하면 된다.
> 최소 힙이기 때문에 힙 저장소 안에 있는 값중 가장 작은 값부터 출력 후 삭제된다.
```python
import heapq
heap = list()
for 추가할원소 in range(5):
    heapq.heappush(heap, 추가할원소)
for i in range(5):
    heapq.heappop(heap)
#----
출력 > 0 
출력 > 1 
출력 > 2 
출력 > 3 
출력 > 4 
```

### 기존 저장소를 힙으로 변경(heapify)
```python
import heapq

arr = [3, 5, 2, 4]
heapq.heapify(arr)
for i in range(4):
    heapq.heappop(arr)
#----
출력 > 2 
출력 > 3 
출력 > 4 
출력 > 5 
```

### 최대 힙으로 사용
> heapq는 최소 힙만 지원한다.
> 키 값을 음수로 만들어 준 뒤 heapify로 최소힙 정렬 후 다시 양수로 바꾸는 과정으로 
> 최대힙을 구현할 수 있다.

```python
import heapq

max_heap = [1, 2, 3, 4]
reverse = lambda x: x * (-1)
max_heap = list(map(reverse, max_heap)) #[-1,-2,-3,-4]
heapq.heapify(max_heap) #[-4,-3,-2,-1]
max_heap = list(map(reverse, max_heap))#[4,3,2,1]
```