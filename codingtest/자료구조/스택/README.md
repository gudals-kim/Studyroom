# 스택(Stack)

### 1. 스택 구조
* 데이터를 제한적으로 접근 할 수 있는 구조
    - 데이터를 한쪽 끝에서만 자료를 넣거나 뺄 수 있는 구조이다.
* 가장 나중에 쌓은 데이터를 가장 먼저 빼낼 수 있는 데이터 구조 
    - 큐 : FIFO정책
    - 스택 : LIFO정책

<br>

### 2. 스택의 활용

* 대표적인 스택의 활용
    - 컴퓨터 내부의 프로세스 구조의 함수 동작 방식
    - 함수 호출시 프로세스 실행이 스택과 같은 동작방식이다.

<br>

#### 2.1 재귀 함수로 이해해보기

> 
```
#입력
def recursive(data):
    if data < 0:
        print("end")
    else:
        print(data)
        recursive(data-1) # 재 호출
        print("return",data)
```
```
# 출력
> 출력 4 #recursive(4)의 print(data) 후 recursive(3) 호출
> 출력 3 #recursive(3)의 print(data) 후 recursive(2) 호출
> 출력 2 #recursive(2)의 print(data) 후 recursive(1) 호출
> 출력 1 #recursive(1)의 print(data) 후 recursive(0) 호출
> 출력 0 #recursive(0)의 print(data) 후 recursive(-1) 호출
> 출력 end #recursive(-1) 이니 print("end") 호출
> 출력 return 0 #recursive(0)의 print("return",data) 호출
> 출력 return 1 #recursive(1)의 print("return",data) 호출
> 출력 return 2 #recursive(2)의 print("return",data) 호출
> 출력 return 3 #recursive(3)의 print("return",data) 호출
> 출력 return 4 #recursive(4)의 print("return",data) 호출
```
<br>

### 3. 스택의 장단점과 기능

#### 3.1 스택의 주요 기능

* push() : 데이터를 스택에 넣기
* pop() : 데이터를 스택에서 꺼내기

* ✔ <font color='#BF360C'>Visualgo 사이트에서 시연해보며 이해하기 : https://visualgo.net/en/list</font>

<br>

<img src="http://www.fun-coding.org/00_Images/stack.png"/>

<br>

#### 3.2 스택의 장단점

* 장점
    - 구조가 단순해서, 구현이 쉽다.
    - 데이터 저장/읽기 속도가 빠르다.
* 단점(일반적인 스택 구현시)
    - 데이터 최대 갯수를 미리 정해야한다.
        - 파이썬의 경우 재귀 함수는 1000번까지만 호출 가능하다.
    - 저장 공간의 낭비가 발생할 수 있다.
        - 미리 최대 갯수만큼 저장공간을 확보해야하기 때문이다.

> 스택은 단순하고 빠른 성능을 위해 사용되므로, 보통 배열 구조를 활용해서 구현하는 것이 일반적이다. 이 경우, 위에서 열거한 단점이 있을 수 있다.

<br>

### 4.파이썬 리스트 기능으로 스택 이해하기

* append,pop 메서드 사용

```
#입력
data_stack = list()

data_stack.append(1)
data_stack.append(2)
data_stack.append(3)

data_stack
data_stack.pop()
```
```
#출력
출력 > [1,2,3] #data_stack
출력 > 3 #data_stack.pop()
```

#### 4.1 연습문제
* <font color="#BF360C">리스트 변수로 스택을 다루는 pop, push 기능 구현해보기</font>
    - 요구사항 : pop, push 함수 미사용

```
#입력

stack_list = list()

def push(data):
    stack_list.append(data)
def pop():
    data = stack_list[-1] #list[-1]은 마지막 인덱스를 지칭한다.
    del stack_list[-1]
    return data

for index in range(10): 
    push(index)

pop()

```
```
#출력

출력 > 9 #pop()
```