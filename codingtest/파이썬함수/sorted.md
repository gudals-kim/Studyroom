# sorted 함수

## sorted 함수란?
파이선 내장 함수로써 [정렬](https://github.com/gudals-kim/Studyroom/tree/delevlop/codingtest/알고리즘/정렬)기능을 제공한다.

## 사용법
### sorted(정렬할데이터)
> 오름차순 정렬 기능 제공
```python
정렬전 = [5,2,4,1]
정렬후 = sorted(정렬전)
# 정렬후 = [1,2,4,5]
```
### sorted(정렬할데이터,reverse파라미터)
> reverse 파라미터를 통해 내림차순 정렬을 할 수 있다.
> reverse=False가 디폴트값이며 오름차순 정렬을 합니다.
> reverse=True 파라미터가 들어올 때 내림차순 정렬을 합니다.
```python
정렬전 = [5,2,4,1]
정렬후 = sorted(정렬전,reverse=True)
# 정렬후 = [5,4,2,1]
```

### sorted(정렬할데이터,key파라미터)
> key파라미터는 어떤 것을 기준으로 정렬할 것에대한 기준이다.
> key값을 기준으로 비교 정렬을 하겠다는 소리이다.
```python
정렬전 = {
    'a':5,
    'b':4,
    'c':3,
    'd':2
       }
정렬후 = sorted(정렬전,key=lambda x:x[1]) 
# 정렬후 = {'d':2,'c':3,'b':4,'a':5}
정렬후 = sorted(정렬전,key=lambda x:x[1],reverse=True) 
# 정렬후 = {'a':5,'b':4,'c':3,'d':2}

정렬전 = {
    1:5,#x[1]/x[0] = 5
    2:4,#x[1]/x[0] = 2
    3:3,#x[1]/x[0] = 1
    4:2 #x[1]/x[0] = 0.5
}

정렬후 = sorted(정렬전,key=lambda x:x[1]/x[0],reverse=True)
# 정렬후 = {1:5,2:4,3:3,4:2}
```

### 리스트.sort()와 sorted(리스트)의 차이점
***리스트.sort()*** 는 ***본체의 리스트를 정렬해서 변환***하는 것이고,
***sorted(리스트)*** 는 본체 리스트는 내버려두고, 정렬한 ***새로운 리스트를 반환***하는 것입니다.