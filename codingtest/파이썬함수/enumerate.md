# enumerate 함수

#### enumerate() 함수
인덱스(index)와 원소를 동시에 접근하면서 루프를 돌릴 수가 있을까요? 🐍

바로 파이썬의 내장 함수인 enumerate()를 이용하면 되는데요. for 문의 in 뒷 부분을 enumerate() 함수로 한 번 감싸주기만 하면 됩니다.
```python
for entry in enumerate(['A', 'B', 'C']):
    print(entry)

#출력 --------------
출력 > (0, 'A')
출력 > (1, 'B')
출력 > (2, 'C')
```
```python
for i, letter in enumerate(['A', 'B', 'C']):
    print(i, letter)
    
#출력 ---------------
출력 > 0 A
출력 > 1 B
출력 > 2 C
```

```python
#시작인덱스 변경
for i, letter in enumerate(['A', 'B', 'C'], start=1):
    print(i, letter)

#출력 ---------------
출력 > 1 A
출력 > 2 B
출력 > 3 C

```
