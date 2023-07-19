n, m = map(int,input().split())
data = list(map(int,input().split()))
ans = 0
for idx in range(n):
    sumData = 0
    for jdx in range(idx,n):
        sumData+=data[jdx]
        if sumData>=m:
            if sumData==m:
                ans+=1
            break
print(ans)