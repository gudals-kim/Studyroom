import sys
data = list()
for _ in range(int(sys.stdin.readline())):
    x,y = map(int,sys.stdin.readline().split())
    data.append((x,y))
data = sorted(data,key=lambda x:(x[1],x[0]))
for x,y in data:
    print(x,y)