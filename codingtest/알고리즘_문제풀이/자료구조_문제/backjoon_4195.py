부모 = dict()
number = dict()
def find(x):
    if x == 부모[x]:
        return x
    p = find(부모[x])
    부모[x] = p
    return 부모[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x != y:
        부모[y] = x
        number[x] += number[y]

iterNum = int(input())
for i in range(iterNum):
    부모={}
    number={}
    testcase_iterNum = int(input())
    for j in range(testcase_iterNum):
        친구A, 친구B = input().split()

        if 친구A not in 부모:
            부모[친구A] = 친구A
            number[친구A] = 1

        if 친구B not in 부모:
            부모[친구B] = 친구B
            number[친구B] = 1

        union(친구A,친구B)
        print(number[find(친구A)])
