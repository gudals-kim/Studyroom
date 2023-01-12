import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐색_문제/input/backjoon_2250.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print("--------여기부터 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    class Node:
        def __init__(self, number, left_node, right_node):
            self.parent = -1
            self.number = number
            self.left_node = left_node
            self.right_node = right_node

    def 중위순회(node, level):
        global level_depth, x
        level_depth = max(level_depth, level)
        if node.left_node != -1:
            중위순회(tree[node.left_node], level+1)
        level_min[level] = min(level_min[level], x)
        level_max[level] = max(level_max[level], x)
        x += 1
        if node.right_node != -1:
            중위순회(tree[node.right_node], level+1)
    input=sys.stdin.readline
    n = int(input())
    tree = {}
    level_min = [n]
    level_max = [0]
    root = -1
    x = 1
    level_depth = 1

    for i in range(1, n + 1):
        tree[i] = Node(i, -1, -1)
        level_min.append(n)
        level_max.append(0)

    for _ in range(n):
        number, left_node, right_node = map(int, input().split())
        tree[number].left_node = left_node
        tree[number].right_node = right_node
        if left_node != -1:
            tree[left_node].parent = number
        if right_node != -1:
            tree[right_node].parent = number

    for i in range(1, n + 1):
        if tree[i].parent == -1:
            root = i

    중위순회(tree[root], 1)

    result_level = 1
    result_width = level_max[1] - level_min[1] + 1
    for i in range(2, level_depth + 2):
        width = level_max[i] - level_min[i] + 1
        if result_width < width:
            result_revel = i
            result_width = width
    print(result_revel, result_width)
    # ==================================
    print("--------여기까지 답안 출력입니다.--------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")