# 자료구조 문제풀이

## 문제풀이 

> 메모리 검사 코드 

```py
import psutil
def memory_usage(message: str = 'debug'):
    # current process RAM usage
    p = psutil.Process()
    rss = p.memory_info().rss / 2 ** 20 # Bytes to MB
    print(f"[{message}] memory usage: {rss: 10.5f} MB")

memory_usage("#1")
```

> 번호를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.

| 구분  |                                                                                                                   번호                                                                                                                   |이름|난이도|뱃지|
|:---:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:---:|:---:|:---:|
| 문자열 | [백준 10930번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0_%EB%AC%B8%EC%A0%9C/docs/backjoon_10930.md) |SHA|unRanked|<img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/unrank.svg" width="20">|
| 스택,리스트 |  [백준 5397번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0_%EB%AC%B8%EC%A0%9C/docs/backjoon_5397.md)  |키로거|silver2|<img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_2.svg" width="20">|
| 해쉬, 분리집합 |  [백준 4195번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0_%EB%AC%B8%EC%A0%9C/docs/backjoon_4195.md)  |친구 네트워크|gold2|<img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/gold_2.svg" width="20">|
| 단순구현 |  [백준 2920번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0_%EB%AC%B8%EC%A0%9C/docs/backjoon_2920.md)  |음계|bronze2|<img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/bronze_2.svg" width="20">|
| 브루트포스 |  [백준 2798번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0_%EB%AC%B8%EC%A0%9C/docs/backjoon_2798.md)  |블랙잭|bronze2|<img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/bronze_2.svg" width="20">|
| 큐 |  [백준 2966번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0_%EB%AC%B8%EC%A0%9C/docs/backjoon_1966.md)  |프린터 큐|silver2|<img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_2.svg" width="20">|
| 스택 |  [백준 1874번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0_%EB%AC%B8%EC%A0%9C/docs/backjoon_1874.md)  |스택 수열|silver3|<img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_3.svg" width="20">|
| 이분탐색, 정렬 |  [백준 1920번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0_%EB%AC%B8%EC%A0%9C/docs/backjoon_1920.md)  |수 찾기|silver4|<img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/0c61bf1ad9b6434ff624dbab4012654df8c92b01/codingtest/img/rank/silver_4.svg" width="20">|
