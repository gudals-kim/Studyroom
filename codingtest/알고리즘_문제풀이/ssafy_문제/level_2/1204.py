n = int(input())
i = 0
result = list()
while i<n:
    i+=1
    z=input()
    testcase = list(map(int,input().split()))
    indexes = {key : 0 for key in testcase}
    for value in testcase:
        indexes[value]+=1
    keys = [k for k,v in indexes.items() if max(indexes.values()) == v]
    result.append(max(keys))

for index in range(len(result)):
    print("#%d %d"%(index+1,result[index]))




