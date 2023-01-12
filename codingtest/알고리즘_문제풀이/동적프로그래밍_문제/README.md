# 동적 프로그래밍 문제풀이
> 일반적인 동적 계획법 문제는 통상 코드 자체는 간결하다 <br> **가장 적은 경우의 수부터 계산을 해본 후 패턴을 찾아 점화식** 을 세우는 것이 핵심이다.

## 문제풀이 

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

> 문제를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.

| 구분  |번호|이름|                                                                           난이도                                                                            |뱃지|
|:--:|:---:|:---:|:--------------------------------------------------------------------------------------------------------------------------------------------------------:|:---:|
| dp  |백준 1766번|2xN 타일링|silver3| <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_3.svg" width="20">  |
| dp  |백준 1904번|01타일|silver3|  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_3.svg" width="20"> |


