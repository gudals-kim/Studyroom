# 그래프 탐색 문제풀이

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

|          구분           |                                                                                                                               번호                                                                                                                                |  이름   |   난이도   |                                                                           뱃지                                                                            |
|:---------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----:|:-------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|
|   그래프, BFS, 데이크스트라    | [백준 2665번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EA%B7%B8%EB%9E%98%ED%94%84%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_2665.md) | 미로만들기 |  gold4  |  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_4.svg" width="20">  |
|   그래프, 그래프 탐색, BFS    | [백준 1697번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EA%B7%B8%EB%9E%98%ED%94%84%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1697.md) | 숨바꼭질 | silver1 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_1.svg" width="20"> |
| 그래프, 그래프 탐색, DFS, BFS | [백준 1260번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EA%B7%B8%EB%9E%98%ED%94%84%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1260.md) | DFS와 BFS | silver2 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_2.svg" width="20"> |