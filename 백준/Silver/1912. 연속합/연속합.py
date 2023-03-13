n=int(input())
data = list(map(int,input().split()))
answer = [0] * n
answer[0] = data[0]
for i in range(1,n):
    answer[i] = max(data[i], answer[i-1]+data[i])
print(max(answer))