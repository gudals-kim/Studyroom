import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐욕_문제/input/backjoon_1092.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    input = sys.stdin.readline
    n = int(input())
    최고중량 = sorted(list(map(int, input().split())), reverse=True)
    m = int(input())
    박스무게 = sorted(list(map(int, input().split())), reverse=True)
    result = 0

    # 모든 박스를 옮길 수 없는 경우
    if 최고중량[0] < 박스무게[0]:
        result = -1
    else:
        # 각 크레인이 현재 옮겨야 하는 박스의 번호 (0부터 시작)
        선택한박스 = [0] * n
        # 각 박스를 옮겼는지의 여부
        옮긴박스 = [False] * m
        count = 0

        while True:
            #박스를 다 옮겼으면 종료한다.
            if count == len(박스무게):
                break
            #모든 크레인 대하여 각각 처리
            for 크레인 in range(n):
                while 선택한박스[크레인] < len(박스무게):
                    #아직 안 옮긴 박스 중에서, 옮길 수 있는 박스를 만날 때 까지 반복
                    if not 옮긴박스[선택한박스[크레인]] and 최고중량[크레인]>=박스무게[선택한박스[크레인]]:
                        옮긴박스[선택한박스[크레인]]=True
                        선택한박스[크레인]+=1
                        count+=1
                        break
                    선택한박스[크레인] += 1
            result += 1
    print(result)

    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")