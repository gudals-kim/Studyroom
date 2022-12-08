# 정렬 문제풀이

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

> 문제를 클릭하면 각 문제 내용 및 풀이과정이 설명되어 있습니다.

| 구분  |                                                                                                         번호                                                                                                         |   이름   |   난이도   |                                                                           뱃지                                                                            |
|:---:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:------:|:-------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|
| 정렬  | [백준 2750번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_2750.md) | 수 정렬하기 | bronze2 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/bronze_2.svg" width="20"> |
| 정렬  | [백준 1427번](https://github.com/gudals-kim/Studyroom/blob/delevlop/codingtest/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4/%EC%A0%95%EB%A0%AC_%EB%AC%B8%EC%A0%9C/docs/backjoon_1427.md) | 소트인사이트 | silver5 | <img src="https://raw.githubusercontent.com/gudals-kim/Studyroom/3e53104ae0a7a0f6bdc6bd42d7e228dcfd89d937/codingtest/img/rank/silver_5.svg" width="20"> |
