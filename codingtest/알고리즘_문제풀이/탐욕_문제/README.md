# 탐욕 문제풀이
#### 풀이 방법
> 프로그램 테스트 케이스와 실행 시간 및 사용 메모리 확인 코드가 들어가 있다.
```python
import time
import datetime
import psutil
import sys
inputData = "예제 입력 데이터 경로를 입력하세요."

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========

    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")
```
## 문제 링크
> 문제를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.

|   구분    |                                                                                                          번호                                                                                                          |   이름   |   난이도   |                                                                           뱃지                                                                            |
|:-------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:------:|:-------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|
|  큐, 탐욕  | [백준 1781번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%9A%95_%EB%AC%B8%EC%A0%9C/docs/backjoon_1781.md) |  컵라면   |  gold2  |  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_2.svg" width="20">  |
| 정렬, 탐욕  | [백준 1461번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%9A%95_%EB%AC%B8%EC%A0%9C/docs/backjoon_1461.md) |  도서관   |  gold5  |  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_5.svg" width="20">  |
| 정렬, 탐욕  | [백준 2212번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%9A%95_%EB%AC%B8%EC%A0%9C/docs/backjoon_2212.md) |   센서   |  gold5  |  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_5.svg" width="20">  |
| 정렬, 탐욕  | [백준 2012번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%9A%95_%EB%AC%B8%EC%A0%9C/docs/backjoon_2012.md) | 등수 매기기 | silver3 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_3.svg" width="20"> |
| 정렬, 탐욕  | [백준 11399번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%9A%95_%EB%AC%B8%EC%A0%9C/docs/backjoon_11399.md) |  ATM   | silver4 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_4.svg" width="20"> |
| 문자열, 탐욕 | [백준 1439번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%9A%95_%EB%AC%B8%EC%A0%9C/docs/backjoon_1439.md) |  뒤집기   | silver5 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_5.svg" width="20"> |
|   탐욕    | [백준 5585번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%9A%95_%EB%AC%B8%EC%A0%9C/docs/backjoon_5585.md) |  거스름돈  | bronze2 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/bronze_2.svg" width="20"> |

