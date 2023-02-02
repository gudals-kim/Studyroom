# testcase = list(map(int, input().split()))
# numbers = list(map(int,str(testcase[0])))
# count = testcase[1]
def getMaxNums(numbers, count):
    i=0
    while i < count:
        stand = i
        if numbers == sorted(numbers,reverse=True):
            while i < count:
                numbers[-1], numbers[-2] = numbers[-2], numbers[-1]
                i+=1
        else:
            if i >= len(numbers):
                stand = i//len(numbers)
            bigNum_index = stand
            for index in range(len(numbers)-1,stand,-1):
                print("index = %d"%index)
                if numbers[index] > numbers[bigNum_index]:
                    bigNum_index = index
            numbers[bigNum_index], numbers[stand] = numbers[stand], numbers[bigNum_index]
            i += 1
    return numbers

print(getMaxNums([3,2,8,8,8],2))