import sys

data = list()
for _ in range(int(sys.stdin.readline())):
    x,y = map(int,sys.stdin.readline().split())
    data.append((x,y))
data = sorted(data, key=lambda x: (x[1], x[0]))
count = 1
end_time = data[0][1]
for time in data[1:]:
    if time[0] >= end_time:
        count+=1
        end_time = time[1]
print(count)
