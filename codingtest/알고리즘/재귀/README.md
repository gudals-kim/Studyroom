# 재귀(recursive call)

## 1. 재귀 용법이란?

* 함수 안에서 동일한 함수를 호출하는 형태
* 여러 알고리즘 작성시 사용되므로, 확실하게 알아야하는 개념이다.

## 2. 재귀 용법의 이해

* 예제로 풀어보며, 재귀 용법을 이해하는게 제일 빠르다.

### 2.1 예제 - 1 

* 팩토리얼을 구하는 알고리즘을 재귀를 활용하여 작성하라.

    - 분석
        * 2! = 1 x 2
        * 3! = 1 x 2 x 3
        * 4! = 1 x 2 x 3 x 4
    - 규칙 파악
        * n! = n x (n-1)!
        * 함수(n)은 n > 1 이면 return n * 함수(n-1)
        * 함수(n)은 n = 1 이면 return n
    - 검증
        * 2!
            - 함수(2)이면, 2 > 1 이므로 2 x 함수(1)
            - 함수(1)은 1 이므로, return 2 x 1 = 2! 이다.
        * 3!
            - 함수(3)이면, 3 > 1 이므로 3 x 함수(2)
            - 함수(2)이면, 2 > 1 이므로 2 x 함수(1)
            - 함수(1)이면, 1 이므로, return 3 x 2 x 1 = 3!이다.
        * 4!
            - 함수(4)이면, 4 > 1 이므로 4 x 함수(3)
            - 함수(3)이면, 3 > 1 이므로 3 x 함수(2)
            - 함수(2)이면, 2 > 1 이므로 2 x 함수(1)
            - 함수(1)이면, 1 이므로, return 4 x 3 x 2 x 1 = 4!이다.

* 코드로 작성해보기
```python
def factorial(num):
    if num > 1:
        return num * factorial(num-1)
    else: return num
```


* 이 코드의 시간 복잡도와 공간 복잡도
    - factorial(n)은 n-1 번의 factorial() 함수를 호출한다.
        * n-1번 반복문을 호출한것과 같다
        * factorial(n) 함수를 호출 할때마다 지역변수 n이 생성된다.
    - 시간복잡도는 O(n-1) = **O(n)**
    - 공간복잡도는 O(n-1) = **O(n)**

### 3. 재귀와 스택

* 재귀 함수는 스택의 전형적인 예이다.
    - 함수는 내부적오르 스택처럼 관리된다.
    <img src="https://www.fun-coding.org/00_Images/recursivecall.png" />
    - 재귀 호출이 이해가 가지 않는다면? 
    - [코드분석]( http://pythontutor.com/live.html#code=%23%20factorial%20%ED%95%A8%EC%88%98%20%EC%95%88%EC%97%90%EC%84%9C%20factorial%20%ED%95%A8%EC%88%98%EB%A5%BC%20%ED%98%B8%EC%B6%9C%0Adef%20factorial%28num%29%3A%0A%20%20%20%20if%20num%20%3E%201%3A%0A%20%20%20%20%20%20%20%20return%20num%20*%20factorial%28num%20-%201%29%0A%20%20%20%20else%3A%0A%20%20%20%20%20%20%20%20return%20num%0A%0Afactorial%285%29&cumulative=false&curInstr=22&heapPrimitives=false&mode=display&origin=opt-live.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false)
    
> 참고: 파이썬에서 재귀 함수는 깊이가(한번에 호출되는...) 1000회 이하가 되어야 함

### 4. 재귀를 활용한 프로그래밍 연습

* **예제 1)** 다음 multiple 함수를 활용하여 1 부터 num 까지의 곱이 출력되게 만들어라. 빈칸을 채우시오

```python
#예제
def multiple(data):
    if data <= 1 :
        return data
    return (빈칸)
```

<br>

```python
#입력

def multiple(data):
    if data <= 1:
        return data
    return data * multiple(data - 1)

```

* **예제 2)** 숫자가 들어있는 리스트가 주어졌을 때, 리스트의 합을 리턴하는 함수를 만들어라.
    - 임의 값의 리스트가 주어진다
    - 재귀 함수를 이용하라

```python
import random
data = random.sample(range(100),10)

def list_sum(data):
    if len(data) ==  1:
        return data[0]
    return data[0] + list_sum(data[1:])
```

* 예제 검증
    - [5,2,6,3,3] 의 데이터 
        * cycle 1. len([5,2,6,3,3]) = 5 이기 때문에 return 5 + list_sum([2,6,3,3])
        * cycle 2. len([2,6,3,3]) = 4 이기 때문에 return 2 + list_sum([6,3,3])
        * cycle 3. len([6,3,3]) = 3 이기 때문에
        return 6 + list_sum([3,3])
        * cycle 4. len([3,3]) = 2 이기 때문에 
        return 3 + list_sum([3])
        * cycle 5. len([3]) = 1이기 때문에 
        return 3
        * 출력에는 리스트의 합 3+3+6+2+5 = 19 

<br>

* **예제 3)** 회문(palindrome)은 순서를 거꾸로 읽어도 제대로 읽은 것 같은 단어와 문장을 의미한다.
회문을 판별할 수 있는 함수를 재귀함수를 활용하여 만들어라.

    <img src="https://www.fun-coding.org/00_Images/palindrome.png" width=200/>

    - 참고
    ```python
        #참고 - 리스트 슬라이싱
        string = 'Dave' 
        string[-1] --> e
        string[0] --> D
        string[1:-1] --> av
        string[:-1] --> Dav
    ```

```python
#예제3 입력
def palindrome(string):
    if len(string) <= 1:
        return True

    if string[0] == stirng[-1]:
        return palindrome(string[1:-1])
    else:
        return False
```

<br>

* 예제 4) 아래의 알고리즘에 의해 정수 n을 입력 받아 1이 되는 과정을 모두 출력하는 함수를 작성하라.
    - 1. 정수 n에 대해
    - 2. n이 홀수이면 3 x n+1을 하고
    - 3. n이 짝수이면 n을 2로 나눈다.
    - 4. n이 1이 될때까지 반복한다.
    - 예) n에 3을 넣었을 경우
    ```python
    #예
    3 
    10
    5
    16
    8
    4
    2
    1
    ```

```python
#예제4 입력

def func(n):
    if n == 1:
        return n
    if n%2 == 1:
        return func((3*n)+1)
    elif n%2 == 0:
        return func(int(n//2))
```

<br>

* **예제 5)** 정수 4를 1, 2, 3 의 조합을 나타내는 방법은 다음과 같이 총 7가지 이다.
    - 1 + 1 + 1 + 1
    - 1 + 1 + 2
    - 1 + 2 + 1 
    - 2 + 1 + 1
    - 2 + 2
    - 1 + 3
    - 3 + 1
* 정수 n이 입력으로 주어졌을 때, n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 구하시오
    - 힌트: 정수 n을 만들 수 있는 경우의 수를 리턴하하는 함수가 
    f(n)이면
    - f(n)은 f(n-1)+f(n-2)+f(n-3) 과 동일하다는 패턴 찾기

```python
#예제5 입력

def func(data):
    if data == 1:
        return 1
    elif data == 2:
        return 2
    elif data == 3:
        return 4
    
    return func(data -1) + func(data - 2) + func(data - 3)
```