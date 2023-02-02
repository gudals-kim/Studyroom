n = int(input())
data = []
for i in range(n):
    x,y = map(int,input().split())
    data.append((x,y))
data=sorted(data)
for item in data:
    print(item[0], item[1])