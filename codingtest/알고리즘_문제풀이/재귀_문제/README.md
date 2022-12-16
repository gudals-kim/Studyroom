# 재귀 문제풀이

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
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    print("--------여기부터 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    
    # ==================================
    print("--------여기까지 답안 출력입니다.--------")
    endTime = time.time()

    print(f" {T} testCode memory usage  {rss: 10.5f} MB")
    print(f" {T} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
```

> 문제를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.

|    구분    |                                                                                                                         번호                                                                                                                         |   이름   |   난이도   |                                                                           뱃지                                                                            |
|:--------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:------:|:-------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|
|  재귀,DP   | [백준 2747번](https://github.com/gudals-kim/Studyroom/blob/3b0eb6fba4cbe83ad193628ebb56d956bff1e508/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%AC%EA%B7%80_%EB%AC%B8%EC%A0%9C/docs/backjoon_2747.md) | 피보나치 수 | bronze2 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/bronze_2.svg" width="20"> |
| 분할정복, 재귀 | [백준 1074번](https://github.com/gudals-kim/Studyroom/blob/3b0eb6fba4cbe83ad193628ebb56d956bff1e508/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%AC%EA%B7%80_%EB%AC%B8%EC%A0%9C/docs/backjoon_1074.md) |   Z    | silver1 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_1.svg" width="20"> |