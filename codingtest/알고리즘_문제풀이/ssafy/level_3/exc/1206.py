def 확인(testcase):
    result = 0
    for index in range(2,len(testcase)-2):
        if testcase[index] > (testcase[index-1]) and testcase[index] > (testcase[index-2]):
            if testcase[index] > (testcase[index+1]) and testcase[index] > (testcase[index+2]):
                result += testcase[index] - max([testcase[index-1],testcase[index-2],testcase[index+1],testcase[index+2]])
    return result

순환 = 0
answers = [0]
while 순환 < 10:
    순환 += 1
    의미없는것 = input()
    testcase = list(map(int,input().split()))
    print("#%d %d"%(순환,확인(testcase)))