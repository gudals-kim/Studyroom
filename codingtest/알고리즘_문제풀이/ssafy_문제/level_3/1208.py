dump = int(input())
testcase = list(map(int, input().split()))
i = 0
num = 1
while i < dump:
    testcase[testcase.index(max(testcase))]-=1
    testcase[testcase.index(min(testcase))]+=1
    i+=1
result = max(testcase) - min(testcase)
print("#%d %d"%(num,result))
num+=1