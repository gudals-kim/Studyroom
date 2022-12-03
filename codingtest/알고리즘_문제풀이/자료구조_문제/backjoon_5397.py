testcase_num = int(input())

for num in range(testcase_num):
    left = []
    right = []
    testcase = input()
    for code in testcase:
        if code == '-':
            if left:
                left.pop()
        elif code == '<':
            if left:
                right.append(left.pop())
        elif code == '>':
            if right:
                left.append(right.pop())
        else:
            left.append(code)
    left.extend(reversed(right))
    print("".join(left))