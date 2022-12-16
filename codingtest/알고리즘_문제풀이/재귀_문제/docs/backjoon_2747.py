import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/재귀_문제/input/input_2747.txt"

p = psutil.Process()
rss = p.memory_info().rss / 2 ** 20 # Bytes to MB

sys.stdin = open(inputData,"r")
startTime = time.time()
print("--------여기부터 답안 출력입니다.--------")
# ======== 답안지 작성을 합니다 =========
n = int(sys.stdin.readline())
cache = [0 for i in range(n + 2)]
cache[0] = 0
cache[1] = 1
cache[2] = 1
if n > 2:
    for index in range(3, n + 1):
        cache[index] = cache[index - 1] + cache[index - 2]
print(cache[n])
# ==================================
print("--------여기까지 답안 출력입니다.--------")
endTime = time.time()

print(f"code memory usage  {rss: 10.5f} MB")
print(f"code execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")