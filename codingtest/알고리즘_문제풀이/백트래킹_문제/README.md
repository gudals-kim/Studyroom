# 백트래킹 문제풀이
> 백 트래킹 기법은 완전 탐색이 필요할 때, 더 이상 나아갈 수 없는 경우 일때 그 전으로 돌아가서 다른 방향을 찾는 기법이다. <br>
> 문제 유형이 많지 않으니 여러번 문제를 풀어서 익숙해지는 것이 중요하다. 또한 bfs 및 dfs와 함께 사용하는 경우가 많다. <br>
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

|       구분        |                                                                                                                  번호                                                                                                                  |   이름   |  난이도  |                                                                          뱃지                                                                           |
|:---------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:------:|:-----:|:-----------------------------------------------------------------------------------------------------------------------------------------------------:|
|   백트래킹, 브루트포스   | [백준 9663번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9_%EB%AC%B8%EC%A0%9C/docs/backjoon_9663.md) |  N-Queen   | gold4 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_4.svg" width="20"> |
|    dfs, 백트래킹    | [백준 1987번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9_%EB%AC%B8%EC%A0%9C/docs/backjoon_1987.md) |  알파벳   | gold4 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_4.svg" width="20"> |
|   백트래킹, 브루트포스   | [백준 1759번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9_%EB%AC%B8%EC%A0%9C/docs/backjoon_1759.md) | 암호 만들기 | gold5 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_5.svg" width="20"> |
