
def 메인함수(testcase):
    return max(testcase)
    


def 입력():
    n = int(input())
    i = 0
    testcaseList = list()
    while i<n: 
        testcaseList.append(list(map(int,input().split())))
        i+=1
    return testcaseList

def 출력(testcaseList):
    n = 1
    for testcase in testcaseList:
        print("#%d %d"%(n,메인함수(testcase)))
        n+=1

출력(입력())


