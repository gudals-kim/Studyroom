import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/재귀_문제/input/input_11729.txt"

p = psutil.Process()
rss = p.memory_info().rss / 2 ** 20 # Bytes to MB

sys.stdin = open(inputData,"r")
startTime = time.time()
print("--------여기부터 답안 출력입니다.--------")
# ======== 답안지 작성을 합니다 =========
def hanoi_tower(n, start, end):
    if n == 1:
        print(start, end)
        return

    hanoi_tower(n - 1, start, 6 - start - end)  # 1단계
    print(start, end)  # 2단계
    hanoi_tower(n - 1, 6 - start - end, end)  # 3단계


n = int(input())
print(2 ** n - 1)
hanoi_tower(n, 1, 3)
# ==================================
print("--------여기까지 답안 출력입니다.--------")
endTime = time.time()

print(f"code memory usage  {rss: 10.5f} MB")
print(f"code execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")