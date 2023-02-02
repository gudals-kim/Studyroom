def 메인함수(testcase):
    if testcase[0] > testcase[1]:
        return ">"
    elif testcase[0] < testcase[1]:
        return "<"
    else:
        return "="


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
        print("#%d %c"%(n,메인함수(testcase)))
        n+=1
출력(입력())
