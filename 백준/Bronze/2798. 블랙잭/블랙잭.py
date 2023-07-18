n,m = map(int,input().split())
카드덱 = list(map(int,input().split()))
result = 0

for index in range(len(카드덱)):
    for index2 in range(index+1,len(카드덱)):
        for index3 in range(index2+1,len(카드덱)):
            sum_value = 카드덱[index]+카드덱[index2]+카드덱[index3]
            if sum_value <= m:
                result = max(result, sum_value)

print(result)
