import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/재귀_문제/input/input_7490.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print("--------여기부터 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    import copy
    def recursive(array, n):
        if len(array) == n:
            operators_list.append(copy.deepcopy(array))
            return
        array.append(' ')
        recursive(array, n)
        array.pop()
        array.append('+')
        recursive(array, n)
        array.pop()
        array.append('-')
        recursive(array, n)
        array.pop()

    operators_list = []
    n = int(input())
    recursive([], n-1)

    integers = [i for i in range(1, n+1)]
    for operators in operators_list:
        string = ""
        for i in range(n-1):
            string += str(integers[i]) + operators[i]
        string += str(integers[-1])
        if eval(string.replace(" ", ""))==0:
            print(string)
    print()
    # ==================================
    print("--------여기까지 답안 출력입니다.--------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")