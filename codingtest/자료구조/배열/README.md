# 배열(Array)

- 데이터를 나열하고, 각 데이터를 인덱스에 대응하도록 구성한 데이터 구조
- 파이썬에서는 리스트 타입이 배열 기능을 제공하고 있다.
 
<br>
<br>

## 1. 배열이 왜 필요할까?

- 같은 종류의 데이터를 효율적으로 관리하기 위해 사용된다.
- 같은 종류의 데이터를 순차적으로 저장한다.

<br>
<br>

## 2. 배열의 장점

- 인덱스로 인한 빠른 접근이 가능하다.
- 첫 데이터의 위치에서 상대적인 위치로 데이터 접근 (인덱스 번호로 데이터에 접근한다.)

<br>
<br>

## 3. 배열의 단점

- 데이터 추가/삭제가 어렵다.
- 미리 데이터의 최대길이를 지정해야한다.(공간의 낭비가 있을 수 있다.)

<br>
<br>

## 4. 파이썬에서의 배열
- 파이썬 리스트를 활용한다.
<br>
<br>

### 1차원 배열
#### 입력
```
data = [1,2,3,4,5]
print (data)
```
#### 출력
```
[1,2,3,4,5]
```
### 2차원 배열
#### 입력
```
data = [[1,2,3],[4,5,6],[7,8,9]]
print(data)
print(data[0])
print(data[1][2])
print(data[2][0])
```
#### 출력
```
[[1,2,3],[4,5,6],[7,8,9]] #data
[1,2,3] #data[0]
6 #data[1][2]
7 #data[2][0]
```

### 파이썬 배열 기초 문제
#### _다음 dataset 에서 전체 이름 안에 M이 몇번 나왔는지 빈도수를 출력하라._
```
dataset = ['Braund, Mr. Owen Harris',
'Cumings, Mrs. John Bradley (Florence Briggs Thayer)',
'Heikkinen, Miss. Laina',
'Futrelle, Mrs. Jacques Heath (Lily May Peel)',
'Allen, Mr. William Henry',
'Moran, Mr. James',
'McCarthy, Mr. Timothy J',
'Palsson, Master. Gosta Leonard',
'Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)',
'Nasser, Mrs. Nicholas (Adele Achem)',
'Sandstrom, Miss. Marguerite Rut',
'Bonnell, Miss. Elizabeth',
'Saundercock, Mr. William Henry',
'Andersson, Mr. Anders Johan',
'Vestrom, Miss. Hulda Amanda Adolfina',
'Hewlett, Mrs. (Mary D Kingcome) ',
'Rice, Master. Eugene',
'Williams, Mr. Charles Eugene',
'Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)',
'Masselmani, Mrs. Fatima',
'Fynney, Mr. Joseph J',
'Beesley, Mr. Lawrence',
'McGowan, Miss. Anna "Annie"',
'Sloper, Mr. William Thompson',
'Palsson, Miss. Torborg Danira',
'Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)',
'Emir, Mr. Farred Chehab',
'Fortune, Mr. Charles Alexander',
'Dwyer, Miss. Ellen "Nellie"',
'Todoroff, Mr. Lalio']
```
#### 입력
```
빈도수 = 0
for data in dataset:
    for i in reange(len(data)):
        if data[i] == 'M' :
            빈도수 += 1
print(빈도수)
```
#### 출력
```
38
```