from itertools import combinations

data = [int(input()) for _ in range(9)]
for answer in list(combinations(data,7)):
    if sum(answer)==100:
        for n in sorted(answer):
            print(n)
        break