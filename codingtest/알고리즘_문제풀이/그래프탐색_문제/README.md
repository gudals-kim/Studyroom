# 그래프 탐색 문제풀이

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