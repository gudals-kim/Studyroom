n = int(input())
data= list(map(int,input().split()))
v=int(input())
print(len([i for i in data if i==v]))