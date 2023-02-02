from sys import stdin, stdout

Anum = int(stdin.readline())
Alist = sorted(list(map(int,stdin.readline().split())))
Bnum = stdin.readline()
Blist = list(map(int,stdin.readline().split()))

def search(start, value ,end):
    if  start > end:
        return False
    pivot = (start+end)//2
    if Alist[pivot] > value:
        return search(start, value, pivot-1)
    elif Alist[pivot] < value:
        return search(pivot+1, value, end)
    else:
        return True

for i in Blist:
    if search(0,i,Anum-1):
        print(1)
    else:
        print(0)