import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐욕_문제/input/backjoon_1461.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    import heapq

    책의개수, 한번에들수있는책의양 = map(int,input().split())
    책좌표들 = list(map(int, input().split()))
    오른쪽책 = []
    왼쪽책 = []
    result = 0
    #가장 거리가 먼 책까지의 거리
    가장먼책거리 = max(max(책좌표들), -min(책좌표들))

    # 최대 힙(Max Heap)을 위해 원소를 음수로 구성한다.
    for 책좌표 in 책좌표들:
        #책의 위치가 오른쪽에 있는 경우
        if 책좌표>0:
            #최대 힙을 위해서 음수로 넣는다.
            heapq.heappush(오른쪽책, -책좌표)
        #책의 위치가 왼쪽에 있는 경우
        else:
            heapq.heappush(왼쪽책, 책좌표)

    while 오른쪽책:
        #한 번에 m 개씩 옮길 수 있으므로 m개씩 뺀다.
        # 최대 힙이기 때문에 가장 먼저 나오는 책의 거리만을 더한다.
        result += heapq.heappop(오른쪽책)
        # 위에서 가장 큰값을 뺏으니 나머지 m-1들을 빼준다.
        for 횟수 in range(한번에들수있는책의양-1):
            #오른쪽 좌표가 끝났는데 pop할 수없으니 조건을 걸어준다.
            if 오른쪽책:
                heapq.heappop(오른쪽책)
    while 왼쪽책:
        # 한 번에 m 개씩 옮길 수 있으므로 m개씩 뺀다.
        # 최대 힙이기 때문에 가장 먼저 나오는 책의 거리만을 더한다.
        result += heapq.heappop(왼쪽책)
        # 위에서 가장 큰값을 뺏으니 나머지 m-1들을 빼준다.
        for 횟수 in range(한번에들수있는책의양-1):
            #왼쪽 좌표가 끝났는데 pop할 수없으니 조건을 걸어준다.
            if 왼쪽책:
                heapq.heappop(왼쪽책)
    # 왕복으로 가기때문에 result값을 두배해준다.
    # 단, 가장 먼 책은 한번만 가기 때문에 가장 큰 책의 좌표를 빼준다.
    print(abs(result)*2-가장먼책거리)

    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")