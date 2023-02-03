import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐욕_문제/input/backjoon_1439.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    s = input()
    chkZero=0
    chkOne=0
    if s[0]=='1':
        chkZero+=1
    else:
        chkOne+=1
    for index in range(len(s) - 1):
        if s[index]!=s[index+1]:
            if s[index+1]=='1':
                chkZero+=1
            else:
                chkOne+=1
    print(min(chkOne,chkZero))



    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")