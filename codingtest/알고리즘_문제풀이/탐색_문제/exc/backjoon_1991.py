import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐색_문제/input/backjoon_1991.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print("--------여기부터 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    n = int(input())
    tree = {}
    class Node:
        def __init__(self, data, left_node, right_node):
            self.data = data
            self.left_node = left_node
            self.right_node = right_node
    def 전위순회(node):
        print(node.data, end='')
        if node.left_node != '.':
            전위순회(tree[node.left_node])
        if node.right_node != '.':
            전위순회(tree[node.right_node])
    def 중위순회(node):
        if node.left_node != '.':
            중위순회(tree[node.left_node])
        print(node.data, end='')
        if node.right_node != '.':
            중위순회(tree[node.right_node])
    def 후위순회(node):
        if node.left_node != '.':
            후위순회(tree[node.left_node])
        if node.right_node != '.':
            후위순회(tree[node.right_node])
        print(node.data, end='')

    for i in range(n):
        data, left_node, right_node = input().split()
        tree[data] = Node(data, left_node, right_node)
    전위순회(tree['A'])
    print()
    중위순회(tree['A'])
    print()
    후위순회(tree['A'])
    print()
    # ==================================
    print("--------여기까지 답안 출력입니다.--------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")