# SW expert Academy 문제

## 문제풀이 

> 프로그램 테스트 케이스와 실행 시간 및 사용 메모리 확인 코드가 들어가 있다.
```python
import time
import datetime
import psutil
import sys
inputData = "예제 입력 데이터 경로를 입력하세요."

p = psutil.Process()
rss = p.memory_info().rss / 2 ** 20 # Bytes to MB

sys.stdin = open(inputData,"r")
startTime = time.time()
print("--------여기부터 답안 출력입니다.--------")
# ======== 답안지 작성을 합니다 =========



# ==================================
print("--------여기까지 답안 출력입니다.--------")
endTime = time.time()

print(f"code memory usage  {rss: 10.5f} MB")
print(f"code execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
```

> 문제를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.


<br>

### 1단계 문제

---

<details>
<summary>2072_홀수만 더하기 노트정리</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq)

## 삼성 기출문제 2072 홀수만 더하기

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|71%|첫 줄에 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다. 각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.(모든 수는 0이상 10000이하의 정수)|출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.(t는 테스트케이스의 번호이며 1부터 시작한다.)

<br>

### 문제

```
10개의 수를 입력 받아, 그 중에서 홀수만 더한 값을 출력하는 프로그램을 작성하라
```

<br>

|예제입력|예제출력|
|:---:|:---:|
|3||
|3 17 1 39 8 41 2 32 99 2|#1 200|
|22 8 5 123 7 2 63 7 3 46|#2 208|
|6 63 2 3 58 76 21 33 8 1|#3 121|

<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - 홀수만 더하는 함수

2. 입력 처리
    -  input 받은뒤 그 수만큼 반복하여 testcase를 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.


### 답안 전체코드

```python
def oddsum(tcase):
    result = 0
    for j in tcase:
        if j%2==1:
            result+=j
    return result
def 입력():
    n = int(input())
    i=0
    testcase = list()
    while i < n:
        inputNums=list(map(int,input().split()))
        testcase.append(inputNums)
        i += 1
    return testcase

def 출력(testcase):
    num=1
    for tcase in testcase:
        result=oddsum(tcase)
        print('#%d %d'%(num,result))
        num+=1

출력(입력())
```

</details>


<details>
<summary>2071_평균값 구하기 노트정리</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QRnJqA5cDFAUq&categoryId=AV5QRnJqA5cDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=1&pageSize=10&pageIndex=1)

## SW Expert Academy 2071번 평균값 구하기

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|68%|가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.|출력의 각줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

<br>

### 문제

```
10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.

(소수점 첫째 자리에서 반올림한 정수를 출력한다.)
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|3|예제출력2|
|3 17 1 39 8 41 2 32 99 2|#1 24|
|22 8 5 123 7 2 63 7 3 46|#2 29|
|6 63 2 3 58 76 21 33 8 1|#3 27|

<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - 모두 더한뒤 10으로 나누고 round 함수를 이용하여 반올림한다.

2. 입력 처리
    -  input 받은뒤 그 수만큼 반복하여 testcase를 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.


### 답안 전체코드

```py
def 평균(tcase):
    return round(sum(tcase)/10)
def 입력():
    n = int(input())
    i=0
    testcase = list()
    while i < n:
        inputNums=list(map(int,input().split()))
        testcase.append(inputNums)
        i += 1
    return testcase

def 출력(testcase):
    num=1
    for tcase in testcase:
        result=평균(tcase)
        print('#%d %d'%(num,result))
        num+=1

출력(입력())
```

</details>


<details>
<summary>2070_큰 놈, 작은 놈, 같은 놈 노트정리</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QQ6qqA40DFAUq&categoryId=AV5QQ6qqA40DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=1&pageSize=10&pageIndex=1)

## SW Expert Academy 2070번 큰 놈, 작은 놈, 같은 놈

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|82%|문제에표기|문제에표기

<br>

### 문제

```
[문제]

2개의 수를 입력 받아 크기를 비교하여 등호 또는 부등호를 출력하는 프로그램을 작성하라.


[제약 사항]

각 수는 0 이상 10000 이하의 정수이다.


[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 2개의 수가 주어진다.


[출력]

출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|3|예제출력|
|3 8|#1 <|
|7 7|#2 =|
|369 123|#3 >|


<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - 케이스만 나눠준다.

2. 입력 처리
    -  input 받은뒤 그 수만큼 반복하여 testcase를 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.

### 답안 전체코드

```py
def 메인함수(testcase):
    if testcase[0] > testcase[1]:
        return ">"
    elif testcase[0] < testcase[1]:
        return "<"
    else:
        return "="


def 입력():
    n = int(input())
    i = 0
    testcaseList = list()
    while i<n:
        testcaseList.append(list(map(int,input().split())))
        i+=1
    return testcaseList

def 출력(testcaseList):
    n = 1
    for testcase in testcaseList:
        print("#%d %c"%(n,메인함수(testcase)))
        n+=1
출력(입력())
```


</details>


<details>
<summary>2068_최대수 구하기 노트정리</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QQhbqA4QDFAUq&categoryId=AV5QQhbqA4QDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=1&pageSize=10&pageIndex=1)

## SW Expert Academy 2068번 최대수 구하기

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|86%|문제에표기|문제에표기

<br>

### 문제

```
[문제]

10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.


[제약 사항]

각 수는 0 이상 10000 이하의 정수이다.


[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.


[출력]

출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|3|예제출력|
|3 17 1 39 8 41 2 32 99 2|#1 99|
|22 8 5 123 7 2 63 7 3 46|#2 123|
|6 63 2 3 58 76 21 33 8 1|#3 76|

<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - 최대수를 반환한다.

2. 입력 처리
    - input 받은뒤 그 수만큼 반복하여 testcase를 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.


### 답안 전체코드

```py

def 메인함수(testcase):
    return max(testcase)
    


def 입력():
    n = int(input())
    i = 0
    testcaseList = list()
    while i<n: 
        testcaseList.append(list(map(int,input().split())))
        i+=1
    return testcaseList

def 출력(testcaseList):
    n = 1
    for testcase in testcaseList:
        print("#%d %d"%(n,메인함수(testcase)))
        n+=1

출력(입력())



```

</details>


<details>
<summary>2063_중간값 찾기</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QPsXKA2UDFAUq&categoryId=AV5QPsXKA2UDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=1&pageSize=10&pageIndex=1)

## SW Expert Academy 2070번 큰 놈, 작은 놈, 같은 놈

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|78%|문제에표기|문제에표기

<br>

### 문제

```
[문제]

중간값은 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치를 뜻한다.

입력으로 N 개의 점수가 주어졌을 때, 중간값을 출력하라.


[예제]

N이 9 이고, 9개의 점수가 아래와 같이 주어질 경우,

85 72 38 80 69 65 68 96 22

69이 중간값이 된다.


[제약 사항]

1. N은 항상 홀수로 주어진다.

2. N은 9이상 199 이하의 정수이다. (9 ≤ N ≤ 199)


[입력]

입력은 첫 줄에 N 이 주어진다.

둘째 줄에 N 개의 점수가 주어진다.


[출력]

N 개의 점수들 중, 중간값에 해당하는 점수를 정답으로 출력한다.
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|9|예제출력|
|85 72 38 80 69 65 68 96 22|69|


<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - 정렬 후 2로 나누어지는 몫의 인덱스를 반환한다.

2. 입력 처리
    - input 받은뒤 그 수만큼 반복하여 testcase를 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.

### 답안 전체코드

```py
def 메인함수(testcase,n):
    testcase.sort()
    return testcase[(n//2)]

def 입력():
    n = int(input())
    testcase = list(map(int,input().split()))
    return testcase, n

def 출력(testcase,n):
    print(메인함수(testcase,n))


testcase,n = 입력()
출력(testcase,n)

```

</details>

<details>
<summary>2058_자릿수 더하기 노트정리</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QPRjqA10DFAUq&categoryId=AV5QPRjqA10DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=1&pageSize=10&pageIndex=1)

## SW Expert Academy 2058번 자릿수 더하기

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|92%|문제에표기|문제에표기

<br>

### 문제

```
[문제]

하나의 자연수를 입력 받아 각 자릿수의 합을 계산하는 프로그램을 작성하라.


[제약 사항]

자연수 N은 1부터 9999까지의 자연수이다. (1 ≤ N ≤ 9999)


[입력]

입력으로 자연수 N이 주어진다.


[출력]

각 자릿수의 합을 출력한다.
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|6789|30|

<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - 10으로 나눈 나머지를 더한다.
    - n 을 10으로 나눈 몫으로 바꾼다.

2. 입력 처리
    - input=n 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.


### 답안 전체코드

```py
n = int(input())
result = 0
while n>0:
    result += n%10
    n=n//10
print(result)
```

</details>

<details>
<summary>2056_연월일 달력</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QLkdKAz4DFAUq&categoryId=AV5QLkdKAz4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=1&pageSize=10&pageIndex=1)

## SW Expert Academy 2058번 자릿수 더하기

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|62%|문제에표기|문제에표기

<br>

### 문제

```
연월일 순으로 구성된 8자리의 날짜가 입력으로 주어진다.
```

<img src="/main/common/fileDownload.do?downloadType=CKEditorImages&amp;fileId=AV5QOksKA1QDFAUq">

```
해당 날짜의 유효성을 판단한 후, 날짜가 유효하다면

[그림1] 과 같이 ”YYYY/MM/DD”형식으로 출력하고,

날짜가 유효하지 않을 경우, -1 을 출력하는 프로그램을 작성하라.


연월일로 구성된 입력에서 월은 1~12 사이 값을 가져야 하며

일은 [표1] 과 같이, 1일 ~ 각각의 달에 해당하는 날짜까지의 값을 가질 수 있다.
```

```
※ 2월의 경우, 28일인 경우만 고려한다. (윤년은 고려하지 않는다.)
```
<img src="/main/common/fileDownload.do?downloadType=CKEditorImages&amp;fileId=AV5QOw9qA1UDFAUq">

```
[입력]

입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.

다음 줄부터 각 테스트 케이스가 주어진다.


[출력]

테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|5|예제출력|
|22220228|#1 2222/02/28|
|20150002|#2 -1|
|01010101|#3 0101/01/01|
|20140230|#4 -1|
|11111111|#5 1111/11/11|

<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - yyyy/mm/dd 로 나누고
    - 각 yyyy/mm/dd를 검증한다
    - 검증 내용은 31까지인 월과 30까지인 월 28일까지인 월을 구분하고 검증한다.
    - yyyy/mm/dd 로 나올수 있게 전처리를 한다. 1-> 01월 나올수 있도록

2. 입력 처리
    - 테스트 케이스 수만큼 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.


### 답안 전체코드

```py
def 메인함수(testcase):
    #yyyy/mm/dd 로나눠야함
    날짜들 = list()
    dd=testcase%100
    testcase=testcase//100
    mm=testcase%100
    yyyy=testcase//100

    날짜들.append(yyyy)
    날짜들.append(mm)
    날짜들.append(dd) 
    return 날짜들

def 년전처리(숫자):
    if 99 < 숫자 < 1000:
        숫자 = "0%d"%숫자
    elif 9 < 숫자 < 100:
        숫자 = "00%d"%숫자
    elif 0 < 숫자 < 10:
        숫자 = "000%d"%숫자
    else:
        숫자 = "%d"%숫자
    return 숫자

def 월일전처리(숫자):
    if 0 < 숫자 < 10:
        숫자 = "0%d"%숫자
    else:
        숫자 = "%d"%숫자
    return 숫자

def 검증(날짜들):
    삼십일일월 = [1,3,5,7,8,10,12]
    삼십일월 = [4,6,9,11]
    이월 = [2]
    if 날짜들[1] in 삼십일일월 and 0<날짜들[2]<32:
        return True
    elif 날짜들[1] in 삼십일월 and 0<날짜들[2]<31:
        return True
    elif 날짜들[1] in 이월 and 0<날짜들[2]<29:
        return True
    else : return False


def 입력():
    n = int(input())
    i = 0
    testcaseList = list()
    while i<n:
        testcaseList.append(int(input()))
        i+=1
    return testcaseList

def 출력(testcaseList):
    n = 1
    for 날짜들 in testcaseList:
        연월일 = 메인함수(날짜들)
        if 검증(연월일):
            print("#%d %s/%s/%s"%(n,년전처리(연월일[0]),월일전처리(연월일[1]),월일전처리(연월일[2])))
        else:
            print("#%d -1"%n)
        n+=1

출력(입력())
```

</details>


<br>


### 2단계 문제

---


<details>
<summary>1859번 백만 장자 프로젝트 노트정리</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1)

## SW Expert Academy 1859번 백만 장자 프로젝트

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|30%|문제에표기|문제에표기

<br>

### 문제

```
[문제]

25년 간의 수행 끝에 원재는 미래를 보는 능력을 갖게 되었다. 이 능력으로 원재는 사재기를 하려고 한다.

다만 당국의 감시가 심해 한 번에 많은 양을 사재기 할 수 없다.

다음과 같은 조건 하에서 사재기를 하여 최대한의 이득을 얻도록 도와주자.

    1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
    2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
    3. 판매는 얼마든지 할 수 있다.

예를 들어 3일 동안의 매매가가 1, 2, 3 이라면 처음 두 날에 원료를 구매하여 마지막 날에 팔면 3의 이익을 얻을 수 있다.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스 별로 첫 줄에는 자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고,

둘째 줄에는 각 날의 매매가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다.

각 날의 매매가는 10,000이하이다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 최대 이익을 출력한다.


[예제 풀이]

1번째 케이스는 아무 것도 사지 않는 것이 최대 이익이다.

2번째 케이스는 1,2일에 각각 한 개씩 사서 세 번째 날에 두 개를 팔면 10의 이익을 얻을 수 있다.
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|3|testcase개수|
|3|test1|
|10 7 6|#1 0|
|3|test2|
|3 5 9|#2 10|
|5|test3|
|1 1 3 1 2|#3 5|


<br>

### 문제풀이 전략

1. 메인 로직 처리 
    - 역정렬하여 가장 높은수를 만나면 계산한다. 이후 가장높은 수는 삭제한다

2. 입력 처리
    - input 받은뒤 그 수만큼 반복하여 testcase를 받는다.

3. 출력 처리
    - 문제 조건에 맞게 출력한다.

### 답안 전체코드

```py
def 메인함수(testcase):
    j=0
    sum = 0
    result = 0
    maxnums = sorted(testcase,reverse=1)
    for i in testcase:
        sum += i
        j+=1
        max = maxnums[0]
        if max == i:
            result +=((i*j)-sum)
            sum = 0
            j = 0
            del maxnums[0]
    return result

def 입력():
    n = int(input())
    testcaseList = list()
    for i in range(n):
        m = int(input())
        testcaseList.append(list(map(int,input().split())))
    return testcaseList

def 출력(testcaseList):
    num = 1
    for testcase in testcaseList:
        print("#%d %d"%(num,메인함수(testcase)))
        num+=1

출력(입력())

```

</details>

<details>
<summary>1204번 최빈수 구하기</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=PYTHON&select-1=2&pageSize=10&pageIndex=1)

## SW Expert Academy 1204번 최빈수 구하기

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|52%|문제에표기|문제에표기

<br>

### 문제

```
[문제]

어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.

이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을 의미한다.

다음과 같은 수 분포가 있으면,

10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3

최빈수는 8이 된다.

최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).

[제약 사항]

학생의 수는 1000명이며, 각 학생의 점수는 0점 이상 100점 이하의 값이다.
 
[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄부터는 점수가 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.
```


<br>

|예제입력|예제출력|
|:---:|:---:|
|예제입력|예제출력|



<br>

### 문제풀이 전략


- 빈수처리는 dict 자료형을 사용하여 key(점수) :value(출현빈도) 로하여 푼다.
- 만약 출현빈도가 같은게 있다면 더 높은 점수를 출력하자.



### 답안 전체코드

```py
n = int(input())
i = 0
result = list()
while i<n:
    i+=1
    z=input()
    testcase = list(map(int,input().split()))
    indexes = {key : 0 for key in testcase}
    for value in testcase:
        indexes[value]+=1
    keys = [k for k,v in indexes.items() if max(indexes.values()) == v]
    result.append(max(keys))

for index in range(len(result)):
    print("#%d %d"%(index+1,result[index]))

```

</details>

<details>
<summary>1954번 달팽이 숫자 노트정리</summary>

* [문제링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=PYTHON&select-1=2&pageSize=10&pageIndex=1)

## SW Expert Academy 1954번 달팽이 숫자

|시간제한|메모리제한|정답비율|입력조건|출력조건|
|:---:|:---:|:---:|:---:|:---:|
|30초|256MB|52%|문제에표기|문제에표기

<br>

### 문제

```
[문제]
달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.

다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.

[예제]

N이 3일 경우,

N이 4일 경우,
 
[제약사항]

달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)

[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스에는 N이 주어진다.


[출력]

각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

```


<br>

|예제입력|예제출력|
|:---:|:---:|
|입력x|입력x|



<br>

### 문제풀이 전략


- 빈수처리는 dict 자료형을 사용하여 key(점수) :value(출현빈도) 로하여 푼다.
- 만약 출현빈도가 같은게 있다면 더 높은 점수를 출력하자.



### 답안 전체코드

```py


```

</details>