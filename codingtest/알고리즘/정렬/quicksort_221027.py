def quicksort(data):
    if len(data) <= 1 :
        return data
    left = list()
    right = list()
    pivot = data[0]

    for index in range(1,len(data)):
        if data[index] < pivot:
            left.append(data[index])
        else:
            right.append(data[index])
    
    return quicksort(left) + [pivot] + quicksort(right)

#test code
import random

data_list = random.sample(range(100), 10)

print(quicksort(data_list))