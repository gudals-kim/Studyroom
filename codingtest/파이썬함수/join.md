## join 함수
문자열 합치기 - join 함수
join함수는 리스트의 문자열들을 합치는 역할을 합니다. 사용법은 아래와 같습니다.

"".join(리스트)
```python
str = "Hi my name is limcoing" 
splitted_str = str.split() 
print(splitted_str) 
출력 > ['Hi', 'my', 'name', 'is', 'limcoing'] 

joined_str = "".join(splitted_str) 
print(joined_str) 
출력 > Himynameislimcoing 
```