반복 = int(input())
i=0
count = 1
stack = list()
result = list()
while i<반복:
    i+=1
    data = int(input())
    while count<=data:
        stack.append(count)
        count+=1
        result.append("+")
    if data == stack[-1]:
        stack.pop()
        result.append("-")
    else:
        print("NO")
        exit(0)

print('\n'.join(result))