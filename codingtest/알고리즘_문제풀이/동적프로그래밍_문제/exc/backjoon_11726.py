#2xn 타일링

n = int(input())
if n < 3:
    print(n)
else:
    cache = [0 for i in range(n+1)]
    cache[0] = 0
    cache[1] = 1
    cache[2] = 2
    for index in range(3,n+1):
        cache[index] = cache[index-1] + cache[index-2]
    print(cache[n]%10007)