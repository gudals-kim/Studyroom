import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/그래프탐색_문제/input/backjoon_10282.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    import heapq

    input = sys.stdin.readline
    def dijkstra(그래프, 시작노드):
        최단거리저장 = {노드 : float('inf') for 노드 in 그래프}
        최단거리저장[시작노드] = 0

        최소힙 = []
        heapq.heappush(최소힙,[최단거리저장[시작노드],시작노드])

        while 최소힙:
            현재노드까지의최단거리, 현재노드 = heapq.heappop(최소힙)
            #최단거리에 저장된 거리가 더 짧다면 수행 필요없음
            if 최단거리저장[현재노드] < 현재노드까지의최단거리:
                continue
            for 다음노드, 현재노드와다음노드의거리 in 그래프[현재노드].items():
                다음노드까지의최단거리 = 현재노드와다음노드의거리 + 현재노드까지의최단거리
                if 다음노드까지의최단거리 < 최단거리저장[다음노드]:
                    최단거리저장[다음노드] = 다음노드까지의최단거리
                    heapq.heappush(최소힙,[다음노드까지의최단거리,다음노드])
        return 최단거리저장

    tCase = int(input())
    for __ in range(tCase):
        #그래프만들기
        컴퓨터개수, 의존성개수, 해킹당한컴퓨터 = map(int,input().split())
        graph = {key : {} for key in range(1,컴퓨터개수+1)}
        for _ in range(의존성개수):
            #a는 b를 의존하며 b에서 a 해킹까지 s초가 걸린다.
            a, b, s = map(int,input().split())
            graph[b][a] = s
        #출력 맞추기
        각컴퓨터별최단해킹시간 = dijkstra(graph,해킹당한컴퓨터)
        result = 0
        maxTime = 0
        for 노드 in 각컴퓨터별최단해킹시간.keys():
            if isinstance(각컴퓨터별최단해킹시간[노드],int):
                result += 1
                if maxTime < 각컴퓨터별최단해킹시간[노드]:
                    maxTime = 각컴퓨터별최단해킹시간[노드]
        print(f"{result} {maxTime}")

    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")