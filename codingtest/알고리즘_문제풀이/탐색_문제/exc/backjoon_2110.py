import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐색_문제/input/backjoon_2110.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    집의개수, 공유기의개수 = list(map(int,input().split()))

    집의좌표들=[]
    for _ in range(집의개수):
        집의좌표들.append(int(input()))
    집의좌표들 = sorted(집의좌표들)
    #최소 Gap은 항상 1이다. 집 사이의 최소값이 1이라고 추정하고 풀었다.(문제에 표기가 안되어있음)
    minGap = 1
    #정렬 되어있기 때문에 마지막인덱스와 첫번째 인덱스의 차가 최대 Gap이다.
    maxGap = 집의좌표들[-1] - 집의좌표들[0]
    result = 0

    while (minGap <= maxGap):
        gap = (minGap+maxGap)//2
        value = 집의좌표들[0]
        count = 1
        for i in range(len(집의좌표들)):
            #value + gap 에 가까운값을 찾는다.(gap보다 큰값을 찾는다.)
            if 집의좌표들[i] >= value + gap:
                #value값을 찾은값으로 바꾼다.
                value = 집의좌표들[i]
                #공유기를 설치할 집을 찾았으니 count를 올린다.
                count+=1

        if count >= 공유기의개수:
            minGap = gap+1
            result = gap
        else:# 이 Gap에서 설치할수 있는 공유기의 개수가 찾는 공유기보다 적을경우
            maxGap=gap-1

    print(result)

    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")
