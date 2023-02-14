import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/그래프탐색_문제/input/backjoon_16768.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    from collections import deque
    높이, 이수이상은사라짐 = map(int, input().split())
    data = [list(input()) for _ in range(높이)]
    인접좌표모음 = [(0,1),(0,-1),(-1,0),(1,0)]

    def 얼마나이어지는지확인(현재좌표):
        count = 1
        check[현재좌표[0]][현재좌표[1]] = True
        for 인접좌표 in 인접좌표모음:
            이동좌표 = (현재좌표[0]+인접좌표[0], 현재좌표[1]+인접좌표[1])
            # 옆 건초더미가 없을 경우(조건에 벗어날 경우 넘어간다.) == 현 위치가 모서리인 경우임
            if 이동좌표[0] < 0 or 이동좌표[0] >= 높이 or 이동좌표[1] < 0 or 이동좌표[1] >= 10:
                continue
            if check[이동좌표[0]][이동좌표[1]] or data[현재좌표[0]][현재좌표[1]] != data[이동좌표[0]][이동좌표[1]]:
                #이미 이동한 곳이거나 인접 건초더미가 같은값이 아니라면 넘어간다.
                continue
            #위 경우를 제외한 모든 경우는 옆 건초더미에 가야함
            count += 얼마나이어지는지확인(이동좌표)
        return count

    def dfs(현재좌표, 색상):
        check2[현재좌표[0]][현재좌표[1]] = True
        data[현재좌표[0]][현재좌표[1]] = '0'
        for 인접좌표 in 인접좌표모음:
            이동좌표 = (현재좌표[0]+인접좌표[0], 현재좌표[1]+인접좌표[1])
            if 이동좌표[0] < 0 or 이동좌표[0] >= 높이 or 이동좌표[1] < 0 or 이동좌표[1] >= 10:
                continue
            if check2[이동좌표[0]][이동좌표[1]] or data[이동좌표[0]][이동좌표[1]] != 색상:
                continue
            dfs(이동좌표, 색상)

    def down():
        for i in range(10):
            lst = []
            for j in range(높이):
                if data[j][i] != '0':
                    lst.append(data[j][i])
                    data[j][i] = '0'
            for 이수이상은사라짐 in range(높이-1, 0, -1):
                if lst:
                    data[이수이상은사라짐][i] = lst.pop()
    계속돌까 = True
    while 계속돌까:
        계속돌까 = False
        check = [[False for i in range(10)] for _ in range(높이)]
        check2 = [[False for i in range(10)] for _ in range(높이)]
        for 높이좌표 in range(높이):
            for 넓이좌표 in range(10):
                if data[높이좌표][넓이좌표] =='0' or check[높이좌표][넓이좌표]:
                    continue
                이어진개수 = 얼마나이어지는지확인((높이좌표,넓이좌표))
                if 이어진개수 >= 이수이상은사라짐:
                    dfs((높이좌표,넓이좌표), data[높이좌표][넓이좌표])
                    계속돌까 = True
        down()
    for i in data:
        print(''.join(i))



    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")