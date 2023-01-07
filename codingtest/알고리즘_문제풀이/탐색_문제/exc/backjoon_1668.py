import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐색_문제/input/backjoon_1668.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print("--------여기부터 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    datalist = [0]*(int(input()))
    left = 0
    right = 0
    maxNum = 0
    for index in range(len(datalist)):
        data = int(input())
        if maxNum < data:
            maxNum = data
            left+=1
        datalist[index] = data
    maxNum = 0
    for index in range(len(datalist)-1,-1,-1):
        if maxNum < datalist[index]:
            maxNum = datalist[index]
            right += 1
    print(left)
    print(right)
    # ==================================
    print("--------여기까지 답안 출력입니다.--------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")