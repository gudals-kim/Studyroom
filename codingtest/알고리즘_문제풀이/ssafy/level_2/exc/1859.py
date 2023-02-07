def main(testcase):
    j=0
    sum = 0
    result = 0
    maxnums = sorted(testcase,reverse=1)
    for i in testcase:
        sum += i
        j+=1
        max = maxnums[0]
        if max == i:
            result +=((i*j)-sum)
            sum = 0
            j = 0
            del maxnums[0]
    return result

def testin():
    n = int(input())
    testcaseList = list()
    for i in range(n):
        m = int(input())
        testcaseList.append(list(map(int,input().split())))
    return testcaseList

def out(testcaseList):
    num = 1
    for testcase in testcaseList:
        print("#%d %d"%(num,main(testcase)))
        num+=1

out(testin())