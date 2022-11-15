def 평균(tcase):
    return round(sum(tcase)/10)
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
        result=평균(tcase)
        print('#%d %d'%(num,result))
        num+=1

출력(입력())