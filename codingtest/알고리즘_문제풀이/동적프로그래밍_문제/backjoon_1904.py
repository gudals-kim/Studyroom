import sys
n = int(sys.stdin.readline())

numbers = [0] * 1000001
numbers[1] = 1
numbers[2] = 2
if n > 2:
    for index in range(3,n+1):
        numbers[index] = (numbers[index-1] + numbers[index-2])% 15746
print(numbers[n])