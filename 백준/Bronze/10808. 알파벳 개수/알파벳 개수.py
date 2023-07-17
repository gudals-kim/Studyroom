data = {i:0 for i in range(ord('a'),ord('z')+1)}
for s in input():
    data[ord(s)]+=1
print(" ".join(map(str,data.values())))