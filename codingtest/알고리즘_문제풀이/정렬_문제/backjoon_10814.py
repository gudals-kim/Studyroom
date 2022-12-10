n = int(input())
data = dict()
for i in range(n):
    data[i] = list(input().split())

data = sorted(data.items(),key=lambda x:int(x[1][0]))

for index,item in data:
    print(" ".join(item))