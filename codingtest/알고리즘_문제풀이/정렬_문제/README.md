# 정렬 문제풀이

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

|   구분    |                                                                                                          번호                                                                                                          |    이름    |   난이도   |                                                                           뱃지                                                                            |
|:-------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:--------:|:-------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|
|   정렬    |  [백준 2750번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_2750.md)  |  수 정렬하기  | bronze2 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/bronze_2.svg" width="20"> |
|   정렬    |  [백준 1427번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_1427.md)  |  소트인사이트  | silver5 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_5.svg" width="20"> |
|   정렬    | [백준 10814번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_10814.md) |  나이순 정렬  | silver5 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_5.svg" width="20"> |
|   정렬    | [백준 11650번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_11650.md) | 좌표 정렬하기  | silver5 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_5.svg" width="20"> |
|   정렬    | [백준 11651번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_11651.md) | 좌표 정렬하기2 | silver5 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_5.svg" width="20"> |
|   정렬    | [백준 10989번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_10989.md) | 수 정렬하기3  | bronze1 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/bronze_1.svg" width="20"> |
|   정렬    | [백준 10817번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_10817.md) |   세 수    | bronze3 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/bronze_3.svg" width="20"> |
| 정렬,이분탐색 | [백준 10816번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_10816.md) |  숫자카드2   | silver4 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_4.svg" width="20"> |
|  정렬,탐욕  |  [백준 1931번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_1931.md)  |  회의실 배정  | bronze3 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_1.svg" width="20"> |
