data = int(input())*int(input())*int(input())
mapp = [0]*10
for i in f"{data}":
    mapp[int(i)]+=1
for i in mapp:
    print(i)