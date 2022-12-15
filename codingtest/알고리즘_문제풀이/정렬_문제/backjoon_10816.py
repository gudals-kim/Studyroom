import time
import datetime
import psutil
import sys
def memory_usage():
    p = psutil.Process()
    rss = p.memory_info().rss / 2 ** 20 # Bytes to MB
    return rss
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/정렬_문제/input/input10816.txt"
sys.stdin = open(inputData,"r")
startTime = time.time()
print("--------답안 코드입니다.--------")
# ======== 답안지 작성을 합니다 =========
n = sys.stdin.readline()
nCard = list(map(int,sys.stdin.readline().split()))
m = sys.stdin.readline()
mCard = list(map(int,sys.stdin.readline().split()))

result = {}

for num in nCard:
    if num in result:
        result[num] += 1
    else:
        result[num] = 1
print(' '.join(str(result[x]) if x in result else '0' for x in mCard))
# ==================================
print("--------답안 코드입니다.--------")
endTime = time.time()

print(f"code memory usage  {memory_usage(): 10.5f} MB")
print(f"code execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")