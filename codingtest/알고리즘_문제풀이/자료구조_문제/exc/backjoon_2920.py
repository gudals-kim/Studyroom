inputData = list(map(int, input().split()))

ascending = 0
descending = 0
for index in range(1,len(inputData)):
    if inputData[index-1]!=inputData[index]+1 and inputData[index-1]!=inputData[index]-1:
        print("mixed")
        break
    elif inputData[index-1]==inputData[index]-1:
        ascending+=1
    elif inputData[index-1]==inputData[index]+1:
        descending+=1

if ascending==7:
    print("ascending")
elif descending==7:
    print("descending")