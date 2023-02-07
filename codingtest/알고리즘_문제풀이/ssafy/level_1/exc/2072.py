def oddsum(tcase):
    result = 0
    for j in tcase:
        if j%2==1:
            result+=j
    return result
def 입력():
    n = int(input())
    i=0
    testcase = list()
    while i < n:
        inputNums=list(map(int,input().split()))
        testcase.append(inputNums)
        i += 1
    return testcase

def 출력(testcase):
    num=1
    for tcase in testcase:
        result=oddsum(tcase)
        print('#%d %d'%(num,result))
        num+=1

출력(입력())