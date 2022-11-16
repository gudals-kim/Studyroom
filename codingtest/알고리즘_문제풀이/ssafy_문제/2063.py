def 메인함수(testcase,n):
    testcase.sort()
    return testcase[(n//2)]

    


def 입력():
    n = int(input())
    testcase = list(map(int,input().split()))
    return testcase, n

def 출력(testcase,n):
    print(메인함수(testcase,n))


testcase,n = 입력()
출력(testcase,n)
print(9//2)