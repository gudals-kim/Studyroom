# 탐색 문제풀이

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

|      구분       |                                                                                                         번호                                                                                                         |     이름     |   난이도   |                                                                           뱃지                                                                            |
|:-------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------:|:-------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|
| DFS, 그래프, 트리  | [백준 2250번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_2250.md) | 트리의 높이와 너비 |  gold2  |  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/gold_2.svg" width="20">  |
| 위상 정렬, 우선순위 큐 | [백준 1766번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1766.md) |    문제집     |  gold2  |  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/gold_2.svg" width="20">  |
|      탐색       | [백준 1939번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1939.md) |    중량제한    |  gold3  |  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/gold_3.svg" width="20">  |
|  탐욕, 우선순위 큐   | [백준 1715번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1715.md) |  카드 정렬하기   |  gold4  |  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/gold_4.svg" width="20">  |
|      탐색       | [백준 2110번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_2110.md) |   공유기 설치   |  gold5  |  <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/gold_5.svg" width="20">  |
|    트리, 재귀     | [백준 1991번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1991.md) |   트리 순회    | silver1 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_1.svg" width="20"> |
|       힙       | [백준 1927번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1927.md) |    최소 힙    | silver2 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_2.svg" width="20"> |
|    해쉬, 정렬     | [백준 1920번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1920.md) |    수 찾기    | silver4 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_4.svg" width="20"> |
|    브루트 포스     | [백준 1543번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1543.md) |   문서 검색    | silver4 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_4.svg" width="20"> |
|    탐색, 정렬     | [백준 1302번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1302.md) |   베스트셀러    | silver4 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_4.svg" width="20"> |
|      탐색       | [백준 1236번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1236.md) |   성 지키기    | bronze1 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/bronze_1.svg" width="20"> |
|      수학       | [백준 1568번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1543.md) |     새      | bronze2 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/bronze_2.svg" width="20"> |
|      탐색       | [백준 1668번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%ED%83%90%EC%83%89_%EB%AC%B8%EC%A0%9C/docs/backjoon_1668.md) |   트로피 진열   | bronze2 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/bronze_2.svg" width="20"> |
