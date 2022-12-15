import sys
sys.stdin = open("/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/정렬_문제/input/input10816.txt","r")

n = sys.stdin.readline()
nCard = list(map(int,sys.stdin.readline().split()))
m = sys.stdin.readline()
mCard = list(map(int,sys.stdin.readline().split()))

result = {}

for num in nCard:
    if num in result:
        result[num] += 1
    else:
        result[num] = 1
print(' '.join(str(result[x]) if x in result else '0' for x in mCard))