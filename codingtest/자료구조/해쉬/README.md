# 해쉬테이블(Hash Table)

## 1. 해쉬 구조

* Hash table : 키(key)에 데이터(value)를 저장하는 데이터 구조이다.
    - key를 통해 바로 데이터를 받아오기 때문에, 속도가 빠르다.
    - 보통 배열로 미리 Hash table 사이즈 만큼 생성 후에 사용한다.(공간과 탐색 시간을 맞바꾸는 기법) 
        * 공간 효율성 낮아짐, 탐색 시간 빨라짐
    - 파이썬에서는 해쉬를 별도 구현 하지않고 딕셔너리 자료형으로 사용된다.

### 1.2 해쉬의 시간복잡도

- 일반적인 경우(Collision이 없는 경우)는 O(1)
- 최악의 경우(Collision이 모두 발생하는 경우)는 O(n)

> 해쉬 테이블의 경우, 일반적인 경우를 기대하고 만들기 때문에, 시간 복잡도는 O(1) 이라고 말할 수 있음

#### 1.2.1 검색에서 해쉬 테이블의 사용 예
- 16개의 배열에 데이터를 저장하고, 검색할 때 O(n)
- 16개의 데이터 저장공간을 가진 위의 해쉬 테이블에 데이터를 저장하고, 검색할 때 O(1)

## 2. 해쉬 용어

* ```해쉬(Hash)```: 임의 값을 고정 길이로 변환하는 것
* ```해쉬 테이블(Hash Table)```: 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
* ```해싱 함수(Hashing Function)```: Key에 대해 산술 연산을 이용해 데이터 위치를 찾을 수 있는 함수
* ```해쉬 값(Hash Value)``` 또는 해쉬 주소(Hash Address): Key를 해싱 함수로 연산해서, 해쉬 값을 알아내고, 이를 기반으로 해쉬 테이블에서 해당 Key에 대한 데이터 위치를 일관성있게 찾을 수 있음
* ```슬롯(Slot)```: 한 개의 데이터를 저장할 수 있는 공간
* 저장할 데이터에 대해 Key를 추출할 수 있는 별도 함수도 존재할 수 있음
<img src="https://www.fun-coding.org/00_Images/hash.png" width=400 />

## 3. 간단한 해쉬 예

* 딕셔너리 자료형을 사용하지 않고 파이썬에서 해쉬 구현하기

### 3.1 hash table 만들기
> 해쉬의 value(값)가 들어가기 위한 hash_table을 list로 만들었다.

```python
#입력
hash_table = list([i for i in range(10)])
print(hash_table)
```
```python
#출력
출력 > [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

```

### 3.2 해쉬 함수 만들기
> 키를 통해 해쉬테이블의 값을 찾기위한 해쉬 함수를 만들어보자.
<br>다양한 해쉬 함수 기법이 있으며, 가장 간단한 방식은 나머지 사용법이다.

```python
#입력
def hash_func(key):
    return key%5

```

* 5의 나머지 0,1,2,3,4 이 hash_table과 매칭된다.

<br>

### 3.3 해쉬 테이블에 값 저장

> 데이터를 그냥 저장하지 않고, key 생성 방법의 정의가 필요하다.
```python
#입력

data1 = 'Andy' #값을 넣을 데이터들
data2 = 'Dave'
data3 = 'Trump'
data4 = 'Anthor'
## ord(): 문자의 ASCII(아스키)코드 리턴
print (ord(data1[0]), ord(data2[0]), ord(data3[0]))
print (ord(data1[0]), hash_func(ord(data1[0])))
print (ord(data1[0]), ord(data4[0]))

```

```python
#출력

출력 > 65 68 84 #각 데이터의 첫 글자의 숫자를 아스키코드로 변경하여 저장한다.
출력 > 65 0
출력 > 65 65 #Andy와 Anthor 와 같이 데이터의 키 값이 같아질 경우도 생각해보자.
```

* 데이터를 저장하는 함수를 만들자(storage_data)

```python
#입력
def storage_data(key_data, value):
    key = ord(key_data[0]) # 키를 받아서 해쉬 키 값을 만든다.
    hash_address = hash_func(key) # 나머지를 구해 해쉬 주소를 지정해준다.
    hash_table[hash_address] = value # 해쉬 테이블[주소] 방식으로 데이터 값을 저장한다.


# 실제 데이터를 넣어보는 코드
storage_data('Andy','01012345678')
storage_data('Dave','01011112222')
storage_data('Trump','01033334444')

```

### 3.4 데이터를 가져오는 코드를 작성하자

```python
def get_data(key_data): 
    key = ord(key_data[0])
    hash_address = hash_func(key)
    return hash_table[hash_address]

#실제 데이터를 가져오는 코드

get_data('Andy')

```

```python
#출력

출력 > 01012345678

#정상적으로 value 데이터를 찾았다. 다만, 같은 키값에 대한 중복 충돌을 해결하지 못했다. 

```

## 4. 자료 구조 해쉬 테이블의 장단점과 주요 용도
- 장점
  - 데이터 저장/읽기 속도가 빠르다. (검색 속도가 빠르다.)
  - 해쉬는 키에 대한 데이터가 있는지(중복) 확인이 쉬움
- 단점 
  - 일반적으로 저장공간이 좀더 많이 필요하다.
  - **여러 키에 해당하는 주소가 동일할 경우 충돌을 해결하기 위한 별도 자료구조가 필요함**
- 주요 용도
  - 검색이 많이 필요한 경우
  - 저장, 삭제, 읽기가 빈번한 경우
  - 캐쉬 구현시 (중복 확인이 쉽기 때문)

<br>

## 5. 충돌 해결 알고리즘

### 5.1 Chaining 기법 
- **개방 해슁 또는 Open Hashing 기법** 중 하나: 해쉬 테이블 저장공간 외의 공간을 활용하는 기법
- 충돌이 일어나면, 링크드 리스트라는 자료 구조를 사용해서, 링크드 리스트로 데이터를 추가로 뒤에 연결시켜서 저장하는 기법

> Chaining 기법을 사용한 충돌해결 코드 <br> 조건 <br> 1. 해쉬함수 : key%8 <br> 2.해쉬 키 생성 : hash(data) #아까 연습의 아스키코드와 같은 역할 

```python
#입력

#Chaining 기법

#1.해쉬테이블 생성
hash_table = list([0 for i in range(8)])

#2. hash 내장함수를 이용한 해쉬 키를 얻는 함수
def get_key(data):
    return hash(data)
#3. 해쉬 함수 정의
def hash_function(key):
    return key % 8
#4. 데이터 저장 함수
def save_data(data, value): # 키 - 벨류 쌍으로 받는다.
    index_key = get_key(data) # 해쉬 키를 가져온다.
    hash_address = hash_function(index_key) #해쉬함수에 키를 이용하여 해쉬 주소를 만든다
    if hash_table[hash_address] != 0: #해쉬 테이블의 해쉬 주소가 빈값이 아닐경우
        for index in range(len(hash_table[hash_address])): 
            if hash_table[hash_address][index][0] == index_key:#만약 첫 데이터가 인덱스 키이면
                hash_table[hash_address][index][1] = value #그 첫 자리에 value 데이터로 바꾼다.
                return
        hash_table[hash_address].append([index_key, value]) #해당하는 데이터가 없다면 key,value 리스트로 넣는다.
    else:
        hash_table[hash_address] = [[index_key, value]]
        #주소가 빈값일 경우 key,value 리스트로 넣는다.
    
def read_data(data):
    index_key = get_key(data) 
    hash_address = hash_function(index_key) 

    if hash_table[hash_address] != 0: #저장된 값이 0이 아닐경우
        for index in range(len(hash_table[hash_address])):
            if hash_table[hash_address][index][0] == index_key:
                return hash_table[hash_address][index][1]
        return None
    else: #저장된값이 없을경우(0인경우)
        return None

print (hash('Dave') % 8)
print (hash('Dd') % 8)
print (hash('Data') % 8)

save_data('Dd','1201023010')
save_data('Data','3301023010')
read_data('Dd')


```
```python
#출력
출력 > 0
출력 > 2
출력 > 2
출력 > 1201023010
```

### 5.2 Linear Probing 기법
- **폐쇄 해슁 또는 Close Hashing 기법** 중 하나: 해쉬 테이블 저장공간 안에서 충돌 문제를 해결하는 기법
- 충돌이 일어나면, 해당 hash address의 다음 address부터 맨 처음 나오는 빈공간에 저장하는 기법
  - 저장공간 활용도를 높이기 위한 기법


> Linear Probling 기법을 사용한 충돌해결 코드 <br> 조건 <br> 1. 해쉬함수 : key%8 <br> 2.해쉬 키 생성 : hash(data) #아까 연습의 아스키코드와 같은 역할 

```python
#입력

hash_table = list([0 for i in range(8)])

def get_key(data):
    return hash(data)

def hash_function(key):
    return key % 8

def save_data(data, value):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    if hash_table[hash_address] != 0:
        for index in range(hash_address, len(hash_table)):
            if hash_table[index] == 0:
                hash_table[index] = [index_key, value]
                return
            elif hash_table[index][0] == index_key:
                hash_table[index][1] = value
                return
    else:
        hash_table[hash_address] = [index_key, value]

def read_data(data):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    
    if hash_table[hash_address] != 0:
        for index in range(hash_address, len(hash_table)):
            if hash_table[index] == 0:
                return None
            elif hash_table[index][0] == index_key:
                return hash_table[index][1]
    else:
        return None

#같은 key값 확인
print (hash('dk') % 8)
print (hash('da') % 8)
print (hash('dc') % 8)

#저장
save_data('dk', '01200123123')
save_data('da', '3333333333')
read_data('dc')
```

```python
#출력
출력 > 4
출력 > 4
출력 > 4

```

#### 5.3 빈번한 충돌을 개선하는 기법
- 해쉬 함수을 재정의 및 해쉬 테이블 저장공간을 확대
- 예:

```python
hash_table = list([None for i in range(16)])

def hash_function(key):
    return key % 16
```

### 참고: 해쉬 함수와 키 생성 함수
- 파이썬의 hash() 함수는 실행할 때마다, 값이 달라질 수 있음
- 유명한 해쉬 함수들이 있음: SHA(Secure Hash Algorithm, 안전한 해시 알고리즘)
  - 어떤 데이터도 유일한 고정된 크기의 고정값을 리턴해주므로, 해쉬 함수로 유용하게 활용 가능

**SHA-1** 사용 코드
```python
  #입력
import hashlib

data = 'test'.encode()
hash_object = hashlib.sha1()
hash_object.update(data)
hex_dig = hash_object.hexdigest()
print (hex_dig)

```
```python
  #출력
출력 > z9421a8fe5ccb1ba61c4c0873d351e987982fbbd3
  
```
**SHA-258** 사용 코드
```python
  #입력
import hashlib

data = 'test'.encode()
hash_object = hashlib.sha256()
hash_object.update(data)
hex_dig = hash_object.hexdigest()
print (hex_dig)
```
```python
  #출력
출력 > 2w35z521584a7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0e00a08
```

### 연습해보기

<div class="alert alert-block alert-warning">
<strong><font color="blue" size="3em">연습4: 연습2의 Chaining 기법을 적용한 해쉬 테이블 코드에 키 생성 함수를 sha256 해쉬 알고리즘을 사용하도록 변경해보기</font></strong><br>
1. 해쉬 함수: key % 8<br>
2. 해쉬 키 생성: hash(data)
</div>

```python
#입력
import hashlib

hash_table = list([0 for i in range(8)])

def get_key(data):
        hash_object = hashlib.sha256()
        hash_object.update(data.encode())
        hex_dig = hash_object.hexdigest()
        return int(hex_dig, 16)

def hash_function(key):
    return key % 8

def save_data(data, value):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    if hash_table[hash_address] != 0:
        for index in range(hash_address, len(hash_table)):
            if hash_table[index] == 0:
                hash_table[index] = [index_key, value]
                return
            elif hash_table[index][0] == index_key:
                hash_table[index][1] = value
                return
    else:
        hash_table[hash_address] = [index_key, value]

def read_data(data):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    
    if hash_table[hash_address] != 0:
        for index in range(hash_address, len(hash_table)):
            if hash_table[index] == 0:
                return None
            elif hash_table[index][0] == index_key:
                return hash_table[index][1]
    else:
        return None
```
```python
#출력

```