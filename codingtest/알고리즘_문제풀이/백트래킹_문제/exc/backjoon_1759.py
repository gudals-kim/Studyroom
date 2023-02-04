import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/백트래킹_문제/input/backjoon_1759.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    from itertools import combinations

    vowels = ('a', 'e', 'i', 'o', 'u')
    l, c = map(int, input().split(' '))

    # 가능한 암호를 사전식으로 출력해야 하므로 정렬 수행
    array = input().split(' ')
    array.sort()

    # 길이가 l인 모든 암호 조합을 확인
    for password in combinations(array, l):
        # 모음의 개수를 세기
        count = 0
        for i in password:
            if i in vowels:
                count += 1

        # 최소 한 개의 모음과 최소 두 개의 자음이 있는 경우 출력
        if count >= 1 and count <= l - 2:
            print(''.join(password))
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")