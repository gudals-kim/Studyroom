n = list(map(lambda x:int(x[0])%10,input()))
print("".join(map(str,sorted(n,reverse=True))))


